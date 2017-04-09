package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
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
			logger.info("Letting House Service Called...:");
			JSONObject requestObject = new JSONObject();
			JSONParser parser = new JSONParser();
			requestObject = (JSONObject) parser.parse(request);
			String loggedInEmail = requestObject.get("loggedInEmail").toString();
			String availableFrom = requestObject.get("availableFrom").toString();
			String availableTo = requestObject.get("availableTo").toString();
			String minOccupierRating = requestObject.get("minOccupierRating").toString();
			statusCode = lettingHouseModel.lettingHouse(loggedInEmail, availableFrom, availableTo, minOccupierRating);
			responseObject = new JSONObject();
			responseObject.put(Constants.statusCode, statusCode);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
			statusCode = "1";
		}

		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}


}
