// Cody Milne

package Main;

public class Movie {
    // Fields
    private String title;
    private String actor1;
    private String actor2;
    private String director;
    private int year;
    private int runtimeMinutes;

    // Constructor
    public Movie(String title, String actor1, String actor2, String director, int year, int runtimeMinutes) {
        this.title = title;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.director = director;
        this.year = year;
        this.runtimeMinutes = runtimeMinutes;
    }

    // Methods
    public String getTitle() {
        return title;
    }

    
    // Returns the actor 1 of the movie
    public String getActor1() {
        return actor1;
    }

    //Returns the actor 2 of the movie
    public String getActor2() {
        return actor2;
    }

    // Returns the movie director
    public String getDirector() {
        return director;
    }

    // Returns the movie release year
    public int getYear() {
        return year;
    }

   // Returns the movie runtime
     
    public int getRuntime() {
        return runtimeMinutes;
    }

    // Optional
    public boolean isActorInMovie(String actor) {
        return actor2.equalsIgnoreCase(actor) || actor1.equalsIgnoreCase(actor);
    }

    @Override
    public String toString() {
        return "Title: '" + title + '\'' +
                "Actor1: '" + actor1 + '\'' +
                "Actor2: '" + actor2 + '\'' +
                "Director: '" + director + '\'' +
                "Year: " + year +
                "Runtime Minutes: " + runtimeMinutes;
    }
}
