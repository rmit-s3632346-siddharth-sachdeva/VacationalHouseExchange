package endpoints;

import javax.ws.rs.Path;

import webservices.ReviewAndRatingService;

@Path("/reviewnandrating")
public class ReviewAndRatingEndPoints {

	@Path("/addreviewnandrating")
	public ReviewAndRatingService reviewAndRatingService() {
		return new ReviewAndRatingService();
	}
	
}
