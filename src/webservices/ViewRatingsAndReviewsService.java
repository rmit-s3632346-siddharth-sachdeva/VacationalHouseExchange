package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.ViewRatingsAndReviewsModel;

public class ViewRatingsAndReviewsService {
	
	String statusCode = "1";
	ViewRatingsAndReviewsModel viewRatingsAndReviewsModel = new ViewRatingsAndReviewsModel();
	final static Logger logger = Logger.getLogger(ViewRatingsAndReviewsService.class);
	
	
	@POST
	public Response viewRatingsAndReviews(String request){
		JSONObject responseObject = null;
		try{
			JSONObject requestObject = new JSONObject();
			JSONParser parser = new JSONParser();
			requestObject = (JSONObject) parser.parse(request);
			
			String emailId = requestObject.get(Constants.emailId).toString();
			logger.info("viewRatingsAndReviews Service called...");
			statusCode = viewRatingsAndReviewsModel.viewRatingsAndReviews(emailId).toString();
		}catch(Exception e){
			e.printStackTrace();
			logger.info("Something went wrong...:"+e.getMessage());
		}
		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

}
