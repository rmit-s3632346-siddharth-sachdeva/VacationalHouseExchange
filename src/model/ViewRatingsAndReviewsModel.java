package model;

import java.sql.ResultSet;

import org.json.simple.JSONObject;

import common.Constants;
import database.DBOperations;

public class ViewRatingsAndReviewsModel {
	private String statusCode = "1";
	private DBOperations dbOperations = new DBOperations();
	
	public JSONObject viewRatingsAndReviews(String houseOwnerEmailId){
		JSONObject data = new JSONObject();
		
		try{
			String sqlQuery = "Select Review, Rating from House_Details WHERE email_id = '"+houseOwnerEmailId+"'";
			ResultSet resultSet = dbOperations.getData(sqlQuery);
			int sumOfRatings = 0;
			int numberOfRatings = 0;
			while(resultSet.next()){
				data.put(Constants.review, resultSet.getString("review"));
				data.put(Constants.rating, resultSet.getString("rating"));
				numberOfRatings++;
				sumOfRatings += Integer.parseInt(resultSet.getString("rating")); 
			}
			statusCode ="0";
			data.put(Constants.averageRating, String.valueOf(sumOfRatings/numberOfRatings));
			data.put(Constants.statusCode, statusCode);
		}catch(Exception e){
			e.printStackTrace();
			statusCode ="1";
			data.put(Constants.statusCode, statusCode);
		}
		
		return data;
	}
	
}
