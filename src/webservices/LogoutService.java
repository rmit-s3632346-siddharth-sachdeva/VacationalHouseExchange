package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.LoginModel;
import model.LogoutModel;

public class LogoutService {

	String statusCode = "1";
	LogoutModel logoutModel = new LogoutModel();
	final static Logger logger = Logger.getLogger(LogoutService.class);
	
	@POST
	public Response logout(String request) {
		JSONObject responseObject = null;
		try {
			JSONObject requestObject = new JSONObject();
			JSONParser parser = new JSONParser();
			requestObject = (JSONObject) parser.parse(request);
			String emailId = requestObject.get(Constants.emailId).toString();
			logger.info("trying logout operation for user:"+emailId);
			statusCode = logoutModel.logoutModel(emailId);
			if(statusCode == "0"){
				logger.info("User :"+emailId+" logged out successfully.");
			}
			responseObject = new JSONObject();
			responseObject.put(Constants.statusCode, statusCode);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			statusCode = "1";
		}

		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
	
}