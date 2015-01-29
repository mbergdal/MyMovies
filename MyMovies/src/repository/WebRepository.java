package repository;
import java.util.ArrayList;
import java.util.Collection;

import it.jtomato.*;
import it.jtomato.gson.Movie;

public class WebRepository {
	private JTomato client;
		
	public WebRepository() {
		 client = new JTomato("ut2px3dxzsbqa53dyzgghrb3");		 
	}
	
	public WebRepository(JTomato client){
		this.client = client; 
	}
	
	public ArrayList<business.Movie> getBoxOfficeMovies(int limit){
		Collection<Movie> movies = client.getBoxOfficeMovies("no", limit);
		ArrayList<business.Movie> returnList = new ArrayList<>();
		for (Movie movie : movies) {
			returnList.add(new business.Movie(movie));
		}
		
		return returnList;
	}	
	
	public ArrayList<business.Movie> searchMovie(String searchString) {
		ArrayList<Movie> result = new ArrayList<Movie>();
		client.searchMovie(searchString, result, 1);
		ArrayList<business.Movie> returnList = new ArrayList<>();
		for (Movie movie : result) {
			returnList.add(new business.Movie(movie));
		}		
		
		return returnList;
	}
}