package model;

import database.DBOperations;

public class EditHouseDetailsModel {
	String statusCode = "1";
	DBOperations dbOperations = new DBOperations();
	String response = null, sqlQuery = "";

	public String editPersonalDetails(String fullName, String password, String emailId, String phoneNo) {
		sqlQuery = "update User set full_name = '" + fullName + "' , phone_no = '" + phoneNo + "', password= '"
				+ password + "' where email_id='" + emailId + "'";
		
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;
	}

	public String editHouseDetails(String emailId, String address, String city, String suburb, String distance,
			String publicTransport, String noOfRooms, String airConditioning, String swimmingPool, String points,
			String discounts) {

		sqlQuery = "update House_Details set address = '" + address + "', city = '" + city + "', suburb = '" + distance
				+ "', distance_from_city = '" + distance + "', public_transport = '" + publicTransport
				+ "', no_of_rooms = '" + noOfRooms + "', airconditioning = '" + airConditioning + "' , swiming_pool = '"
				+ swimmingPool + "', points_required = '" + points + "', discounts = '" + discounts
				+ "' where email_id = '" + emailId + "'";
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;
	}

}
