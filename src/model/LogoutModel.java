package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBOperations;

public class LogoutModel {
	String statusCode = "1";
	DBOperations dbOperations = new DBOperations();
	String response = null;
	
	public String logoutModel(String emailId){
		String sqlQuery = "update User set isLoggedIn='n' where email_id= '"+emailId+"'";
		int rows = dbOperations.updateData(sqlQuery);
		if(rows >0){
			statusCode = "0";
		}else{
			statusCode = "1";
		}
		return statusCode;
	}

}
