//Christian Wolff
import java.util.Scanner;

//class thats responsibility is to talk to user
public class FrontEnd {
	static userFunction userFunction = new userFunction();
    static FileUtil fileUtil = new FileUtil();
    static GenLL<VideoGame> genLL = new GenLL<VideoGame>();
    private static GenLL<VideoGame> gameList;
    private static GenLL<VideoGame> results;
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Video Game Database!");
        System.out.println();
        printOptions();
        keyboard.close();
    }
//prints out all the options users can choose
    public static void printOptions() {
        System.out.println("Enter 1 to load the video game database");
        System.out.println("Enter 2 to search the database");
        System.out.println("Enter 3 to print current results to file");
        System.out.println("Enter 4 to print current results to Console");
        System.out.println("Enter 9 to quit");

        int input = keyboard.nextInt();
        keyboard.nextLine(); // Consume newline

        switch(input) {
            case 1:
                loadDatabase();
                break;
            case 2:
                searchDatabase();
                break;
            case 3:
                printToFile();
                break;
            case 4:
                printToConsole();
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
        }
    }
//prints current results to the console
    private static void printToConsole() {
        FileUtil.printToConsole(results);
        printOptions();
    }
//request output file name and prints current results to it
    private static void printToFile() {
        System.out.println("Enter output file name: ");
        String fileOut = keyboard.nextLine();
        FileUtil.printToFile(fileOut, results);
        printOptions();
    }
//searches database given a game name and console name "*" can be used to return all
    private static void searchDatabase() {
    	System.out.println("Enter Game Name: ");
        String game = keyboard.nextLine();
    	System.out.println("Enter Console Name: ");
        String console = keyboard.nextLine();
		GenLL<VideoGame> tempResults =userFunction.search(game, console, gameList); 
		if(results != null)
			appendOptions(tempResults);
		else
			results = tempResults;
        printOptions();
    }
    //asks whether or not the user wants to append search results to previous search results
    //combines or replaces search results depending on users desire
    private static void appendOptions(GenLL<VideoGame> tempResults) {
    	System.out.println("1: append results");
    	System.out.println("2: clear previous results and create new list");
		int resultChoice = keyboard.nextInt();
		if(resultChoice == 1) {
			results.combine(tempResults);
		}else if(resultChoice == 2) {
			results = tempResults;
		}else {
			System.out.println("please enter valid number");
			appendOptions(tempResults);
		}
    }
//asks user to input file in order to load database
    private static void loadDatabase() {
        System.out.println("Please enter file name:");
        String fileIn = keyboard.nextLine();
        gameList = FileUtil.read(fileIn);
        printOptions();
    }
}