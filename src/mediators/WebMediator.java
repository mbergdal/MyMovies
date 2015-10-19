package mediators;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import interfaces.WebMediatorInterface;
import it.jtomato.*;
import it.jtomato.gson.Movie;
import it.jtomato.gson.Review;

public class WebMediator implements WebMediatorInterface {
	private JTomato client;
		
	public WebMediator() {

		client = new JTomato("ut2px3dxzsbqa53dyzgghrb3");
	}
	
	public WebMediator(JTomato client){

		this.client = client;
	}
		
	@Override
	public ArrayList<business.MyMovie> getBoxOfficeMovies(int limit){
		Collection<Movie> movies = client.getBoxOfficeMovies("no", limit);
		ArrayList<business.MyMovie> returnList = new ArrayList<>();
		for (Movie movie : movies) {
			returnList.add(new business.MyMovie(movie));
		}
		
		return returnList;
	}	
		
	@Override
	public ArrayList<business.MyMovie> searchMovie(String searchString) {
		ArrayList<Movie> result = new ArrayList<Movie>();
		client.searchMovie(searchString, result, 1);
		ArrayList<business.MyMovie> returnList = new ArrayList<>();
		for (Movie movie : result) {
			returnList.add(new business.MyMovie(movie));
		}		
		
		return returnList;
	}

	@Override
	public Movie getAdditionalInfo(Movie movie) {
		return client.getMovieAdditionalInfo(movie);
	}
	
	@Override
	public List<Review> getReviews(Movie movie){
		List<Review> reviewResults = new ArrayList<>();
		int numberOfReviews = client.getMovieReviews(movie, reviewResults, ReviewType.ALL, 1, "no");
		return reviewResults;
	}
}