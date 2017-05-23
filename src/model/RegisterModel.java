package model;

import database.DBOperations;

public class RegisterModel {
	String statusCode = "1";
	DBOperations dbOperations = new DBOperations();
	String response = null, sqlQuery = "";

	public String register(String fullname, String password, String emailId, String phoneNo) {

		sqlQuery = "insert into User (full_name, password, email_Id, phone_no,credits) values ('" + fullname + "','" + password
				+ "','" + emailId + "','" + phoneNo + "','1000')";
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;
	}

	public String registerHouseDetails(String emailId, String address, String city, String suburb, String distance,
			String publicTransport, String noOfRooms, String airConditioning, String swimmingPool, String points,
			String discounts) {

		sqlQuery = "Insert into House_Details (email_id, address, city, suburb, distance_from_city, public_transport, "
				+ "no_of_rooms, airconditioning, swiming_pool, points_required, discounts, availabilityOfHouse) values ('" + emailId + "','"
				+ address + "','" + city + "','" + suburb + "','" + distance + "','" + publicTransport + "','"
				+ noOfRooms + "','" + airConditioning + "','" + swimmingPool + "','" + points + "','" + discounts
				+ "','available')";
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;
	}

	public String paymentDetails(String emailId, String cardNo, String amount) {
		sqlQuery = "Insert into Payment_Details (email_id, card_no, amount) values ('" + emailId + "','" + cardNo + "','"
				+ amount + "')";
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;
	}

	public String settingAvailability(String emailId) {
		sqlQuery = "Insert into Letting_User_House_Availability (email_Id, available_from, available_to, min_occupier_rating) values ('"
				+ emailId + "','','','')";
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;	
		
	}

}
