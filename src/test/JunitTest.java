package test;

import org.junit.Test;

import junit.framework.TestCase;
import model.LettingHouseModel;
import model.LoginModel;

public class JunitTest extends TestCase {
	
	LoginModel loginModel;
	LettingHouseModel lettingHouseModel;
	String statusCode = "1";
	public void setUp(){
		loginModel = new LoginModel();
		lettingHouseModel = new LettingHouseModel();
	}
	
	@Test
	public void testLoginPass(){
		String testUsername = "s3632346";
		String testPassword = "pass123#";
		statusCode = loginModel.loginModel(testUsername, testPassword);
		assertEquals("0", statusCode);
	}
	
	@Test
	public void testLoginFail(){

		String testUsername = "s3632346";
		String testPassword = "LOL!!";
		statusCode = loginModel.loginModel(testUsername, testPassword);
		assertEquals("1", statusCode);
	}
	
	@Test
	public void testLettingHousePass(){
		String testEmailId = "demouser";
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

}
