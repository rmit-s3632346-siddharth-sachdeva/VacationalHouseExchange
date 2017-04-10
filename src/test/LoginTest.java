package test;

import org.junit.Test;

import junit.framework.TestCase;
import model.LettingHouseModel;
import model.LoginModel;

public class LoginTest extends TestCase {
	
	LoginModel loginModel;
	String statusCode = "1";
	public void setUp(){
		loginModel = new LoginModel();
	}
	
	@Test
	public void testLoginPass(){
		String testUsername = "s3632346@student.rmit.edu.au";
		String testPassword = "e763a2afeb4ffc5372345293d65308236c5de7575f766ce33d5e493e62d614de";
		statusCode = loginModel.loginModel(testUsername, testPassword);
		assertEquals("0", statusCode);
	}
	
	@Test
	public void testLoginFail(){

		String testUsername = "s3632346@student.rmit.edu.au";
		String testPassword = "LOL!!";
		statusCode = loginModel.loginModel(testUsername, testPassword);
		assertEquals("1", statusCode);
	}
}
