package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import business.Movie;

public class TestsMovie {

	@Test
	public void getTitle_GetsCorrectTitle() {
		it.jtomato.gson.Movie m = new it.jtomato.gson.Movie();
		m.title = "Pelle";
		Movie movie = new Movie(m);
		assertEquals("Pelle", movie.getTitle());		
	}
	
	@Test
	public void getId_getsCorrectId() {
		it.jtomato.gson.Movie m = new it.jtomato.gson.Movie();
		m.id = "123";
		Movie movie = new Movie(m);
		assertEquals("123", movie.getId());		
	}

}
