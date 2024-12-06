//Christian Wolff
import java.util.Scanner;

//class thats responsibility is to talk to user
public class FrontEnd {
    static FileUtil fileUtil = new FileUtil();
    public static GenLL<Tasks>[] taskList = new GenLL[5];
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Task Organizer!");
        System.out.println();
        list();
        printOptions();
        keyboard.close();
    }
    
    public static void list() {
    	for(int i = 0; i<5; i ++) {
    		taskList[i] = new GenLL<Tasks>();
    	}
    }
//prints out all the options users can choose
    public static void printOptions() {
        System.out.println("Enter 1 to add a Task");
        System.out.println("Enter 2 to remove a Task");
        System.out.println("Enter 3 to print tasks to Console");
        System.out.println("Enter 4 to read from a Task File");
        System.out.println("Enter 5 to write to a Task File");
        System.out.println("Enter 9 to quit");

        int input = keyboard.nextInt();
        keyboard.nextLine(); // Consume newline

        switch(input) {
            case 1:
                addTask();
                break;
            case 2:
                removeTask();
                break;
            case 3:
                printToConsole();
                break;
            case 4:
                readFromFile();
                break;
            case 5:
            	printToFile();
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
        }
        
    }
	private static void printToFile() {
		System.out.println("Enter output file name: ");
	    String fileOut = keyboard.nextLine();
	    FileUtil.printToFile(fileOut, taskList);
	    printOptions();
			
	}
	private static void readFromFile() {
			System.out.println("Please enter file name:");
			String fileIn = keyboard.nextLine();
			taskList = FileUtil.read(fileIn);
			printOptions();
	}
	private static void printToConsole() {
		for(int i = 0; i<5; i ++) {
			FileUtil.printToConsole(taskList[i]);
		}
		printOptions();
	}
	private static void removeTask() {
		System.out.println("Please enter the task to remove");
		String taskName = keyboard.nextLine();
		System.out.println("Please enter the priority of the task to remove (0-4)");
		int priority = keyboard.nextInt();
		while(!(0<= priority && priority <=4)) {
			System.out.println("Please enter a valid number (0-4) for the priority of the task");
			priority = keyboard.nextInt();
		}
		Tasks delete = new Tasks(priority, taskName);
		remove(delete, priority);
		printOptions();
		
	}
	private static void addTask() {
		System.out.println("Please enter the task");
		String taskName = keyboard.nextLine();
		System.out.println("Please enter the priority of the task (0-4)");
		int priority = keyboard.nextInt();
		while(!(0<= priority && priority <=4)) {
			System.out.println("Please enter a valid number (0-4) for the priority of the task");
			priority = keyboard.nextInt();
		}
		taskList[priority].add(new Tasks(priority, taskName));	
		printOptions();
	}

	public static void remove(Tasks data, int priority) {
		taskList[priority].reset();
		while(taskList[priority].hasMore()) {
			if(taskList[priority].getCurrent().equals(data)) {
				taskList[priority].removeCurrent();
			}else
				taskList[priority].gotoNext();
		}
	}

}