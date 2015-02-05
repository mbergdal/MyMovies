package mediators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.FileMediatorInterface;
import business.MyMovie;

public class FileMediator implements FileMediatorInterface{
	private String favoritesFilePath = "fileStore/favorites.txt";

	public void storeMovieAsFavorite(MyMovie movie){
		File file = new File(favoritesFilePath);
		try(FileWriter writer = new FileWriter(file, true);){
			writer.append(movie.getId() + "\n");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getFavoriteIds() {
		ArrayList<String> returnList = new ArrayList<String>();
		try(Scanner reader = new Scanner(new File(favoritesFilePath));){
			while(reader.hasNext()){
				returnList.add(reader.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return returnList;
	}
	
	public void setFile(String filePath){
		favoritesFilePath = filePath;
	}
}
