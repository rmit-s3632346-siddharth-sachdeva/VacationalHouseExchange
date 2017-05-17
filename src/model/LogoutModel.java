package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBOperations;

public class LogoutModel {
	String statusCode = "1";
	DBOperations dbOperations = new DBOperations();
	String response = null;
	
	public String logoutModel(String emailId){
		try{
		String sqlQuery = "update User set isLoggedIn='n' where email_id="+emailId;
		ResultSet resultSet = dbOperations.getData(sqlQuery);

		while (resultSet.next()) {
			response = resultSet.getString("0");
		}

		if (response != null && response.equalsIgnoreCase("0")) {
			statusCode = "0";
		} else {
			statusCode = "1";
		}
		}catch(SQLException se){
			se.printStackTrace();
			statusCode ="1";
		}
		return statusCode;
	}

}
