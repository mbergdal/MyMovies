package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import controllers.MainViewController;
import business.MyMovie;
import interfaces.*;
import it.jtomato.gson.Movie;

public class TestsMainViewController {

	public boolean storeCalled;

	@Test
	public void addMovieAsFavorite_addsMovieAsFavorite() {
		MainViewController controller = new MainViewController(new MockFileMediator(), null);
		MyMovie movie = new MyMovie(new Movie());
		controller.addMovieAsFavorite(movie);
		assertTrue(storeCalled);
	}
	
	@Test
	public void getFavoriteMovies_getsFavorites() {
		MainViewController controller = new MainViewController(new MockFileMediator(), null);
		List<String> favoriteMovies = controller.getFavoriteMovies();
		assertEquals("123", favoriteMovies.get(0));
	}
	
	class MockFileMediator implements FileMediatorInterface{

		@Override
		public void storeMovieAsFavorite(MyMovie movie) {
			storeCalled = true;
		}

		@Override
		public List<String> getFavoriteIds() {
			return Arrays.asList("123");
		}
		
	}

}
