package com.itba.sentiment.analysis;

public class DocSentiment {
	
	String type;
	Double score;
	int mixed;
	String language;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public int getMixed() {
		return mixed;
	}
	public void setMixed(int mixed) {
		this.mixed = mixed;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String toString(){
		StringBuilder builder= new StringBuilder();
		builder.append("{\"analysisResult\":\"");
		builder.append(type);
		builder.append("\", \"language\":\"");
		builder.append(language);
		builder.append("\", \"score\":\"");
		builder.append(score);
		builder.append("\", \"mixed\":\"");
		builder.append(mixed);
		builder.append("\"}");
		
		return builder.toString();
	
	}
}