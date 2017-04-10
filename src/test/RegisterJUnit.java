package test;

import org.junit.Test;

import junit.framework.TestCase;
import model.RegisterModel;

public class RegisterJUnit extends TestCase {

	RegisterModel registerModel;
	String emailId = "s3636678@student.rmit.edu.au", statusCode;

	public void setUp() {
		registerModel = new RegisterModel();
	}

	@Test
	public void testregisterWithNewUser() {
		String fullname = "rachita", password = "rachita123#", phoneNo = "0416857086";
		statusCode = registerModel.register(fullname, password, emailId, phoneNo);
		assertEquals("0", statusCode);
	}

	@Test
	public void testEnteringHouseDetails() {
		String address = "38 Wests Road", city = "Melbourne", suburb = "Maribyrnong", distance = "10km",
				publicTransport = "bus, train, tram", noOfRooms = "6", airConditioning = "YES", swimmingPool = "YES",
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
