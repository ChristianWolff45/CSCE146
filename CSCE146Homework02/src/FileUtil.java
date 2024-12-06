//Christian Wolff
import java.util.*;
import java.io.*;
public class FileUtil {
	public final static int FIELD_AMT = 2;
	public final static String DELIM = ("\t");
	public static GenLL<VideoGame> gList = new GenLL<VideoGame>();
	public static GenLL<VideoGame> read(String fileName) {
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
				//Otherwise create a new Grocery Item from the data in split line
				String game = splitLines[0];
				String console = splitLines[1];//Converts the String value to a double value
				VideoGame g = new VideoGame(game,console);
				//Adds the new item to the end of the list
				gList.add(g);
			}
			fileScanner.close();//Closes the file Scanner
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return gList;
	}
	//prints given linked to a file
	public static void printToFile(String fileName, GenLL<VideoGame> gameList) {
		try {
			if(gameList != null) {
				PrintWriter pw = new PrintWriter(fileName);
				gameList.reset();
				VideoGame current = gameList.getCurrent();
				pw.println(current.toString());
				while(!gameList.isEnd()) {
					current = gameList.getCurrent();
					pw.println(current.toString());
					gameList.goNext();
				}
			pw.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//prints given linked list to the console
	public static void printToConsole(GenLL<VideoGame> gameList) {
		if(gameList != null) {
			gameList.reset();
			VideoGame current = gameList.getCurrent();
			System.out.println(current.toString());
			while(!gameList.isEnd()) {
				gameList.goNext();
				current = gameList.getCurrent();
			System.out.println(current.toString());
			}
		}
	}
}
