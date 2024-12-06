//Written by Christian Wolff
import java.io.File;
import java.io.IOException;
import java.util.*;
//handles actually reading the file
public class FileUtils {
	//finds length of file in order to set length of arrays
	public static int fileLength(String fileName) {
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			int counter = 0;
			while(fileScanner.hasNextLine()) {
				String fileLine =fileScanner.nextLine();
				String[] splitLine = fileLine.split("\t");
				//if line is not formatted properly ignore it
				if(splitLine.length ==2) {
					counter++;
				}
			}
			return counter;
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
	}
	public static void readFile(String fileName, String[] prizes, int[] values) {
		// TODO Auto-generated method stub
		try {
			
			Scanner fileScanner = new Scanner(new File(fileName));
			int i = 0;
			while(fileScanner.hasNextLine()) {
				//read file line by line
				String fileLine =fileScanner.nextLine();
				//set string array to the line split by "\t"
				String[] splitLine = fileLine.split("\t");
				//if properly formatted set prizes to first part of line and values to the integer of the second part of the line
				if(splitLine.length == 2) {
					prizes[i] = splitLine[0];
					values[i] = Integer.parseInt(splitLine[1]);
					i++;
				}
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
