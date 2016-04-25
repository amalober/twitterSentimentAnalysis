package com.itba.sentiment.analysis;

import java.util.Date;

public class Message {

	int id;
	String message;
	String voteResult;
	Date date;
	String analysisResult;
	String language;
	Double score;
	int  mixed;
	
	public int getMixed() {
		return mixed;
	}

	public void setMixed(int mixed) {
		this.mixed = mixed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getVoteResult() {
		return voteResult;
	}

	public void setVoteResult(String voteResult) {
		this.voteResult = voteResult;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAnalysisResult() {
		return analysisResult;
	}

	public void setAnalysisResult(String analysisResult) {
		this.analysisResult = analysisResult;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"");
		builder.append(id);
		builder.append("\", \"message\":\"");
		builder.append(message.replace("\"", "\\\""));
		builder.append("\", \"voteResult\":\"");
		builder.append(voteResult);
		builder.append("\", \"date\":\"");
		builder.append(date);
		builder.append("\", \"analysisResult\":\"");
		builder.append(analysisResult);
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
