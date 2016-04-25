package com.itba.sentiment.analysis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageService {


	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sentiment?autoReconnect=true&useSSL=false",
				"root", "toor");
		return conn;
	}

	private void releaseConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void persistMessageResult(Message message) {
		Connection conn=null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(
					"update csmessages set analysisresult=?, mlanguage = ?, score = ?, mixed=?, analysisdate = ? where id = ?");

			stmt.setString(1, message.getAnalysisResult());
			stmt.setString(2, message.getLanguage());
			stmt.setString(3, message.getScore().toString());
			stmt.setString(4, message.getMixed()+"");
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			stmt.setString(5, sdf.format(message.getDate()));
			stmt.setString(6, message.getId() + "");

			stmt.executeUpdate();
			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseConnection(conn);
		}
	}

	public Message retrieveMessageResult(int id) {
		Message message = new Message();
		Connection conn = null;
		try {
			 conn= getConnection();
			PreparedStatement stmt = conn.prepareStatement(
					"select id, message, mlanguage, voteresult, analysisresult, score,mixed,  analysisdate from csmessages where id = ?");
			stmt.setString(1, id + "");
			// Message message = new Message();

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				message.setId(Integer.parseInt(rs.getString("ID")));
				message.setLanguage(rs.getString("MLANGUAGE"));
				message.setVoteResult(rs.getString("VOTERESULT"));
				message.setAnalysisResult(rs.getString("ANALYSISRESULT"));
				message.setScore(rs.getDouble("SCORE"));
				message.setMixed(rs.getInt("MIXED"));
				message.setMessage(rs.getString("MESSAGE"));
				message.setDate(rs.getDate("ANALYSISDATE"));
			}
			stmt.close();
			return message;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return message;
	}

	public List<Message> retrieveNotAnalyzedMessages() {

		Connection conn = null;
		ArrayList<Message> msgsArray = new ArrayList<Message>();
		try {
			conn=  getConnection();
			PreparedStatement stmt = conn.prepareStatement(
					"select id, message, mlanguage, voteresult, analysisresult, score, mixed, analysisdate from csmessages where analysisresult is null");
		
			// Message message = new Message();

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Message message=new Message();
				message.setId(Integer.parseInt(rs.getString("ID")));
				message.setLanguage(rs.getString("MLANGUAGE"));
				message.setVoteResult(rs.getString("VOTERESULT"));
				message.setAnalysisResult(rs.getString("ANALYSISRESULT"));
				message.setScore(rs.getDouble("SCORE"));
				message.setMessage(rs.getString("MESSAGE"));
				message.setMixed(rs.getInt("MIXED"));
				message.setDate(rs.getDate("ANALYSISDATE"));
				msgsArray.add(message);
			}
			stmt.close();
			return msgsArray;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return msgsArray;

	}
	public List<Message> retrieveAllMessages() {

		Connection conn = null;
		ArrayList<Message> msgsArray = new ArrayList<Message>();
		try {
			conn=  getConnection();
			PreparedStatement stmt = conn.prepareStatement(
					"select id, message, mlanguage, voteresult, analysisresult, score, analysisdate from csmessages");
		
			// Message message = new Message();

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Message message=new Message();
				message.setId(Integer.parseInt(rs.getString("ID")));
				message.setLanguage(rs.getString("MLANGUAGE"));
				message.setVoteResult(rs.getString("VOTERESULT"));
				message.setAnalysisResult(rs.getString("ANALYSISRESULT")==null? "":rs.getString("ANALYSISRESULT"));
				message.setScore(rs.getDouble("SCORE"));
				message.setMessage(rs.getString("MESSAGE"));
				message.setDate(rs.getDate("ANALYSISDATE"));
				msgsArray.add(message);
			}
			stmt.close();
			return msgsArray;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return msgsArray;

	}
	public ArrayList<Message> retrieveMessagesByStatus(String status) {

		Connection conn = null;
		ArrayList<Message> msgsArray = new ArrayList<Message>();
		try {
			conn=  getConnection();
			PreparedStatement stmt = conn.prepareStatement(
					"select id, message, mlanguage, voteresult, analysisresult, score, analysisdate from csmessages where analysisresult=?");
		
			// Message message = new Message();
			stmt.setString(1,status);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Message message=new Message();
				message.setId(Integer.parseInt(rs.getString("ID")));
				message.setLanguage(rs.getString("MLANGUAGE"));
				message.setVoteResult(rs.getString("VOTERESULT"));
				message.setAnalysisResult(rs.getString("ANALYSISRESULT"));
				message.setScore(rs.getDouble("SCORE"));
				message.setMessage(rs.getString("MESSAGE"));
				message.setDate(rs.getDate("ANALYSISDATE"));
				msgsArray.add(message);
			}
			stmt.close();
			return msgsArray;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return msgsArray;

	}

}
