package test;

import org.junit.Test;

import junit.framework.TestCase;
import model.LettingHouseModel;

public class LettingHouseTest extends TestCase {
	
	LettingHouseModel lettingHouseModel;
	String statusCode = "1";
	
	public void setUp(){
		lettingHouseModel = new LettingHouseModel();
	}	
	
	@Test
	public void testLettingHousePass(){
		String testEmailId = "demouser@test.com";
		String testAvailableFrom = "20-10-2017";
		String testAvailableTo = "20-12-2017";
		String testMinOccupierRating = "1000";
		String statusCode = lettingHouseModel.lettingHouse(testEmailId, testAvailableFrom, testAvailableTo, testMinOccupierRating);
		assertEquals("0", statusCode);
	}
	
	@Test
	public void testLettingHouseFail(){
		String testEmailId = "invaliduser@@@";
		String testAvailableFrom = "20-10-2017";
		String testAvailableTo = "20-12-2017";
		String testMinOccupierRating = "1000";
		String statusCode = lettingHouseModel.lettingHouse(testEmailId, testAvailableFrom, testAvailableTo, testMinOccupierRating);
		assertEquals("1", statusCode);
	}

	@Test
	public void testLettingHouseNotPassingSufficientDataFail(){
		//We are not passing email id which is the required field.
		String testAvailableFrom = "20-10-2017";
		String testAvailableTo = "20-12-2017";
		String testMinOccupierRating = "1000";
		String statusCode = lettingHouseModel.lettingHouse(null, testAvailableFrom, testAvailableTo, testMinOccupierRating);
		assertEquals("1", statusCode);
	}

}
