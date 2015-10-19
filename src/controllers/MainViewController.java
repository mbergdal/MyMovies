package controllers;
import com.sun.javafx.collections.ObservableListWrapper;
import interfaces.FileMediatorInterface;

import java.util.ArrayList;
import java.util.List;

import business.MyMovie;
import interfaces.WebMediatorInterface;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import mediators.FileMediator;
import mediators.WebMediator;

public class MainViewController {

	private FileMediatorInterface fileMediator;
	private WebMediatorInterface webMediator;
	private ListView<MyMovie> moviesListView;
	private Button getMoviesButton;

	public MainViewController(FileMediatorInterface fileMediator, WebMediatorInterface webMediator) {
		this.fileMediator = fileMediator;
		this.webMediator = webMediator;
	}

	public MainViewController() {
		this.fileMediator = new FileMediator();
		this.webMediator = new WebMediator();
	}

	public void addMovieAsFavorite(MyMovie movie){
		fileMediator.storeMovieAsFavorite(movie);
	}

	public List<String> getFavoriteMovies(){
		return fileMediator.getFavoriteIds();
	}

	public void getBoxOfficeMovies() {
		ArrayList<MyMovie> boxOfficeMovies = webMediator.getBoxOfficeMovies(50);
		if (moviesListView != null){
			moviesListView.setItems(new ObservableListWrapper<MyMovie>(boxOfficeMovies));
		}
	}

	public ListView<MyMovie> getMoviesListView() {
		return moviesListView;
	}

	public void setMoviesListView(ListView<MyMovie> moviesListView) {
		this.moviesListView = moviesListView;
	}

	public Button getGetMoviesButton() {
		return getMoviesButton;
	}

	public void setGetMoviesButton(Button getMoviesButton) {
		getMoviesButton.setOnAction(x -> {
			getBoxOfficeMovies();
		});

		this.getMoviesButton = getMoviesButton;
	}
}
