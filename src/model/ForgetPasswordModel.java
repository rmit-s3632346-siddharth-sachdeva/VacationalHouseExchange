package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.POST;

import database.DBOperations;

public class ForgetPasswordModel {

	String password = "Not Found";
	DBOperations dbOperations = new DBOperations();
	String response = null;
	
	@POST
	public String getPassword(String emailId) {
		try{
			String sqlQuery = "SELECT password FROM User WHERE email_id='" + emailId + "';";
			ResultSet resultSet = dbOperations.getData(sqlQuery);

			while (resultSet.next()) {
				response = resultSet.getString("password");
			}

			if (response != null) {
				password = response;
			} else {
				password = "Not Found";
			}
			}catch(SQLException se){
				se.printStackTrace();
				password ="Not Found";
			}
		
		return password;
	}

}
