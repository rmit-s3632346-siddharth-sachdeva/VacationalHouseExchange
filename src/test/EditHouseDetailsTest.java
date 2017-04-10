package test;

import org.junit.Test;

import junit.framework.TestCase;
import model.EditHouseDetailsModel;

public class EditHouseDetailsTest extends TestCase{

	EditHouseDetailsModel editHouseDetailsModel;
	String emailId = "1491819827990@y.com", statusCode;
	
	public void setUp() {
		editHouseDetailsModel = new EditHouseDetailsModel();
	}
	
	@Test
	public void testEditPersonalDetails() {
		String fullname = "rachita", password = "rachita123#", phoneNo = "0416857086";
		statusCode = editHouseDetailsModel.editPersonalDetails(fullname, password, emailId, phoneNo);
		assertEquals("0", statusCode);
	}
	@Test
	public void testEditHouseDetails() {
		String address = "38 Wests Road", city = "Melbourne", suburb = "Maribyrnong", distance = "10km",
				publicTransport = "bus, train, tram", noOfRooms = "6", airConditioning = "YES", swimmingPool = "YES",
				points = "50", discounts = "10";
		statusCode = editHouseDetailsModel.editHouseDetails(emailId, address, city, suburb, distance, publicTransport,
				noOfRooms, airConditioning, swimmingPool, points, discounts);
		assertEquals("0", statusCode);
	}
}
