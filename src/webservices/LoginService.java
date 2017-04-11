package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.LoginModel;

public class LoginService {

	String statusCode = "1";
	LoginModel loginModel = new LoginModel();
	final static Logger logger = Logger.getLogger(LoginService.class);
	
	@POST
	public Response login(String request) {
		JSONObject responseObject = null;
		try {
			JSONObject requestObject = new JSONObject();
			JSONParser parser = new JSONParser();
			requestObject = (JSONObject) parser.parse(request);
			String emailId = requestObject.get(Constants.emailId).toString();
			String password = requestObject.get(Constants.password).toString();
			logger.info("trying login operation for user:"+emailId);
			statusCode = loginModel.loginModel(emailId, password);
			if(statusCode == "0"){
				logger.info("User :"+emailId+" logged in successfully.");
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