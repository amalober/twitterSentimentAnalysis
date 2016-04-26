package com.itba.sentiment.persist;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.itba.sentiment.twitter.messages.TwitterMessage;

public class JsonPersistenceService {

	private static MongoDatabase db = null;
	private String URI;
	private String database;
	private MongoClient mc;

	
	public JsonPersistenceService() {
		connect("mongodb://localhost:27017", "TwitterDB");
	}

	public JsonPersistenceService(String URI, String database) {
		connect(URI, database);
	}

	public void connect(String URI, String database) {
		this.URI = URI;
		this.database = database;

		MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(10).build();
		mc = new MongoClient(new MongoClientURI(URI));
		db = mc.getDatabase(database);

	}

	public void persistJsonStringArray(List<String> array, String collection) {
		if (db == null) {
			throw new MongoException("Desconectada");
		}
		MongoCollection<org.bson.Document> coll = db.getCollection(collection);
		for (String string : array) {
			coll.insertOne(org.bson.Document.parse(string));
		}
	}

	public List<Document> getProjectedCollection(String collectionName) {
		ArrayList<Document> result = new ArrayList<Document>();
		if (db != null) {
			MongoCollection<Document> collection = db.getCollection(collectionName);
			Bson projection = new Document("id_str", 1).append("user.screen_name", 1).append("created_at", 1)
					.append("text", 1);
			result = collection.find().projection(projection).into(new ArrayList<Document>());
		}
		return result;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public void closeDBConnection() {
		if (mc != null) {
			mc.close();
		}
	}
	public void updateDocumentWithSentiment(TwitterMessage message, String id){
		
		
		
	}

}
