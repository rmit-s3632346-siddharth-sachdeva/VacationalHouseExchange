package model;

import database.DBOperations;

public class RegisterModel {
	String statusCode = "1";
	DBOperations dbOperations = new DBOperations();
	String response = null, sqlQuery = "";

	public String register(String username, String password, String emailId, String phoneNo) {
		sqlQuery = "insert into User values ('"+username+"','"+password+"','"+emailId+"',"+phoneNo+")";
		int resultSet = dbOperations.updateData(sqlQuery);
		if (resultSet == 0)
			statusCode = "0";
		else
			statusCode = "1";

		return statusCode;
	}

}
