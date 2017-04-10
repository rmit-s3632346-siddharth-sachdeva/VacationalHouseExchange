package model;

import database.DBOperations;

public class EditHouseDetailsModel {
	String statusCode = "1";
	DBOperations dbOperations = new DBOperations();
	String response = null, sqlQuery = "";

	public String editPersonalDetails(String username, String password, String emailId, String phoneNo) {
		sqlQuery = "";
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;
	}

	public String editHouseDetails(String emailId, String address, String city, String suburb, String distance,
			String publicTransport, String noOfRooms, String airConditioning, String swimmingPool, String points, String discounts) {
	
		sqlQuery = "";
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;
	}
	
	

}
