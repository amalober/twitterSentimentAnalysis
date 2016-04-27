package com.itba.sentiment.analysis;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.alchemyapi.api.AlchemyAPI;
import com.itba.sentiment.alchemy.MessageParser;
import com.itba.sentiment.persist.JsonPersistenceService;
import com.itba.sentiment.twitter.messages.TwitterMessage;
import com.itba.sentiment.twitter.messages.TwitterMessageService;
import com.itba.sentiment.utils.JsonHelper;
import com.itba.sentiment.utils.MessageCleaner;
import com.itba.sentiment.utils.WordCount;

/**
 * Created by ana.maloberti on 08/04/16.
 */

public class Main {
	static JsonPersistenceService jps = new JsonPersistenceService("mongodb://localhost:27017", "TwitterDB");

	public static void main(String[] args) {
//		testDownloadTweets();
		//System.out.println(wordFrequencyJson());
		// testGetMessages();
		testAnalyzeTweets();
	}

	private static void testDownloadTweets() {

		try {
			jps.persistJsonStringArray((List<String>) TwitterMessageService.getTweetByQuery(true, "#Superclasico"),
					"tweets");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------
	private static void testAnalyzeTweets() {
		ArrayList<TwitterMessage> projectedTweets = new ArrayList<TwitterMessage>();
		ArrayList<org.bson.Document> tweets = (ArrayList<org.bson.Document>) jps.getProjectedCollection("tweets");
		for (org.bson.Document tweet : tweets) {
			JsonHelper.printJson(tweet);
			projectedTweets.add(new TwitterMessage(tweet));
		}
		AlchemyAPI alchemyObj = AlchemyAPI.GetInstanceFromString("d2f732e841e0867f2325606841102375308f66dc");

		for (TwitterMessage projectedTweet : projectedTweets) {

			try {
				Document doc = alchemyObj.TextGetTextSentiment(projectedTweet.getText());
				MessageParser.parseSentimentResultForMsg(projectedTweet, doc);
				jps.persistTwitterMessage(projectedTweet, "analyzedtweets");
				System.out.println(projectedTweet.toString());
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			// System.out.println(getStringFromDocument(doc));

		}
		jps.closeDBConnection();

	}

	private static void testWordFrequency() {
		List<org.bson.Document> messages = jps.getProjectedCollection("tweets");
		String appendedMsgs = "";
		String cleanMessages = "";
		String json = "[";
		if (messages != null) {
			for (org.bson.Document message : messages) {
				appendedMsgs += message.getString("text").toLowerCase() + " ";
			}
			// System.out.println(appendedMsgs);
			cleanMessages = MessageCleaner.removeStopwords(appendedMsgs);
			Map<String, Integer> m = WordCount.wordFrequencyCount(cleanMessages);

			// m.values().removeAll(Collections.singleton(1));
			// m.values().removeAll(Collections.singleton(2));

			// m.keySet().removeAll(Collections.singleton("/"));

			// [{\"text\":\"study\",\"size\":40},

			for (Map.Entry<String, Integer> entry : m.entrySet()) {
				json += "{ text: \"" + entry.getKey() + "\", \"size\": " + entry.getValue() * 3 + "},";
			}
			json = json.substring(0, json.length() - 1);
			json += ']';
		}
		System.out.println(json);
	}

	private static void testGetMessages() {
		ArrayList<org.bson.Document> result = (ArrayList<org.bson.Document>) jps.getProjectedCollection("tweets");
		ArrayList<TwitterMessage> projectedTweets = new ArrayList<TwitterMessage>();
		for (org.bson.Document doc : result) {
			projectedTweets.add(new TwitterMessage(doc));
		}
		System.out.println(projectedTweets.toString());
	}

	private static void testKeywords(AlchemyAPI alchemyObj)
			throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {

		ArrayList<TwitterMessage> projectedTweets = new ArrayList<TwitterMessage>();
		ArrayList<org.bson.Document> tweets = (ArrayList<org.bson.Document>) jps
				.getProjectedCollection("twittersentiment");
		for (org.bson.Document tweet : tweets) {
			JsonHelper.printJson(tweet);
			projectedTweets.add(new TwitterMessage(tweet));
		}
		String appendedMsgs = "";
		String cleanMessages = "";
		String json = "[";
		if (projectedTweets != null) {
			for (TwitterMessage message : projectedTweets) {
				appendedMsgs += message.getText().toLowerCase() + " ";
			}
			// System.out.println(appendedMsgs);
			cleanMessages = MessageCleaner.removeStopwords(appendedMsgs);
			Map<String, Integer> m = WordCount.wordFrequencyCount(cleanMessages);

			m.values().removeAll(Collections.singleton(1));
			m.keySet().removeAll(Collections.singleton("/"));
			// [{\"text\":\"study\",\"size\":40},

			for (Map.Entry<String, Integer> entry : m.entrySet()) {
				json += "{ text: \"" + entry.getKey() + "\", size: " + entry.getValue() + "},";
			}
			json = json.substring(0, json.length() - 1);
			json += ']';
		}
		System.out.println(json);

	}

	// utility method
	private static String getStringFromDocument(Document doc) {
		try {
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);

			return writer.toString();
		} catch (TransformerException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private static String wordFrequencyJson() {

		List<org.bson.Document> messages = jps.getProjectedCollection("tweets");
		String appendedMsgs = "";
		String cleanMessages = "";
		String json = "[";
		if (messages != null) {
			for (org.bson.Document message : messages) {
				appendedMsgs += message.getString("text").toLowerCase() + " ";
			}
			cleanMessages = MessageCleaner.removeStopwords(appendedMsgs);
			Map<String, Integer> m = WordCount.wordFrequencyCount(cleanMessages);

			
			for (Map.Entry<String, Integer> entry : m.entrySet()) {
				json += "{ text: \"" + entry.getKey() + "\", \"size\": " + entry.getValue() * 3 + "},";
			}
			json = json.substring(0, json.length() - 1);
			json += ']';
		}
		return json;
	}

}