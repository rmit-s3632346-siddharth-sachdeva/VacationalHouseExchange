package endpoints;

import javax.ws.rs.Path;

import webservices.AcceptHouseRequestService;
import webservices.BookHouseService;
import webservices.RejectBookRequestService;

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
}
