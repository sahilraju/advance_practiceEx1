package com.mphasis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mphasis.dto.User;
import com.mphasis.exception.BusinessException;

public class UserDao { 

	private Connection connection;
	private PreparedStatement prepare;
	private ResultSet rSet;

	public boolean verifyUserCredentails(User user) throws BusinessException {

		connection = DBUtil.establishConnection(); 

		try {
  
			prepare = connection.prepareStatement("Select * FROM user WHERE username = ? AND password = ?");

			prepare.setString(1, user.getUserName());
			prepare.setString(2, user.getPassword());

			rSet = prepare.executeQuery();

			if (rSet.next()) {
				return true;
			} else {
				throw new BusinessException("Invalid Login Credentilas");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rSet != null)
					rSet.close(); 
				if (prepare != null)
					prepare.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}

}
