package endpoints;

import javax.ws.rs.Path;

import webservices.AcceptHouseRequestService;
import webservices.BookHouseService;

@Path("/bookHouseEndPoints")
public class BookHouseEndPoints {

	@Path("/bookHouse")
	public BookHouseService bookHouseEndPoint() {
		return new BookHouseService();
	}
	
	@Path("/acceptHouseRequest")
	public AcceptHouseRequestService acceptHouseRequestEndPoint() {
		return new AcceptHouseRequestService();
	}
	
	
	
}
