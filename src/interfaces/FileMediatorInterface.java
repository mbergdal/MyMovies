package interfaces;

import java.util.List;

import business.MyMovie;

public interface FileMediatorInterface {
	void storeMovieAsFavorite(MyMovie movie);
	List<String> getFavoriteIds();
}
