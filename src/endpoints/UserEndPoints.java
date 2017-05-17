package endpoints;

import javax.ws.rs.Path;

import webservices.EditHouseDetailsService;
import webservices.ForgetPassowordService;
import webservices.LoginService;
import webservices.LogoutService;
import webservices.RegisterService;

@Path("/userendpoints")
public class UserEndPoints {
	
	@Path("/login")
	public LoginService loginEndPoint() {
		return new LoginService();
	}
	
	@Path("/register")
	public RegisterService registerEndPoint() {
		return new RegisterService();
	}
	
	@Path("/editHouseDetails")
	public EditHouseDetailsService editHouseDetails() {
		return new EditHouseDetailsService();
	}
	
<<<<<<< HEAD
	@Path("/logout")
	public LogoutService logoutEndPoint() {
		return new LogoutService();
=======
	@Path("/forgetPassoword")
	public ForgetPassowordService forgetPassoword() {
		return new ForgetPassowordService();
>>>>>>> a7b9c6d91d0f7ef0a0c03d60e4b6e13338b09c89
	}
	
}
