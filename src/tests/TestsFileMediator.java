package tests;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import it.jtomato.gson.Movie;
import mediators.FileMediator;

import org.junit.Before;
import org.junit.Test;

import business.MyMovie;

public class TestsFileMediator {
	File favoritesFile = new File("fileStore/favoritesTests.txt");
	
	@Before
	public void beforeTests(){
		if(favoritesFile.exists()){
			favoritesFile.delete();
		}
	}
	
	@Test
	public void storeMovieAsFavorite_MovieIsStored() throws Exception{
		Movie innerMovie = new Movie();
		innerMovie.id = "123";
		MyMovie movie = new MyMovie(innerMovie);
		FileMediator fileMediator = new FileMediator();
		fileMediator.setFile(favoritesFile.getAbsolutePath());
		fileMediator.storeMovieAsFavorite(movie);
		movie.getInnerMovie().id = "234";
		fileMediator.storeMovieAsFavorite(movie);
	
		Scanner reader = new Scanner(favoritesFile);
		String line = reader.nextLine();
		String line2 = reader.nextLine();
		reader.close();
		assertTrue(line.startsWith("123"));
		assertTrue(line2.startsWith("234"));
	}
	
	@Test
	public void getFavoriteIds_getsIds() throws Exception{
		writeTestIdsToFile();		
		FileMediator fileMediator = new FileMediator();
		fileMediator.setFile(favoritesFile.getAbsolutePath());
		List<String> favoriteIds = fileMediator.getFavoriteIds();
		assertEquals("123", favoriteIds.get(0));
		assertEquals("456", favoriteIds.get(1));
		assertEquals("789", favoriteIds.get(2));
	}

	private void writeTestIdsToFile() {
		try(FileWriter writer = new FileWriter(favoritesFile);){
			writer.append("123\n");
			writer.append("456\n");
			writer.append("789");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
