package com.itba.sentiment.twitter.messages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.itba.sentiment.persistance.JsonPersistenceService;
import com.itba.sentiment.twitter.authentication.TwitterAccess;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;
import twitter4j.UserMentionEntity;

public class TwitterMessageService {

	private static DBCollection items;
	static JsonPersistenceService jps = new JsonPersistenceService("mongodb://localhost:27017", "TwitterDB");

	public static List<String> getTweetByQuery(boolean loadRecords, String keyword, int limit) throws InterruptedException {

		Twitter twitter = TwitterAccess.getInstance().getTwitterObj();
		int totalTweets = 0;
		long maxID = -1;

		if (twitter != null) {

			try {
				Query query = new Query(keyword);
				query.setCount(100);
				QueryResult result;
				Map<String, RateLimitStatus> rateLimitStatus = twitter.getRateLimitStatus("search");
				int resultSize = 1;

				// This finds the rate limit specifically for doing the search
				// API call we use in this program
				RateLimitStatus searchTweetsRateLimit = rateLimitStatus.get("/search/tweets");

				System.out.printf("You have %d calls remaining out of %d, Limit resets in %d seconds\n",
						searchTweetsRateLimit.getRemaining(), searchTweetsRateLimit.getLimit(),
						searchTweetsRateLimit.getSecondsUntilReset());
				for (int queryNumber = 0; queryNumber < 180 && resultSize != 0 && totalTweets<=limit; queryNumber++) 
				{
					System.out.printf("\n\n!!! Starting loop %d\n\n", queryNumber);
					ArrayList<String> jsonTweets = new ArrayList<String>();

					if (searchTweetsRateLimit.getRemaining() == 0) {

						System.out.printf("!!! Sleeping for %d seconds due to rate limits\n",
								searchTweetsRateLimit.getSecondsUntilReset());

						Thread.sleep((searchTweetsRateLimit.getSecondsUntilReset() + 2) * 1000l);
					}
					result = twitter.search(query);
					
					System.out.println("Getting Tweets...");
					List<Status> tweets = result.getTweets();
					resultSize = result.getTweets().size();
					totalTweets += resultSize;
					System.out.println("Tweets processed in loop: "+resultSize);
					
					//process and persist: 
					for (Status tweet : tweets) {
						if (maxID == -1 || tweet.getId() < maxID) {
							maxID = tweet.getId();
						}
						String json = TwitterObjectFactory.getRawJSON(tweet);						
						jsonTweets.add(json);
					}
					try {
						jps.persistJsonStringArray(jsonTweets, "tweetsfinal");
					} catch (Exception e) {
						System.out.println("MongoDB Connection Error : " + e.getMessage());
					}
				}

			} catch (TwitterException te) {
				System.out.println("te.getErrorCode() " + te.getErrorCode());
				System.out.println("te.getExceptionCode() " + te.getExceptionCode());
				System.out.println("te.getStatusCode() " + te.getStatusCode());
				if (te.getStatusCode() == 401) {
					System.out.println(
							"Twitter Error : \nAuthentication credentials (https://dev.twitter.com/pages/auth) were missing or incorrect.\nEnsure that you have set valid consumer key/secret, access token/secret, and the system clock is in sync.");
				} else {
					System.out.println("Twitter Error : " + te.getMessage());
				}

			}
		} else {
			System.out.println("Not connected to Twitter...");
		}
		System.out.println("Tweets processed: "+totalTweets);
		return null;
	}

	public static void getTweetsRecords() throws InterruptedException {
		BasicDBObject fields = new BasicDBObject("_id", true).append("user_name", true).append("tweet_text", true);
		DBCursor cursor = items.find(new BasicDBObject(), fields);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

	}

}
