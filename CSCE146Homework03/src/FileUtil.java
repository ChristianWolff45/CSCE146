//Christian Wolff
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class FileUtil {
	public final static int FIELD_AMT = 2;
	public final static String DELIM = ("\t");
	public static GenLL<Tasks>[] read(String fileName) {
		GenLL<Tasks>[] taskList = new GenLL[5];
		for(int i = 0; i<5; i ++) {
    		taskList[i] = new GenLL<Tasks>();
    	}
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
				int priority = Integer.parseInt(splitLines[0]);
				String task = splitLines[1];
				taskList[priority].add(new Tasks(priority, task));	
			}
			fileScanner.close();//Closes the file Scanner
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return taskList;
	}
	//prints given array of linked lists to a file
	public static void printToFile(String fileName, GenLL<Tasks>[] taskList) {
		try {
			PrintWriter pw = new PrintWriter(fileName);
			for(int i = 0; i <5; i++) {
				taskList[i].reset();
				while(taskList[i].hasMore()) {
					Tasks current = taskList[i].getCurrent();
					pw.println(current.toString());
					taskList[i].gotoNext();
				}
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//prints given array of linked list to the console
	public static void printToConsole(GenLL<Tasks> taskList) {
		taskList.reset();
		Tasks current = taskList.getCurrent();
		while(taskList.hasMore()) {
			System.out.println(current.toString());
			taskList.gotoNext();
			current = taskList.getCurrent();
		}
	}
	
}
