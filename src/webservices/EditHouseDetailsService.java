package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.EditHouseDetailsModel;
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
			statusCode = editHouseDetailsModel.editPersonalDetails(requestObject.get(Constants.fullname).toString(),
					requestObject.get(Constants.password).toString(), requestObject.get(Constants.emailId).toString(),
					requestObject.get(Constants.phoneNo).toString());
			if (statusCode.equals("0")) {
				statusCode = editHouseDetailsModel.editHouseDetails(requestObject.get(Constants.emailId).toString(),
						requestObject.get(Constants.address).toString(), requestObject.get(Constants.city).toString(),
						requestObject.get(Constants.suburb).toString(),
						requestObject.get(Constants.distance).toString(),
						requestObject.get(Constants.publicTransport).toString(),
						requestObject.get(Constants.noOfRooms).toString(),
						requestObject.get(Constants.airConditioning).toString(),
						requestObject.get(Constants.swimmingPool).toString(),
						requestObject.get(Constants.points).toString(),
						requestObject.get(Constants.discounts).toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
			statusCode = "1";
		}

		JSONObject responseObject = new JSONObject();
		responseObject.put(Constants.statusCode, statusCode);

		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}
}
