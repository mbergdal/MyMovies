package business;

public class Movie {
	
	private it.jtomato.gson.Movie movie;
	
	public Movie(it.jtomato.gson.Movie movie) {
		this.movie = movie;		
	}
	
	public String getTitle(){
		return this.movie.title;
	}
	
	public String getId(){
		return this.movie.id;
	}	
}
