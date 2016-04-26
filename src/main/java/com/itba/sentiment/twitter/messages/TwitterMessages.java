package com.itba.sentiment.twitter.messages;

import java.util.List;

import org.bson.Document;

import com.itba.sentiment.twitter.authentication.TwitterAccess;
import com.itba.sentiment.utils.JsonHelper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.UserMentionEntity;

public class TwitterMessages {

	private static DBCollection items;

	public static void getTweetByQuery(boolean loadRecords, String keyword) throws InterruptedException {

		Twitter twitter = TwitterAccess.getInstance().getTwitterObj();
		if (twitter != null) {

			try {
				Query query = new Query(keyword);
				query.setCount(100);
				QueryResult result;
				result = twitter.search(query);
				System.out.println("Getting Tweets...");
				List<Status> tweets = result.getTweets();

				for (Status tweet : tweets) {
					Document basicObj = new Document();
					basicObj.put("user_name", tweet.getUser().getScreenName());
					basicObj.put("retweet_count", tweet.getRetweetCount());
					basicObj.put("tweet_followers_count", tweet.getUser().getFollowersCount());
					basicObj.put("source", tweet.getSource());
					// basicObj.put("coordinates",tweet.getGeoLocation());

					UserMentionEntity[] mentioned = tweet.getUserMentionEntities();
					basicObj.put("tweet_mentioned_count", mentioned.length);
					basicObj.put("tweet_ID", tweet.getId());
					basicObj.put("tweet_text", tweet.getText());
					
					try {
						JsonHelper.printJson(basicObj);
					} catch (Exception e) {
						System.out.println("MongoDB Connection Error : " + e.getMessage());

					}
				}

				// Printing fetched records from DB.
				if (loadRecords) {
					getTweetsRecords();
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
			System.out.println("MongoDB is not Connected! Please check mongoDB intance running..");
		}
	}

	public static void getTweetsRecords() throws InterruptedException {
		BasicDBObject fields = new BasicDBObject("_id", true).append("user_name", true).append("tweet_text", true);
		DBCursor cursor = items.find(new BasicDBObject(), fields);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

	}

}
