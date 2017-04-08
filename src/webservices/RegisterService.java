package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import common.Constants;



public class RegisterService {

	@POST
	public Response register(String request){
		
		
		
		return Response.ok().entity(Constants.statusCode).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
		
	}
}
