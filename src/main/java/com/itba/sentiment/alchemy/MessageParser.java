package com.itba.sentiment.alchemy;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Document;

import com.itba.sentiment.analysis.DocSentiment;
import com.itba.sentiment.twitter.messages.TwitterMessage;

public class MessageParser {

	private static void parseResultIntoMessage(TwitterMessage msg, Document doc) {

		try {
			// create JAXBContext which will be used to create a Binder
			JAXBContext jc = JAXBContext.newInstance(Results.class);
			Unmarshaller u = jc.createUnmarshaller();
			Results rs = (Results) u.unmarshal(doc);

			Results.DocSentiment ds = rs.getDocSentiment();

			System.out.println("Sentiment: " + ds.getType());
			System.out.println("Mixed: " + ds.getMixed());
			System.out.println("Score: " + ds.getScore());
			System.out.println("Language: " + rs.getLanguage());
			System.out.println("----------------------");
			msg.setSentiment(new DocSentiment());
			msg.getSentiment().setLanguage(rs.getLanguage());
			msg.getSentiment().setScore((double) ds.getScore());
			msg.getSentiment().setType(ds.getType());
			msg.getSentiment().setMixed(ds.getMixed());
	
			//msg.setDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	
	public static TwitterMessage parseSentimentResultForMsg(TwitterMessage msg, Document doc) {

		parseResultIntoMessage(msg, doc);
		return msg;
	}

}
