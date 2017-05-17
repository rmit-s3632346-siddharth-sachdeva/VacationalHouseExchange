package endpoints;

import javax.ws.rs.Path;

import webservices.EditHouseDetailsService;
import webservices.ForgetPassowordService;
import webservices.LoginService;
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
	
	@Path("/forgetPassoword")
	public ForgetPassowordService forgetPassoword() {
		return new ForgetPassowordService();
	}
	
}
