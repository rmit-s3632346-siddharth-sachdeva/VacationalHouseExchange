package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.ViewHouseRequestModel;

public class ViewHouseRequestService {
	

	String statusCode = "1";
	ViewHouseRequestModel viewHouseRequestModel = new ViewHouseRequestModel();
	final static Logger logger = Logger.getLogger(ViewHouseRequestService.class);
	@POST
	public Response viewHouseRequest(String request){
		JSONObject responseObject = new JSONObject();
		JSONObject requestObject = new JSONObject();
		try{
		JSONParser parser = new JSONParser();
		requestObject = (JSONObject) parser.parse(request);
		logger.info("ViewHouseRequestService called...");
	
			String ownerEmailId = requestObject.get(Constants.ownerEmailId).toString();
			String requesterEmailId = viewHouseRequestModel.viewHouseRequest(ownerEmailId);
			
			if(requesterEmailId == null || requesterEmailId.isEmpty()){
				statusCode = "2";
			}else{
				responseObject.put(Constants.requesterEmailId, requesterEmailId);
				statusCode = "0";
			}
			
			
			responseObject.put(Constants.statusCode, statusCode);
			
		}catch(Exception e){
			e.printStackTrace();
			statusCode = "1";
		}
		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

}
