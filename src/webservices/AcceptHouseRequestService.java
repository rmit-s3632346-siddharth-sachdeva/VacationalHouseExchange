package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.AcceptHouseRequestModel;


public class AcceptHouseRequestService {
	
	String statusCode = "1";
	AcceptHouseRequestModel acceptHouseRequestModel = new AcceptHouseRequestModel();
	final static Logger logger = Logger.getLogger(AcceptHouseRequestService.class);

	@POST
	public Response acceptHouseRequest(String request){
		JSONObject responseObject = new JSONObject();
		logger.info("AcceptHouseRequestService called...");
		try {
			JSONObject requestObject = new JSONObject();
			JSONParser parser = new JSONParser();
			requestObject = (JSONObject) parser.parse(request);
			String ownerEmailID = requestObject.get(Constants.ownerEmailId).toString();
			statusCode = acceptHouseRequestModel.acceptHouseRequest(ownerEmailID);
		}catch(Exception e){
			e.printStackTrace();
			statusCode = "1";
		}
		responseObject.put(Constants.statusCode, statusCode);
		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

}