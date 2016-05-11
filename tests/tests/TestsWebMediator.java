package tests;

import static org.junit.Assert.*;
import it.jtomato.JTomato;
import it.jtomato.gson.Movie;
import it.jtomato.gson.Review;

import java.util.ArrayList;
import java.util.List;

import mediators.WebMediator;

import org.junit.Before;
import org.junit.Test;

import business.MyMovie;

public class TestsWebMediator {
	private interfaces.WebMediatorInterface mediator;
	private NetHttpClientMockUp httpClient = new NetHttpClientMockUp();
	
	@Before
	public void setUp() throws Exception {		
		mediator = new WebMediator(new JTomato("", httpClient));
	}
	
	@Test
	public void getBoxOfficeMovies_ReturnsOneMovie() {
		httpClient.setResponse(JsonResult.jsonBoxOfficeMovies);
		ArrayList<MyMovie> movies = mediator.getBoxOfficeMovies(10);
		assertEquals(movies.size(), 1);
		assertEquals("Harry Potter and the Deathly Hallows - Part 2", movies.get(0).getTitle());
	}
	
	@Test
	public void searchMovies_ReturnsOneMovie() {
		httpClient.setResponse(JsonResult.jsonMovieSearch);
		ArrayList<MyMovie> movies = mediator.searchMovie("something");
		assertEquals(1, movies.size());		
	}
	
	@Test
	public void getAdditionalInfo_ReturnsAdditionalInfoForMovie() {
		httpClient.setResponse(JsonResult.jsonBoxOfficeMovies);
		ArrayList<MyMovie> movies = mediator.getBoxOfficeMovies(10);
		httpClient.setResponse(JsonResult.jsonMovieInfo);
		MyMovie originalMovie = movies.get(0);
		assertNull(originalMovie.getInnerMovie().genres);
		
		Movie movieWithAdditionalInfo = mediator.getAdditionalInfo(originalMovie.getInnerMovie());
		
		assertNotNull(movieWithAdditionalInfo.genres);		
	}
	
	@Test
	public void getReviews_ReturnsReviewsForMovie() {
		httpClient.setResponse(JsonResult.jsonMovieReview);
		Movie originalMovie = new Movie();		
		List<Review> reviews =  mediator.getReviews(originalMovie);		
		assertEquals(20, reviews.size());		
	}	
}
