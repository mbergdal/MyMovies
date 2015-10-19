package controllers;
import interfaces.FileMediatorInterface;

import java.util.List;

import business.MyMovie;

public class MainViewController {
	
	private FileMediatorInterface fileMediator;

	public MainViewController(FileMediatorInterface fileMediator) {

		this.fileMediator = fileMediator;
	}

	public void addMovieAsFavorite(MyMovie movie){

		fileMediator.storeMovieAsFavorite(movie);
	}
	
	public List<String> getFavoriteMovies(){

		return fileMediator.getFavoriteIds();
	}
}
