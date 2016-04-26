package com.itba.sentiment.twitter.authentication;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAccess {
	private Twitter twitterObj = null;
	 private static TwitterAccess instance = new TwitterAccess();

	 private TwitterAccess(){
		 if (twitterObj == null) {
			 	ConfigurationBuilder cb = new ConfigurationBuilder();
			    cb.setJSONStoreEnabled(true);
				TwitterFactory factory = new TwitterFactory(cb.build());
				AccessToken accessToken = loadAccessToken();
				twitterObj = factory.getInstance();
				twitterObj.setOAuthConsumer("eDYfkKy1HtVDZpo2SP0tLqAce",
						"v9RGlAiKi8Txl4TTImH4IxHDiojp8cDUDnHuZTeIbk8Y2f0elq");
				twitterObj.setOAuthAccessToken(accessToken);
			}
	 }
	 
	public static TwitterAccess getInstance() {
		return instance;
	}

	private static AccessToken loadAccessToken() {
		String token = "130023025-SBsjdMO2xIAttvnhbvL9LUSyHmO9npgqHulkf8xe";
		String tokenSecret = "w68QCqrcErz5qExfEKXyGUTWVKObH8ig0HBL1e9ZM1fbg";
		return new AccessToken(token, tokenSecret);
	}

	public Twitter getTwitterObj() {
		return twitterObj;
	}

}
