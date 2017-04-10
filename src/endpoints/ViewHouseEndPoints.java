package endpoints;

import javax.ws.rs.Path;

import webservices.LettingHouseService;
import webservices.ViewHouseService;

@Path("/viewHouseEndPoints")
public class ViewHouseEndPoints {
	@Path("/viewHouse")
	public ViewHouseService ViewHouseEndPoints() {
		return new ViewHouseService();
	}
}
