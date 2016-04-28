package com.itba.sentiment.twitter.messages;

import java.time.LocalDateTime;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.itba.sentiment.analysis.DocSentiment;

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
		try{
		this.username = ((org.bson.Document)(tweet.get("user"))).getString("screen_name");
		this.tweetid = tweet.getString("id_str");
		this.URL = baseURL+this.tweetid;
		this.text = tweet.getString("text").replaceAll("\"", "").replaceAll("'", "");
		this.datestr = tweet.getString("created_at");
		this.id= (ObjectId)tweet.get("_id");
		}catch(ClassCastException cce){
			this.username =tweet.getString("user");
			this.tweetid = tweet.getString("tweet_id");
			this.URL = baseURL+this.tweetid;
			this.text = tweet.getString("message");
			this.datestr = tweet.getString("datestr");
			this.id= (ObjectId)tweet.get("id");
			this.sentiment = new DocSentiment();
			Document sentimentjson =  (Document)tweet.get("sentiment");
			this.sentiment.setType(sentimentjson.getString("analysisResult"));
			this.sentiment.setScore(Double.parseDouble(sentimentjson.getString("score")));
			this.sentiment.setMixed(0);
			this.sentiment.setLanguage(sentimentjson.getString("language"));
		}
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
		builder.append(text.replaceAll("'", "").replaceAll("\"", "").replaceAll("\n", ""));
		builder.append("\", \"URL\":\"");
		builder.append(URL);
		builder.append("\", \"user\":\"");
		builder.append(username);
		builder.append("\", \"analysisResult\":\"");
		builder.append(sentiment.getType());
		builder.append("\", \"sentiment\":");
		builder.append((sentiment ==null)?"\"\"":sentiment.toString()); 	
		builder.append("}");
		return builder.toString();

	}



}
