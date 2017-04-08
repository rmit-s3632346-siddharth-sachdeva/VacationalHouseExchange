package endpoints;

import javax.ws.rs.Path;

import webservices.LoginService;

@Path("/userendpoints")
public class UserEndPoints {
	
	@Path("/login")
	public LoginService loginEndPoint() {
		return new LoginService();
	}
}
