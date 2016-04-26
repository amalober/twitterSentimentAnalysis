package com.itba.sentiment.analysis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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
import com.itba.sentiment.twitter.messages.TwitterMessages;
import com.itba.sentiment.utils.MessageCleaner;
import com.itba.sentiment.utils.WordCount;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by ana.maloberti on 08/04/16.
 */

public class Main {

	public static void main(String[] args)
			throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {

		MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(10).build();
		// MongoClient mc = new MongoClient(new ServerAddress("localhost",
		// 27017), options);
		MongoClient mc = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase db = mc.getDatabase("course");

		String keyword = "tweetDB";
		try {
			TwitterMessages.getTweetByQuery(true, "superclasico");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static String wordFrequencyJson() {

		MessageService ms = new MessageService();
		List<Message> messages = ms.retrieveAllMessages();
		String appendedMsgs = "";
		String cleanMessages = "";
		String json = "[";
		System.out.println(messages.size());
		if (messages != null) {
			for (Message message : messages) {
				appendedMsgs += message.getMessage().toLowerCase() + " ";
			}
			System.out.println(appendedMsgs);
			cleanMessages = MessageCleaner.removeStopwords(appendedMsgs);
			Map<String, Integer> m = WordCount.wordFrequencyCount(cleanMessages);
			System.out.println(m.size());

			m.values().removeAll(Collections.singleton(1));
			m.values().removeAll(Collections.singleton(2));

			m.keySet().removeAll(Collections.singleton("/"));
			m.keySet().removeAll(Collections.singleton("vuelos"));
			// [{\"text\":\"study\",\"size\":40},

			for (Map.Entry<String, Integer> entry : m.entrySet()) {
				json += "{ text: \"" + entry.getKey() + "\", \"size\": " + entry.getValue() * 3 + "},";
			}
			json = json.substring(0, json.length() - 1);
			json += ']';
		}
		return json;
	}

	private static void testKeywords(AlchemyAPI alchemyObj)
			throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {

		MessageService ms = new MessageService();
		List<Message> messages = ms.retrieveAllMessages();
		String appendedMsgs = "";
		String cleanMessages = "";
		String json = "[";
		if (messages != null) {
			for (Message message : messages) {
				appendedMsgs += message.getMessage().toLowerCase() + " ";
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

	private static void testOneMessage(int id, AlchemyAPI alchemyObj)
			throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {

		MessageService ms = new MessageService();
		Message message = ms.retrieveMessageResult(id);
		System.out.println(message);
		if (message.getMessage() != null) {
			// Document doc =
			// alchemyObj.TextGetTextSentiment(message.getMessage());
			// System.out.println(getStringFromDocument(doc));
			// MessageParser.parseSentimentResultForMsg(message, doc);
			// System.out.println(message.toString());
			// ms.persistMessageResult(message);
			message = ms.retrieveMessageResult(id);
			System.out.println(message);
		}
	}

	private static void testAllMessages(AlchemyAPI alchemyObj)
			throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {

		MessageService ms = new MessageService();
		ArrayList<Message> messages = (ArrayList<Message>) ms.retrieveNotAnalyzedMessages();

		if (messages != null) {
			for (Message message : messages) {
				Document doc = alchemyObj.TextGetTextSentiment(message.getMessage());
				System.out.println(getStringFromDocument(doc));
				MessageParser.parseSentimentResultForMsg(message, doc);
				System.out.println(message.toString());
				ms.persistMessageResult(message);
				message = ms.retrieveMessageResult(message.getId());
				System.out.println(message);
			}
		}
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
}