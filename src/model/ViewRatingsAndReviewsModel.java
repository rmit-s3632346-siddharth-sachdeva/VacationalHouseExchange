package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import common.Constants;
import database.DBOperations;

public class ViewRatingsAndReviewsModel {
	public static String statusCode = "1";
	private DBOperations dbOperations = new DBOperations();
	//JSONArray data = new JSONArray();
	List<JSONObject> data = new ArrayList<>();
	
	JSONObject finalData = new JSONObject();

	public JSONObject viewRatingsAndReviews(String houseOwnerEmailId) {

		try {
			String sqlQuery = "Select Review, Rating from House_Review_Rating WHERE Email = '" + houseOwnerEmailId
					+ "'";
			ResultSet resultSet = dbOperations.getData(sqlQuery);
			double sumOfRatings = 0;
			double numberOfRatings = 0;
			int ctr = 0;
			while (resultSet.next()) {
				JSONObject currentData = new JSONObject();
				currentData.put(Constants.review, resultSet.getString("review"));
				currentData.put(Constants.ratings, resultSet.getString("rating"));
				numberOfRatings++;
				sumOfRatings += Integer.parseInt(resultSet.getString("rating"));
				data.add(currentData);
			}
			finalData.put(Constants.house_key, data);
			statusCode = "0";
			if (numberOfRatings > 0) {
				double avg = sumOfRatings / numberOfRatings;
				String formattedAvg = String.format("%.2f", avg);
				finalData.put(Constants.averageRating, formattedAvg);
				finalData.put(Constants.statusCode, statusCode);

			} else {
				statusCode = "1";
				finalData.put(Constants.statusCode, statusCode);
			}

		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "1";
			finalData.put(Constants.statusCode, statusCode);
		}

		return finalData;
	}

}
