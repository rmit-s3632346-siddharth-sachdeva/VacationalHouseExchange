package model;

import database.DBOperations;

public class ReviewAndRatingModel {
	static String sqlQuery;
	static String statusCode = "1";
	static DBOperations dbOperations = new DBOperations();
	public static String addReviewAndRating(String review, String rating, String Email){
		sqlQuery = "insert into House_Review_Rating (Email, Rating, Review) values ('"+Email+"','"+rating+"','"+review+"')";
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;
	}

}
