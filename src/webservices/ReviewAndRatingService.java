package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

public class ReviewAndRatingService {
	final static Logger logger = Logger.getLogger(LoginService.class);
	@POST
	public Response addingReviewAndRating(String request) {
		try{
			logger.info("addingReviewAndRating Called...");
			
		return null;
		}catch(Exception ex){
			return null;
		}
		
	}
}
