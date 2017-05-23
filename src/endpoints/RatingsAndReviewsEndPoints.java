package endpoints;

import javax.ws.rs.Path;

import webservices.ReviewAndRatingService;
import webservices.ViewRatingsAndReviewsService;

@Path("/reviewnandrating")
public class RatingsAndReviewsEndPoints {

	@Path("/addreviewnandrating")
	public ReviewAndRatingService reviewAndRatingService() {
		return new ReviewAndRatingService();
	}
	
	
	@Path("/viewRatingsAndReviews")
	public ViewRatingsAndReviewsService viewRatingsAndReviewsService() {
		return new ViewRatingsAndReviewsService();
	}
}
