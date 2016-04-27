package com.itba.sentiment.twitter.messages;

import java.time.LocalDateTime;

import com.itba.sentiment.analysis.DocSentiment;
import org.bson.types.ObjectId;

public class TwitterMessage {

	private static final String baseURL = "https://twitter.com/BocaJrsOficial/status/";

	private LocalDateTime date;
	private String username;
	private String tweetid;
	private String URL;
	private String text;
	private String datestr;
	private DocSentiment sentiment;
	private ObjectId id;
	

	public TwitterMessage(org.bson.Document tweet) {
		this.username = tweet.getString("user.screen_name");
		this.tweetid = tweet.getString("id_str");
		this.URL = baseURL+this.tweetid;
		this.text = tweet.getString("text");
		this.datestr = tweet.getString("created_at");
		this.id= (ObjectId)tweet.get("_id");
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return tweetid;
	}

	public void setId(String id) {
		this.tweetid = id;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public DocSentiment getSentiment() {
		return sentiment;
	}

	public void setSentiment(DocSentiment sentiment) {
		this.sentiment = sentiment;
	}

	public static String getBaseurl() {
		return baseURL;
	}

	public String getDatestr() {
		return datestr;
	}

	public void setDatestr(String datestr) {
		this.datestr = datestr;
	}

	public String getTweetid() {
		return tweetid;
	}

	public void setTweetid(String tweetid) {
		this.tweetid = tweetid;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"tweet_id\":\"");
		builder.append(tweetid);
		builder.append("\", \"message\":\"");
		builder.append(text);
		builder.append("\", \"user\":\"");
		builder.append(username);
		builder.append("\", \"sentiment\":\"");
		builder.append((sentiment ==null)?"":sentiment.toString()); 	
		builder.append("\"}");
		return builder.toString();

	}



}
