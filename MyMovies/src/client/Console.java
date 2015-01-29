package client;

import java.util.ArrayList;

import business.Movie;
import repository.WebRepository;

public class Console {

	public static void main(String[] args) {
		WebRepository repo = new WebRepository();
		ArrayList<Movie> movies = repo.getBoxOfficeMovies(3);
		ArrayList<Movie> result = repo.searchMovie("Orion");
		for (Movie movie : movies) {
			System.out.println(movie.getId() + ": " + movie.getTitle());
		}
		
		System.out.println(result.size());
	}
}
