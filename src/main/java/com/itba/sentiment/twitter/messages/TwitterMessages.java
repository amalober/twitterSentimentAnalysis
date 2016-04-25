package com.itba.sentiment.twitter.messages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UserMentionEntity;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterMessages {

	private ConfigurationBuilder cb;
	private DB db;
	private DBCollection items;
	private MongoClient mongo;

	public void connectdb(String keyword) {
		try {
			// on constructor load initialize MongoDB and load collection
			initMongoDB();
			items = db.getCollection(keyword);

			// make the tweet_ID unique in the database
			BasicDBObject index = new BasicDBObject("tweet_ID", 1);
			items.createIndex(index, new BasicDBObject("unique", true));

		} catch (MongoException ex) {
			System.out.println("MongoException :" + ex.getMessage());
		}

	}

	public void initMongoDB() throws MongoException {

		System.out.println("Connecting to Mongo DB..");
		mongo = new MongoClient("127.0.0.1");
		db = mongo.getDB("tweetDB");
		mongo.close();

	}

	public void tearDownMongoDB() throws MongoException {

		System.out.println("Closing Mongo DB Connection..");
		mongo.close();

	}

	public void loadMenu() throws InterruptedException {

		String keyword = "tweetDB";
		String result = "";
		InputStream inputStream=null;

		connectdb(keyword);

		int i = 0;

		while (i < 1) {
			cb = new ConfigurationBuilder();
			// cb.setDebugEnabled(true);
			// cb.setOAuthConsumerKey("eDYfkKy1HtVDZpo2SP0tLqAce ");
			// cb.setOAuthConsumerSecret("v9RGlAiKi8Txl4TTImH4IxHDiojp8cDUDnHuZTeIbk8Y2f0elq");
			// cb.setOAuthAccessToken("130023025-LylYXMI7IFOWOonCCkk34j7iaqpTD5z8o6UfmPG7");
			// cb.setOAuthAccessTokenSecret("fB6836wdSiNDxtZPWGAXWnnrK8wCaDGSi3jDS0W5QigOe");
			try {
				Properties prop = new Properties();
				String propFileName = "twitter4j.properties";

				inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

				if (inputStream != null) {
					prop.load(inputStream);
				} else {
					throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				}

				// get the property value and print it out
				cb.setDebugEnabled(Boolean.valueOf((prop.getProperty("debug"))));
				cb.setOAuthConsumerKey(prop.getProperty("oauth.consumerKey"));
				cb.setOAuthConsumerSecret(prop.getProperty("oauth.consumerSecret"));
				cb.setOAuthAccessToken(prop.getProperty("oauth.accessToken"));
				cb.setOAuthAccessTokenSecret(prop.getProperty("oauth.accessTokenSecret"));
			} catch (Exception e) {
				System.out.println("Exception: " + e);
				throw new InterruptedException();
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		getTweetByQuery(true, keyword);
		cb = null;

		// Thread.sleep(60 * 1000); // wait

	}

	public void getTweetByQuery(boolean loadRecords, String keyword) throws InterruptedException {

		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		if (cb != null) {

			try {
				Query query = new Query(keyword);
				query.setCount(100);
				QueryResult result;
				result = twitter.search(query);
				System.out.println("Getting Tweets...");
				List<Status> tweets = result.getTweets();

				for (Status tweet : tweets) {
					BasicDBObject basicObj = new BasicDBObject();
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
						items.insert(basicObj);
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

	public void getTweetsRecords() throws InterruptedException {
		BasicDBObject fields = new BasicDBObject("_id", true).append("user_name", true).append("tweet_text", true);
		DBCursor cursor = items.find(new BasicDBObject(), fields);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

	}

}
