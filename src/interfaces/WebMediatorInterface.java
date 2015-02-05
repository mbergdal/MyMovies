package interfaces;

import it.jtomato.gson.Movie;
import it.jtomato.gson.Review;

import java.util.ArrayList;
import java.util.List;

public interface WebMediatorInterface {

	public abstract ArrayList<business.MyMovie> getBoxOfficeMovies(int limit);

	public abstract ArrayList<business.MyMovie> searchMovie(String searchString);
	
	public abstract Movie getAdditionalInfo(Movie movie);

	public abstract List<Review> getReviews(Movie movie);
}