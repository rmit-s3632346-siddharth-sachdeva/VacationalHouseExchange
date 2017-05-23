package endpoints;

import javax.ws.rs.Path;

import webservices.BookHouseService;
import webservices.RejectBookRequestService;
import webservices.ViewHouseRequestService;

@Path("/bookHouseEndPoints")
public class BookHouseEndPoints {

	@Path("/bookHouse")
	public BookHouseService bookHouseEndPoint() {
		return new BookHouseService();
	}
	@Path("/rejectBookRequest")
	public RejectBookRequestService rejectBookRequestEndPoint() {
		return new RejectBookRequestService();
	}
	@Path("/acceptHouseRequest")
	public AcceptHouseRequestService acceptHouseRequestEndPoint() {
		return new AcceptHouseRequestService();
	}
	
	@Path("/viewHouseRequest")
	public ViewHouseRequestService viewHouseRequestService() {
		return new ViewHouseRequestService();
	}
}
