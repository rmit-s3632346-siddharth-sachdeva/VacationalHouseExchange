package webservices;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import common.Constants;
import model.ViewHouseRequestModel;

public class ViewHouseRequestService {
	

	String statusCode = "1";
	ViewHouseRequestModel viewHouseRequestModel = new ViewHouseRequestModel();
	final static Logger logger = Logger.getLogger(ViewHouseRequestService.class);
	
	public Response viewHouseRequest(String request){
		JSONObject responseObject = new JSONObject();
		logger.info("ViewHouseRequestService called...");
		try{
			String ownerEmailId = responseObject.get(Constants.emailId).toString();
			String requesterEmailId = viewHouseRequestModel.viewHouseRequest(ownerEmailId);
			
			responseObject.put(Constants.requesterEmailId, requesterEmailId);
			
		}catch(Exception e){
			e.printStackTrace();
			statusCode = "1";
		}
		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

}
