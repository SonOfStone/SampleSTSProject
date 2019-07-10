package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public User getUserByUsername(String username) {

		User u = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "SELECT * FROM project1.users WHERE username = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			set = stmt.executeQuery();
			
			while(set.next()) {
				Integer userid = set.getInt(1);
				//String username = set.getString(2);
				String password = set.getString(3);
				String first = set.getString(4);
				String last = set.getString(5);
				Integer rank = set.getInt(6);
				Double totalReimbursed = set.getDouble(7);
				Double pendingReimbursed = set.getDouble(8);
				Integer supervisor = set.getInt(9);

				u = new User(userid, username, password, first, last, rank, totalReimbursed, pendingReimbursed, supervisor);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		
		return u;
	}

}
