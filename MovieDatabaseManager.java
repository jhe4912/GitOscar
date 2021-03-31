// Cody Milne

package Main;

 // This class that allows user to interact with the movie database by querying it as well as manipulating its records
 
public class MovieDatabaseManager {
    private static KeyboardInput keyboardInput = new KeyboardInput();
    private static Database database = new Database("db.txt");

    
    public static void main(String[] args) {
        System.out.println("*********************************************");
        System.out.println(" Welcome to Movie Database Management System ");
        System.out.println("*********************************************\n");
        String command;
        do {
            //prompt user to enter a command
            printMenu();
            System.out.print("Enter command > ");
            command = keyboardInput.getKeyboardLine();
            //ensure command is in lower case
            command = command.toLowerCase();
            switch (command) {
                case "a":
                    newEntry();
                    break;
                case "b":
                    searchByActor();
                    break;
                case "c":
                    searchYear();
                    break;
                case "d":
                    searchByRuntime();
                    break;
                case "e":
                    searchByDirector();
                    break;
                case "f":
                    searchByTitle();
                    break;
                case "g":
                    deleteEntry();
                    break;
                case "h":
                    System.out.println("Thank you for using the application. Bye!");
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
            System.out.println();
        } while (!command.equalsIgnoreCase("h"));
        keyboardInput.closeKeyboard();
    }

    // This method prints the menu of commands
    private static void printMenu() {
        System.out.println("a.) new entry\n" +
                "b.) search by actor\n" +
                "c.) search by year\n" +
                "d.) search by runtime (in minutes)\n" +
                "e.) search by director\n" +
                "f.) search by title\n" +
                "g.) delete entry\n" +
                "h.) quit");
    }

    // This method prompts user to enter movie info and creates a new movie entry
    private static void newEntry() {
        try {
            System.out.print("Enter title > ");
            String title = keyboardInput.getKeyboardLine();
            System.out.print("Enter year > ");
            int year = Integer.parseInt(keyboardInput.getKeyboardLine());
            System.out.print("Enter runtime (minutes) > ");
            int runtimeMinutes = Integer.parseInt(keyboardInput.getKeyboardLine());
            System.out.print("Enter actor 1 > ");
            String actor1 = keyboardInput.getKeyboardLine();
            System.out.print("Enter actor 2 > ");
            String actor2 = keyboardInput.getKeyboardLine();
            System.out.print("Enter Director > ");
            String director = keyboardInput.getKeyboardLine();
            System.out.println();
            //minimum length of valid title is three characters
            if (title.length() < 3) {
                System.out.println("Invalid movie entry. Title must be at least 3 character");
            } else {
                Movie newMovie = new Movie(title, actor1, actor2, director, year, runtimeMinutes);
                database.addEntry(newMovie);
                System.out.println("Movie entry created");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid movie entry");
        }
    }

    // This method prompts user to enter an actor name and searches for the movies that been acted by the actor
     
    private static void searchByActor() {
        System.out.print("Enter actor > ");
        String actor = keyboardInput.getKeyboardLine();
        database.searchByActor(actor);
    }

    // This method prompts user to enter a year and searches for the movies release that year
     
    private static void searchYear() {
        System.out.print("Enter year > ");
        int year = Integer.parseInt(keyboardInput.getKeyboardLine());
        database.searchByYear(year);
    }

    // This method prompts user to enter runtime in minutes and searches for the movies with the runtime
    private static void searchByRuntime() {
        System.out.print("Enter runtime (minutes) > ");
        int runtime = Integer.parseInt(keyboardInput.getKeyboardLine());
        database.searchByRuntime(runtime);
    }

   // This method prompts user to a movie director and searches for the movies with the director
    private static void searchByDirector() {
        System.out.print("Enter director > ");
        String director = keyboardInput.getKeyboardLine();
        database.searchByDirector(director);
    }

    //This method prompts user to enter a movie title and searches for the movie with the title
    private static void searchByTitle() {
        System.out.print("Enter title > ");
        String title = keyboardInput.getKeyboardLine();
        database.searchByTitle(title);
    }

    // This method prompts user to enter a movie title and searches for the movie with the title
    private static void deleteEntry() {
        System.out.print("Enter title to delete >");
        String title = keyboardInput.getKeyboardLine();
        database.deleteEntry(title);
    }

}
