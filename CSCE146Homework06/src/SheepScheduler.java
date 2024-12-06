import java.io.File;
import java.util.Scanner;

//written by Christian Wolff
public class SheepScheduler {
	public static minHeap<Sheep> schedule = new minHeap<Sheep>();
	public static GenLL<Sheep> sheep = new GenLL<Sheep>();
	public static int earliestArrival = 0;
	public static int currentTime = 0;
	public final static int FIELD_AMT = 3;
	public final static String DELIM = ("\t");
	private static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		System.out.println("Please enter a file to read");
		read(keyboard.next());
		scheduler();
		
	}
	private static void scheduler() {
		while(sheep.hasMore()) {
			addToSchedule();
			Sheep next = schedule.remove();//removes the sheep from the min heap with the shortest shear time
			System.out.println(next);
			currentTime += next.getSheerTime();//add the time to get sheared to currentTime
		}
		Sheep next = schedule.remove();
		while(next != null) {
			System.out.println(next);
			next = schedule.remove();
		}
	}
//adds sheep to a min heap
	private static void addToSchedule() {
		boolean added = false;
		sheep.reset();
		while(sheep.hasMore()) {
			Sheep current = sheep.getCurrent();
			if(current.getArrivalTime() <= currentTime) {//if the arrival time of the sheep is before the end of the sheering of the current sheep add it to the min heap
				schedule.add(current);
				sheep.removeCurrent();//remove current sheep to prevent adding the same sheep multiple times
				added = true;
			}else
				sheep.gotoNext();
		}
		if(added = false) {
			currentTime += 1;
			addToSchedule();
		}
		sheep.reset();
		
	}
//creates a linked list of sheep from a file
	public static void read(String fileName) {
		try
		{
			//Creates the scanner to read the file
			Scanner fileScanner = new Scanner(new File(fileName));
			//While there is a next line
			while(fileScanner.hasNextLine())
			{
				//Read the next line in the file
				String fileLine = fileScanner.nextLine();
				//Split said line based on the tab delimiter
				String[] splitLines = fileLine.split(DELIM);
				//Check if it is the correct size
				if(splitLines.length != FIELD_AMT)
					continue;//If not then skip it
				String name = splitLines[0];
				int shearTime = Integer.parseInt(splitLines[1]);
				int arrivalTime = Integer.parseInt(splitLines[2]);
				Sheep temp = new Sheep(name, shearTime, arrivalTime);
				sheep.add(temp);
			}
			fileScanner.close();//Closes the file Scanner
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
