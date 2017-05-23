package endpoints;

import javax.ws.rs.Path;

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
}
