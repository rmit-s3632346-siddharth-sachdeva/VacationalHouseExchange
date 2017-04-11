package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.apache.log4j.jmx.LoggerDynamicMBean;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.LettingHouseModel;

public class LettingHouseService {
	
	String statusCode = "1";
	LettingHouseModel lettingHouseModel = new LettingHouseModel();
	final static Logger logger = Logger.getLogger(LoginService.class);

	@POST
	public Response lettingHouse(String request) {
		JSONObject responseObject = null;
		try {
			logger.info("Letting House Service Called...");
			JSONObject requestObject = new JSONObject();
			JSONParser parser = new JSONParser();
			responseObject = new JSONObject();
			requestObject = (JSONObject) parser.parse(request);
			if( requestObject.get(Constants.loggedInEmail) == null ||
				requestObject.get(Constants.availableFrom) == null ||
				requestObject.get(Constants.availableTo) == null ||
				requestObject.get(Constants.minOccupierRating) == null){
				statusCode = "1";
				String errorMessage = "Please pass all the required fields : loggedInEmail, availableFrom, availableTo, minOccupierRating";
				responseObject.put(Constants.statusCode, statusCode);
				responseObject.put(Constants.error_message, errorMessage);
				logger.error(errorMessage);
				return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
			}
			
			if( requestObject.get(Constants.loggedInEmail).toString().isEmpty() ||
					requestObject.get(Constants.availableFrom).toString().isEmpty() ||
					requestObject.get(Constants.availableTo).toString().isEmpty() ||
					requestObject.get(Constants.minOccupierRating).toString().isEmpty()){
					statusCode = "1";
					String errorMessage = "Please pass all the required fields : loggedInEmail, availableFrom, availableTo, minOccupierRating";
					responseObject.put(Constants.statusCode, statusCode);
					responseObject.put(Constants.error_message, errorMessage);
					logger.error(errorMessage);
					return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
							.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
				}
			
			String loggedInEmail = requestObject.get(Constants.loggedInEmail).toString();
			String availableFrom = requestObject.get(Constants.availableFrom).toString();
			String availableTo = requestObject.get(Constants.availableTo).toString();
			String minOccupierRating = requestObject.get(Constants.minOccupierRating).toString();
			statusCode = lettingHouseModel.lettingHouse(loggedInEmail, availableFrom, availableTo, minOccupierRating);
			
			responseObject.put(Constants.statusCode, statusCode);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			statusCode = "1";
			responseObject.put(Constants.statusCode, statusCode);
			responseObject.put(Constants.error_message, "Something went wrong...");
		}

		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}


}
