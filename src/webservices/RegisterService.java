package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.RegisterModel;

public class RegisterService {

	RegisterModel registerModel = new RegisterModel();
	String statusCode = "0";

	@POST
	public Response register(String request) {

		try {
			JSONObject requestObject = new JSONObject();
			JSONParser parser = new JSONParser();
			requestObject = (JSONObject) parser.parse(request);
			statusCode = registerModel.register(requestObject.get(Constants.username).toString(),
					requestObject.get(Constants.password).toString(), requestObject.get(Constants.emailId).toString(),
					requestObject.get(Constants.phoneNo).toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "1";
		}

		return Response.ok().entity(statusCode).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}
}
