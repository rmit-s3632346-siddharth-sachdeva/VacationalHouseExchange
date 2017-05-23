package webservices;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.ViewHouseModel;

public class ViewHouseService {

	ViewHouseModel viewHouseModel = new ViewHouseModel();
	final static Logger logger = Logger.getLogger(LoginService.class);
	JSONObject responseObject = new JSONObject();
	@POST
	public Response viewHouse(String request){
		try
		{
			String emailID = "";
			if(!request.equals("\"\"")){
			JSONObject requestObject = new JSONObject();
			JSONParser parser = new JSONParser();
			requestObject = (JSONObject) parser.parse(request);
			emailID=requestObject.get(Constants.emailId).toString();
			}
			responseObject=viewHouseModel.viewHouses(emailID);
		}
		catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getStackTrace());
			responseObject.put(Constants.statusCode, "1");
		}
		return Response.ok().entity(responseObject.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
}
