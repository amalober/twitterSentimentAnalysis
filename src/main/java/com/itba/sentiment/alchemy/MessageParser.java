package com.itba.sentiment.alchemy;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Document;

import com.itba.sentiment.analysis.Message;

public class MessageParser {

	private static void parseResult(Message msg, Document doc) {

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
			
			msg.setLanguage(rs.getLanguage());
			msg.setScore((double) ds.getScore());
			msg.setAnalysisResult(ds.getType());
			msg.setMixed(ds.getMixed());
	
			msg.setDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static Message parseSentimentResult(Document doc) {

		Message msg = new Message();
		parseResult(msg, doc);
		return msg;
	}

	public static Message parseSentimentResultForMsg(Message msg, Document doc) {

		parseResult(msg, doc);
		return msg;
	}

}
