package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import common.Constants;
import database.DBOperations;

public class ViewHouseModel {

	@SuppressWarnings({ "unchecked", "unused" })
	public JSONObject viewHouses(String emailID) {
		DBOperations dbOperations = new DBOperations();
		String response = null;
		ArrayList<JSONObject> responseObject = new ArrayList<>();
		JSONObject finalResponseObject = new JSONObject();
		try {
			String sqlQuery = "select User.email_id, User.full_name, User.phone_no, House_Details.address, House_Details.city,"
					+ "House_Details.suburb, House_Details.distance_from_city, House_Details.public_transport,"
					+ "House_Details.no_of_rooms, House_Details.airconditioning, House_Details.swiming_pool,"
					+ "House_Details.points_required, House_Details.discounts, Letting_User_House_Availability.available_from,"
					+ "Letting_User_House_Availability.available_to, Letting_User_House_Availability.min_occupier_rating"
					+ " from User join House_Details on User.email_id = House_Details.email_id "
					+ "join Letting_User_House_Availability on User.email_id = Letting_User_House_Availability.email_id"
					+ " where House_Details.availabilityOfHouse = 'available' ";
			if (emailID != null) {
				sqlQuery += " and House_Details.points_required <= (select User.credits from User where User.email_id = '"
						+ emailID + "') and User.email_id != '"+emailID+"' ";
			}
			ResultSet resultSet = dbOperations.getData(sqlQuery);
			while (resultSet.next()) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put(Constants.emailId, resultSet.getString("email_id"));
				jsonObject.put(Constants.fullname, resultSet.getString("full_name"));
				jsonObject.put(Constants.phoneNo, resultSet.getString("phone_no"));
				jsonObject.put(Constants.address, resultSet.getString("address"));
				jsonObject.put(Constants.city, resultSet.getString("city"));
				jsonObject.put(Constants.suburb, resultSet.getString("suburb"));
				jsonObject.put(Constants.distance, resultSet.getString("distance_from_city"));
				jsonObject.put(Constants.publicTransport, resultSet.getString("public_transport"));
				jsonObject.put(Constants.noOfRooms, resultSet.getString("no_of_rooms"));
				jsonObject.put(Constants.airConditioning, resultSet.getString("airconditioning"));
				jsonObject.put(Constants.swimmingPool, resultSet.getString("swiming_pool"));
				jsonObject.put(Constants.points, resultSet.getString("points_required"));
				jsonObject.put(Constants.discounts, resultSet.getString("discounts"));
				jsonObject.put(Constants.availableFrom, resultSet.getString("available_from"));
				jsonObject.put(Constants.availableTo, resultSet.getString("available_to"));
				jsonObject.put(Constants.minOccupierRating, resultSet.getString("min_occupier_rating"));
				responseObject.add(jsonObject);

			}
			finalResponseObject.put(Constants.house_key, responseObject);
			if (responseObject != null) {
				finalResponseObject.put(Constants.statusCode, "0");
			} else {
				finalResponseObject.put(Constants.statusCode, "1");
			}
		} catch (SQLException se) {
			se.printStackTrace();
			finalResponseObject.put(Constants.statusCode, "1");
		}
		return finalResponseObject;
	}
}
