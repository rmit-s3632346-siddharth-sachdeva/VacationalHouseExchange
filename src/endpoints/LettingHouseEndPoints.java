package endpoints;

import javax.ws.rs.Path;

import webservices.LettingHouseService;

@Path("/lettinghouseendpoints")
public class LettingHouseEndPoints {

	@Path("/lettingHouse")
	public LettingHouseService lettingHouseEndPoint() {
		return new LettingHouseService();
	}
	
}
