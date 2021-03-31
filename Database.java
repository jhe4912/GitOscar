// Cody Milne

package Main;

import java.util.ArrayList;
import java.util.StringTokenizer;

//h This class stores the movie records on the memory as well as allow manipulation of movie record stored on the database file

public class Database {
	// Fields
	private ArrayList<Movie> movies;
	private FileWrite fileWrite;
	
	// Constructor
	public Database(String filename){
		movies = new ArrayList<>();
		FileRead fr = new FileRead(filename);
		fileWrite = new FileWrite(filename);
		for(int i = 0; i < fr.getNumberOfLines(); i++){
			String raw = fr.getLine(i);
			// Parse raw using the StringTokenizer here and place into movies as single entries
			StringTokenizer st = new StringTokenizer(raw,"*");
			//The Shawshank Redemption*1994*142*Tim Robbins*Morgan Freeman*Frank Darabont
			String title = st.nextToken();
			int year = Integer.parseInt(st.nextToken());
			int runtimeMinutes = Integer.parseInt(st.nextToken());
			String actor1 = st.nextToken();
			String actor2 = st.nextToken();
			String director = st.nextToken();
			//create new movie
			Movie newMovie = new Movie(title, actor1, actor2, director, year, runtimeMinutes);
			this.movies.add(newMovie);
		}
	}
	
	// Methods
	public void addEntry(Movie newEntry){
		//
		this.movies.add(newEntry);
		fileWrite.writeLine(newEntry.getTitle() + "*" + newEntry.getYear() + "*" + newEntry.getRuntime() + "*" + newEntry.getActor1() + "*" + newEntry.getActor2() + "*" + newEntry.getDirector());
		fileWrite.saveFile();
	}

	public void deleteEntry(String title) {
		int indexToDelete = -1;
		//find the movie with the title
		for (int index = 0; index < movies.size(); index++) {
			Movie movie = movies.get(index);
			if (movie.getTitle().equalsIgnoreCase(title)) {
				indexToDelete = index;
			}
		}
		//not found
		if (indexToDelete == -1) {
			System.out.println("Title not found");
		} else {
			//delete
			movies.remove(indexToDelete);
			for (Movie current: movies) {
				fileWrite.writeLine(current.getTitle() + "*" + current.getYear() + "*" + current.getRuntime() + "*" + current.getActor1() + "*" + current.getActor2() + "*" + current.getDirector());
			}
			fileWrite.delete();
			System.out.println(title + " has been deleted successfully");
		}
	}

	//This method searches and prints the movie with the title passed
	public void searchByTitle(String title){
		for (Movie movie: movies) {
			if (movie.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Actors: " + movie.getActor1() + "," + movie.getActor2() + "\n" +
						"Director: " + movie.getDirector() +"\n" +
						"Year: " + movie.getYear() + "\n" +
						"Runtime: " + movie.getRuntime() + " minutes");
			}
		}
	}

	//this method searches and prints the the movies acted by the actor passed
	public void searchByActor(String actor){
		boolean found = false;
		for (Movie movie: movies) {
			if (movie.getActor1().equalsIgnoreCase(actor) || movie.getActor2().equalsIgnoreCase(actor)) {
				System.out.println(movie.getTitle());
				found = true;
			}
		}
		//if not found
		if (!found) {
			System.out.println("No titles found for actor");
		}
	}

	//This method searches and prints the movies directed by the director passed

	public void searchByDirector(String director){
		boolean found = false;
		for (Movie movie: movies) {
			if (movie.getDirector().equalsIgnoreCase(director)) {
				System.out.println(movie.getTitle());
				found = true;
			}
		}
		//if not found
		if (!found) {
			System.out.println("No titles found produced by the director");
		}
	}
	
	public void searchByYear(int year){
		boolean found = false;
		for (Movie movie: movies) {
			if (movie.getYear() == year) {
				System.out.println(movie.getTitle());
				found = true;
			}
		}
		//if not found
		if (!found) {
			System.out.println("No titles found for year");
		}
	}
	
	public void searchByRuntime(int runtime){
		boolean found = false;
		for (Movie movie: movies) {
			if (movie.getRuntime() == runtime) {
				System.out.println(movie.getTitle());
				found = true;
			}
		}
		//if not found
		if (!found) {
			System.out.println("No titles found with such a runtime");
		}
	}
}
