package client;

import interfaces.WebMediatorInterface;
import it.jtomato.gson.Review;

import java.util.ArrayList;
import java.util.List;

import mediators.WebMediator;
import business.MyMovie;

public class Console {

	public static void main(String[] args) {
		WebMediatorInterface repo = new WebMediator();
		ArrayList<MyMovie> movies = repo.getBoxOfficeMovies(3);
		ArrayList<MyMovie> result = repo.searchMovie("Paddington");
		for (MyMovie movie : movies) {
			System.out.println(movie.getId() + ": " + movie.getTitle());
		}
		
		List<Review> reviews = repo.getReviews(movies.get(0).getInnerMovie());
		
		System.out.println(reviews.get(0).publication);
	}
}
