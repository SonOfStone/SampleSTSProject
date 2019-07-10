package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.ReimburseReq;
import com.revature.model.User;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class RequestRepositoryImpl implements RequestRepository{

	@Override
	public void insertIntoRequests(ReimburseReq reimburseReq) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into project1.requests values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, reimburseReq.getUserId());
			stmt.setString(2, reimburseReq.getEventName());
			stmt.setString(3, reimburseReq.getEventDate());
			stmt.setString(4, reimburseReq.getTime());
			stmt.setString(5, reimburseReq.getLocation());
			stmt.setString(6, reimburseReq.getDescription());
			stmt.setDouble(7, reimburseReq.getCost());
			stmt.setInt(8, reimburseReq.getGradingFormat());
			stmt.setInt(9, reimburseReq.getEventType());
			stmt.setString(10, reimburseReq.getJustification());
			stmt.setInt(11, reimburseReq.getWorkMissed());
			stmt.setBoolean(12, reimburseReq.getUrgent());
			stmt.setInt(13, reimburseReq.getRankRequired());
			stmt.setInt(14, reimburseReq.getStage());
			stmt.setString(15, reimburseReq.getTimeSubmitted());
			stmt.setInt(16, reimburseReq.getTimeInStep());
			stmt.setString(17, reimburseReq.getDenyReason());

			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	}

	@Override
	public ArrayList<ReimburseReq> getRequestsByUserId(User user) {
		ArrayList<ReimburseReq> reimburseRequests = new ArrayList<ReimburseReq>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		final String SQL = "select * from project1.Requests where userid = ? order by timesubmitted desc";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, user.getUserId());
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()) {
				Integer requestId = resultSet.getInt(1);
				Integer userId = resultSet.getInt(2);
				String eventName = resultSet.getString(3);
				String eventDate = resultSet.getString(4);
				String eventTime = resultSet.getString(5);
				String location = resultSet.getString(6);
				String description = resultSet.getString(7);
				Double cost = resultSet.getDouble(8);
				Integer gradingFormat = resultSet.getInt(9);
				Integer eventType = resultSet.getInt(10);
				String justification = resultSet.getString(11);
				Integer workMissed = resultSet.getInt(12);
				Boolean urgent = resultSet.getBoolean(13);
				Integer rankRequired = resultSet.getInt(14);
				Integer stage = resultSet.getInt(15);
				String timeSubmitted = resultSet.getString(16);
				Integer timeInStep = resultSet.getInt(17);
				String denyReason = resultSet.getString(18);


				ReimburseReq reimburseReq = new ReimburseReq(requestId, userId, eventName, eventDate, eventTime, location, description, cost, gradingFormat, eventType, justification, workMissed, urgent, rankRequired, stage, timeSubmitted, timeInStep, denyReason);
				reimburseRequests.add(reimburseReq);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(resultSet);
			ConnectionClosers.closeStatement(stmt);
		}
		
		
		return reimburseRequests;
	}

}
