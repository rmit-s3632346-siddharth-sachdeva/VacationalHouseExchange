package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.RegisterModel;

public class RegisterService {

	RegisterModel registerModel = new RegisterModel();
	String statusCode = "0";
	final static Logger logger = Logger.getLogger(LoginService.class);
	JSONObject responseObject = new JSONObject();
	JSONObject requestObject = new JSONObject();
	JSONParser parser = new JSONParser();

	@POST
	public Response register(String request) {

		try {
			logger.info(request);
			statusCode = registerModel.register(requestObject.get(Constants.fullname).toString(),
					requestObject.get(Constants.password).toString(), requestObject.get(Constants.emailId).toString(),
					requestObject.get(Constants.phoneNo).toString());
			if (statusCode.equals("0")) {
				logger.info("successful entry in User table: " + requestObject.get(Constants.emailId).toString());
				statusCode = registerModel.registerHouseDetails(requestObject.get(Constants.emailId).toString(),
						requestObject.get(Constants.address).toString(), requestObject.get(Constants.city).toString(),
						requestObject.get(Constants.suburb).toString(),
						requestObject.get(Constants.distance).toString(),
						requestObject.get(Constants.publicTransport).toString(),
						requestObject.get(Constants.noOfRooms).toString(),
						requestObject.get(Constants.airConditioning).toString(),
						requestObject.get(Constants.swimmingPool).toString(),
						requestObject.get(Constants.points).toString(),
						requestObject.get(Constants.discounts).toString());
				if (statusCode.equals("0")) {
					logger.info("successful entry in House_Details table: "
							+ requestObject.get(Constants.emailId).toString());
					statusCode = registerModel.paymentDetails(requestObject.get(Constants.emailId).toString(),
							requestObject.get(Constants.cardNo).toString(),
							requestObject.get(Constants.amount).toString());
					if (statusCode.equals("0")) {
						logger.info("successful entry in Payment_Details table: "
								+ requestObject.get(Constants.emailId).toString());
						statusCode = registerModel.settingAvailability(requestObject.get(Constants.emailId).toString());
						logger.info("Letting_User_House_Availability statusCode: " + statusCode + " : "
								+ requestObject.get(Constants.emailId).toString());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
			statusCode = "1";
		}

		responseObject.put(Constants.statusCode, statusCode);
		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}
}
