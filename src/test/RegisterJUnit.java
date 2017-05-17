package test;

import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import junit.framework.TestCase;
import model.RegisterModel;
import webservices.RegisterService;

public class RegisterJUnit extends TestCase {

	RegisterModel registerModel;
	RegisterService registerService;
	String emailId = System.currentTimeMillis() + "@y.com", statusCode;

	public void setUp() {
		registerModel = new RegisterModel();
	}

	@Test
	public void testregisterWithNewUser() {
		String fullname = null, password = "rachita123#", phoneNo = "0416857086";
		statusCode = registerModel.register(fullname, password, emailId, phoneNo);
		assertEquals("0", statusCode);
	}

	@Test
	public void testEnteringHouseDetails() {
		String address = "38 Wests Road", city = null, suburb = "Maribyrnong", distance = "10km",
				publicTransport = "bus, train, tram", noOfRooms = "6", airConditioning = null, swimmingPool = null,
				points = "50", discounts = "10";
		statusCode = registerModel.registerHouseDetails(emailId, address, city, suburb, distance, publicTransport,
				noOfRooms, airConditioning, swimmingPool, points, discounts);
		assertEquals("0", statusCode);
	}

	@Test
	public void testPaymentDetails() {
		String statusCode, cardNo = "1234567890256325", amount = "1000";
		statusCode = registerModel.paymentDetails(emailId, cardNo, amount);
		assertEquals("0", statusCode);
	}

	@Test
	public void testSettingAvailability() {
		statusCode = registerModel.settingAvailability(emailId);
		assertEquals("0", statusCode);
	}

}
