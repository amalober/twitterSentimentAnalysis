package com.itba.sentiment.controller;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.alchemyapi.api.AlchemyAPI;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.util.Messages;
import com.itba.sentiment.alchemy.MessageParser;
import com.itba.sentiment.analysis.Message;
import com.itba.sentiment.analysis.MessageService;
import com.itba.sentiment.utils.MessageCleaner;
import com.itba.sentiment.utils.WordCount;

@Controller
@RequestMapping("/")
public class MessagesController {

	@Autowired
	private MessageService ms;

	@RequestMapping(path = "/", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getMessages() {
		return ms.retrieveAllMessages().toString();
	}
	//

	@RequestMapping(path = "/test", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getWords() {
		// "[{\"text\":\"study\",\"size\":40},{\"text\":\"motion\",\"size\":15},{\"text\":\"forces\",\"size\":10},{\"text\":\"electricity\",\"size\":15},{\"text\":\"movement\",\"size\":10},{\"text\":\"relation\",\"size\":5},{\"text\":\"things\",\"size\":10},{\"text\":\"force\",\"size\":5},{\"text\":\"ad\",\"size\":5},{\"text\":\"energy\",\"size\":85},{\"text\":\"living\",\"size\":5},{\"text\":\"nonliving\",\"size\":5},{\"text\":\"laws\",\"size\":15},{\"text\":\"speed\",\"size\":45},{\"text\":\"velocity\",\"size\":30},{\"text\":\"define\",\"size\":5},{\"text\":\"constraints\",\"size\":5},{\"text\":\"universe\",\"size\":10},{\"text\":\"physics\",\"size\":120},{\"text\":\"describing\",\"size\":5},{\"text\":\"matter\",\"size\":90},{\"text\":\"physics-the\",\"size\":5},{\"text\":\"world\",\"size\":10},{\"text\":\"works\",\"size\":10},{\"text\":\"science\",\"size\":70},{\"text\":\"interactions\",\"size\":30},{\"text\":\"studies\",\"size\":5},{\"text\":\"properties\",\"size\":45},{\"text\":\"nature\",\"size\":40},{\"text\":\"branch\",\"size\":30},{\"text\":\"concerned\",\"size\":25},{\"text\":\"source\",\"size\":40},{\"text\":\"google\",\"size\":10},{\"text\":\"defintions\",\"size\":5},{\"text\":\"two\",\"size\":15},{\"text\":\"grouped\",\"size\":15},{\"text\":\"traditional\",\"size\":15},{\"text\":\"fields\",\"size\":15},{\"text\":\"acoustics\",\"size\":15},{\"text\":\"optics\",\"size\":15},{\"text\":\"mechanics\",\"size\":20},{\"text\":\"thermodynamics\",\"size\":15},{\"text\":\"electromagnetism\",\"size\":15},{\"text\":\"modern\",\"size\":15},{\"text\":\"extensions\",\"size\":15},{\"text\":\"thefreedictionary\",\"size\":15},{\"text\":\"interaction\",\"size\":15},{\"text\":\"org\",\"size\":25},{\"text\":\"answers\",\"size\":5},{\"text\":\"natural\",\"size\":15},{\"text\":\"objects\",\"size\":5},{\"text\":\"treats\",\"size\":10},{\"text\":\"acting\",\"size\":5},{\"text\":\"department\",\"size\":5},{\"text\":\"gravitation\",\"size\":5},{\"text\":\"heat\",\"size\":10},{\"text\":\"light\",\"size\":10},{\"text\":\"magnetism\",\"size\":10},{\"text\":\"modify\",\"size\":5},{\"text\":\"general\",\"size\":10},{\"text\":\"bodies\",\"size\":5},{\"text\":\"philosophy\",\"size\":5},{\"text\":\"brainyquote\",\"size\":5},{\"text\":\"words\",\"size\":5},{\"text\":\"ph\",\"size\":5},{\"text\":\"html\",\"size\":5},{\"text\":\"lrl\",\"size\":5},{\"text\":\"zgzmeylfwuy\",\"size\":5},{\"text\":\"subject\",\"size\":5},{\"text\":\"distinguished\",\"size\":5},{\"text\":\"chemistry\",\"size\":5},{\"text\":\"biology\",\"size\":5},{\"text\":\"includes\",\"size\":5},{\"text\":\"radiation\",\"size\":5},{\"text\":\"sound\",\"size\":5},{\"text\":\"structure\",\"size\":5},{\"text\":\"atoms\",\"size\":5},{\"text\":\"including\",\"size\":10},{\"text\":\"atomic\",\"size\":10},{\"text\":\"nuclear\",\"size\":10},{\"text\":\"cryogenics\",\"size\":10},{\"text\":\"solid-state\",\"size\":10},{\"text\":\"particle\",\"size\":10},{\"text\":\"plasma\",\"size\":10},{\"text\":\"deals\",\"size\":5},{\"text\":\"merriam-webster\",\"size\":5},{\"text\":\"dictionary\",\"size\":10},{\"text\":\"analysis\",\"size\":5},{\"text\":\"conducted\",\"size\":5},{\"text\":\"order\",\"size\":5},{\"text\":\"understand\",\"size\":5},{\"text\":\"behaves\",\"size\":5},{\"text\":\"en\",\"size\":5},{\"text\":\"wikipedia\",\"size\":5},{\"text\":\"wiki\",\"size\":5},{\"text\":\"physics-\",\"size\":5},{\"text\":\"physical\",\"size\":5},{\"text\":\"behaviour\",\"size\":5},{\"text\":\"collinsdictionary\",\"size\":5},{\"text\":\"english\",\"size\":5},{\"text\":\"time\",\"size\":35},{\"text\":\"distance\",\"size\":35},{\"text\":\"wheels\",\"size\":5},{\"text\":\"revelations\",\"size\":5},{\"text\":\"minute\",\"size\":5},{\"text\":\"acceleration\",\"size\":20},{\"text\":\"torque\",\"size\":5},{\"text\":\"wheel\",\"size\":5},{\"text\":\"rotations\",\"size\":5},{\"text\":\"resistance\",\"size\":5},{\"text\":\"momentum\",\"size\":5},{\"text\":\"measure\",\"size\":10},{\"text\":\"direction\",\"size\":10},{\"text\":\"car\",\"size\":5},{\"text\":\"add\",\"size\":5},{\"text\":\"traveled\",\"size\":5},{\"text\":\"weight\",\"size\":5},{\"text\":\"electrical\",\"size\":5},{\"text\":\"power\",\"size\":5}]";
		return wordFrequencyJson();
	}

	@RequestMapping(path = "/process", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String analizeMessages() {
		try {
			AlchemyAPI alchemyObj = AlchemyAPI.GetInstanceFromString("d2f732e841e0867f2325606841102375308f66dc");
			MessageService ms = new MessageService();
			ArrayList<Message> messages =(ArrayList<Message>)ms.retrieveNotAnalyzedMessages();

			if (messages != null) {
				for (Message message : messages) {
					Document doc = alchemyObj.TextGetTextSentiment(message.getMessage());
					//System.out.println(getStringFromDocument(doc));
					MessageParser.parseSentimentResultForMsg(message, doc);		
					ms.persistMessageResult(message);
				}
			}
			messages =(ArrayList<Message>)ms.retrieveAllMessages();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ms.retrieveAllMessages().toString();
	}

	private String wordFrequencyJson() {

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
			m.values().removeAll(Collections.singleton(2));
			
			m.keySet().removeAll(Collections.singleton("/"));
			m.keySet().removeAll(Collections.singleton("vuelos"));
			// [{\"text\":\"study\",\"size\":40},

			for (Map.Entry<String, Integer> entry : m.entrySet()) {
				json += "{ text: \"" + entry.getKey() + "\", \"size\": " + entry.getValue()*3 + "},";
			}
			json = json.substring(0, json.length() - 1);
			json += ']';
		}
		return json;
	}

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