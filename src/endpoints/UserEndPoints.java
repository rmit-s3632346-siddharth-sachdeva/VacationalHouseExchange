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
=======

>>>>>>> b260bd902324c310f6f06064d203476b1c131d50
	@Path("/logout")
	public LogoutService logoutEndPoint() {
		return new LogoutService();
	}
<<<<<<< HEAD
=======

>>>>>>> b260bd902324c310f6f06064d203476b1c131d50
	@Path("/forgetPassoword")
	public ForgetPassowordService forgetPassoword() {
		return new ForgetPassowordService();
	}

}
