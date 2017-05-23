package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.ReviewAndRatingModel;

public class ReviewAndRatingService {
	final static Logger logger = Logger.getLogger(LoginService.class);
	String statusCode = "1";
	@POST
	public Response addingReviewAndRating(String request) {
		JSONObject responseObject = null;
		JSONObject requestObject = new JSONObject();
		JSONParser parser = new JSONParser();
		try{			
			requestObject = (JSONObject) parser.parse(request);
			logger.info("addingReviewAndRating Called...");
			String review = (String) requestObject.get(Constants.review), rating = (String) requestObject.get(Constants.rating), email = (String) requestObject.get(Constants.emailId);
			statusCode=ReviewAndRatingModel.addReviewAndRating(review, rating, email);
			if(statusCode == "0"){
				logger.info("Review and Rating Added Successfully.");
			}
			responseObject = new JSONObject();
			responseObject.put(Constants.statusCode, statusCode);
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex);
			statusCode = "1";
		}
		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
		
	}
}
