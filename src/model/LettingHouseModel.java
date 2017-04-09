package model;

import database.DBOperations;

public class LettingHouseModel {
	String statusCode = "1";
	DBOperations dbOperations = new DBOperations();
	int response = 0;

	public String lettingHouse(String loggedInEmail, String availableFrom, String availableTo,
			String minOccupierRating) {
		String sqlQuery = "UPDATE Letting_User_House_Availability SET available_from='" + availableFrom + "', available_to='"
				+ availableTo + "', min_occupier_rating='" + minOccupierRating + "' WHERE email_Id='"+loggedInEmail+"';";
	
		response = dbOperations.updateData(sqlQuery);

		if (response > 0 ) {
			statusCode = "0";
		} else {
			statusCode = "1";
		}
		return statusCode;
	}

}
