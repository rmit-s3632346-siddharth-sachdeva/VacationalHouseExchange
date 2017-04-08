package test;

import org.junit.Test;

import junit.framework.TestCase;
import model.LoginModel;

public class JunitTest extends TestCase {
	
	LoginModel loginModel;
	String statusCode = "1";
	public void setUp(){
		loginModel = new LoginModel();
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

}
