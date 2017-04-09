package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.RegisterModel;

public class EditHouseDetailsService {

	EditHouseDetailsModel editHouseDetailsModel = new EditHouseDetailsModel();
	String statusCode = "0";
	final static Logger logger = Logger.getLogger(LoginService.class);
	
	@POST
	public Response editHouse(String request){
		try {
			logger.info(request);
			JSONObject requestObject = new JSONObject();
			JSONParser parser = new JSONParser();
			requestObject = (JSONObject) parser.parse(request);
			statusCode = editHouseDetailsModel.editHouse(requestObject.get(Constants.username).toString());

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
			statusCode = "1";
		}
	}
}
