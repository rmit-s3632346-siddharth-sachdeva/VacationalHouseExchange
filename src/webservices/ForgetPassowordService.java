package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import common.Constants;
import common.SendEmail;
import model.ForgetPasswordModel;
import model.LoginModel;

public class ForgetPassowordService {
	String statusCode = "1";
	ForgetPasswordModel forgetPasswordModel = new ForgetPasswordModel();
	final static Logger logger = Logger.getLogger(LoginService.class);

	@POST
	public Response forgetPassword(String request) throws ParseException {
		JSONObject responseObject = new JSONObject();
		JSONObject requestObject = new JSONObject();
		JSONParser parser = new JSONParser();
		try{
		requestObject = (JSONObject) parser.parse(request);
		String emailId = requestObject.get(Constants.emailId).toString();
		String password = forgetPasswordModel.getPassword(emailId);
		statusCode=SendEmail.sendEmail(password);
		responseObject.put(Constants.statusCode, statusCode);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	
	}
	
}
