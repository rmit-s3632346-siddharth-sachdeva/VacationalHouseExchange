package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.BookHouseModel;
import model.LoginModel;
import model.RejectBookHouseRequestModel;

public class RejectBookRequestService {
	String statusCode;
	RejectBookHouseRequestModel rejectBookRequestModel = new RejectBookHouseRequestModel();
	
	@POST
	public Response bookHouse(String request) {
		JSONObject responseObject = null;
		try {
			JSONObject requestObject = new JSONObject();
			JSONParser parser = new JSONParser();
			requestObject = (JSONObject) parser.parse(request);
			String ownerEmailId = requestObject.get(Constants.OWNER_EMAIL).toString();
			statusCode = rejectBookRequestModel.rejectBookingReqModel(ownerEmailId);
			responseObject = new JSONObject();
			responseObject.put(Constants.statusCode, statusCode);
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "1";
		}
		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
		
	}
}
