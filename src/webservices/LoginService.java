package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.LoginModel;

public class LoginService {

	String statusCode = "1";
	LoginModel loginModel = new LoginModel();
	final static Logger logger = Logger.getLogger(LoginService.class);
	
	@POST
	public Response login(String request) {
		try {
			
			JSONObject requestObject = new JSONObject();
			JSONParser parser = new JSONParser();
			requestObject = (JSONObject) parser.parse(request);
			String username = requestObject.get("username").toString();
			String password = requestObject.get("password").toString();
			logger.info("trying login operation for user:"+username);
			statusCode = loginModel.loginModel(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
			statusCode = "1";
		}

		return Response.ok().entity(statusCode).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
	
}