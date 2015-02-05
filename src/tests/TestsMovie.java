package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.WebMediatorInterface;
import it.jtomato.gson.Movie;
import it.jtomato.gson.Rating;
import it.jtomato.gson.Review;

import org.junit.Test;

import business.MyMovie;

public class TestsMovie {

	@Test
	public void getTitle_GetsCorrectTitle() {
		Movie m = new Movie();
		m.title = "Pelle";
		MyMovie movie = new MyMovie(m);
		assertEquals("Pelle", movie.getTitle());		
	}
	
	@Test
	public void getId_getsCorrectId() {
		Movie m = new Movie();
		m.id = "123";
		MyMovie movie = new MyMovie(m);
		assertEquals("123", movie.getId());		
	}
	
	@Test
	public void getRating_getsCorrectRating() {
		Movie m = new Movie();
		m.rating = new Rating();
		m.rating.audienceScore = 100;
		MyMovie movie = new MyMovie(m);
		assertEquals(100, movie.getRating());		
	}
	
	@Test
	public void getSynopsis_getsCorrectSynopsis() {
		Movie m = new Movie();
		m.synopsis = "synopsis";		
		MyMovie movie = new MyMovie(m);
		assertEquals("synopsis", movie.getSynopsis());		
	}
	
	@Test
	public void getGenres_getsCorrectGenres() {
		Movie m = new Movie();
		m.genres = Arrays.asList("Comedy", "Family");
		WebMediatorInterface mediator = new MockWebMediator(m);
		MyMovie movie = new MyMovie(m, mediator);
		assertEquals("Comedy", movie.getGenres().get(0));		
	}
	
	@Test
	public void getReviews_getsReviews() {
		Movie m = new Movie();
		MockWebMediator mediator = new MockWebMediator(m);
		mediator.setReviews(Arrays.asList(new Review(), new Review()));
		MyMovie movie = new MyMovie(m, mediator);
		assertEquals(2, movie.getReviews().size());		
	}
	
	private class MockWebMediator implements WebMediatorInterface{

		private Movie movie;
		private List<Review> reviews;
		
		public MockWebMediator(Movie movie) {
			this.movie = movie;
		}
		
		public void setReviews(List<Review> reviews){
			this.reviews = reviews;
		}
		
		@Override
		public ArrayList<MyMovie> getBoxOfficeMovies(int limit) {
			return null;
		}

		@Override
		public ArrayList<MyMovie> searchMovie(String searchString) {
			return null;
		}

		@Override
		public Movie getAdditionalInfo(Movie movie) {
			return this.movie;
		}

		@Override
		public List<Review> getReviews(Movie movie) {
			return this.reviews;
		}		
	}
}
