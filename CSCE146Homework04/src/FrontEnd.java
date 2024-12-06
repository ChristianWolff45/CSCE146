//Christian Wolff
import java.util.Scanner;

//class thats responsibility is to talk to user
public class FrontEnd {
    static FileUtil fileUtil = new FileUtil();
    public static LLQueue<String> robotActions = new LLQueue<String>();
    public static char[][] board = new char[10][10];
    public static int[] robotLocation = new int[]{0, 0};
    private static Scanner keyboard = new Scanner(System.in);
    public static boolean run = true;
    public static void main(String[] args) {
        System.out.println("Welcome to the Robot Simulator!");
        while(run){
        fillBoard();
        getCommand();
        runSimulation();
        }
        keyboard.close();
    }
    //creates board from file
    public static void fillBoard() {
        System.out.println("Enter File for the Board");
        String fileName = keyboard.next();
        board = fileUtil.readBoard(fileName);        
    }
    //gets robot actions from a file
    public static void getCommand() {
    	System.out.println("Enter File for robot command");
        String fileName = keyboard.next();
        robotActions = fileUtil.fillCommand(fileName);
    }
    
    public static void runSimulation() {
    	robotLocation = new int[]{0, 0};
    	board[0][0] = 'O';
    	FileUtil.printBoard(board);
    	int count = 0;
    	System.out.println("Simultaion Begin");
    	boolean crash = false;
    	while(robotActions.peek()!= null && !crash) {
    		String action = robotActions.Dequeue();	        
    		switch (action) {
    	    case "Move Up":
    	    	board[robotLocation[0]][robotLocation[1]] = '_';
    	    	robotLocation[0] -= 1;
    	    	if(isValid(robotLocation))
    	    		board[robotLocation[0]][robotLocation[1]] = 'O';
    	    	else
    	    		crash = true;
    	    	break;
    	    case "Move Down":
    	    	board[robotLocation[0]][robotLocation[1]] = '_';
    	    	robotLocation[0] += 1;
    	    	if(isValid(robotLocation))
    	    		board[robotLocation[0]][robotLocation[1]] = 'O';
    	    	else
    	    		crash = true;
    	    	break;
    	    case "Move Left":
    	    	board[robotLocation[0]][robotLocation[1]] = '_';
    	    	robotLocation[1] -= 1;
    	    	if(isValid(robotLocation))
    	    		board[robotLocation[0]][robotLocation[1]] = 'O';
    	    	else
    	    		crash = true;
    	    	break;
    	    case "Move Right":
    	    	board[robotLocation[0]][robotLocation[1]] = '_';
    	    	robotLocation[1] += 1;
    	    	if(isValid(robotLocation))
    	    		board[robotLocation[0]][robotLocation[1]] = 'O';
    	    	else
    	    		crash = true;
    	    	break;    	    
    		}
    		System.out.println("\nCommand: " + count + "\n");
    		if(crash == false) {
		        FileUtil.printBoard(board);
		        count += 1;
    		}
    	}
    	if(crash == true) {
			System.out.println("You crashed!");
		}
		System.out.println("Simulation complete");
		quitOption();
    }
    //asks the user if they want to quit
    public static void quitOption() {
		System.out.println("enter: 1 to quit");
		System.out.println("enter: 2 to run another simulation");
		int choice = keyboard.nextInt();
		if(choice == 1) {
			run = false;
		}
		else if(choice == 2) {
			run = true;
		}else {
			System.out.println("invalid input");
			quitOption();
		}
    }
    //determines if the robot can move to the spot ie not out of bounds and not an obstacle
    public static boolean isValid(int[] robotLoc) {
    	if( robotLoc[0] <0 || robotLoc[0] >9 || robotLoc[1] <0 || robotLoc[1] >9) {
    		return false;
    	}
    	else if(board[robotLoc[0]][robotLoc[1]]=='X') {
    		return false;
    	}
    	return true;
    }
}