//Christian Wolff
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class FileUtil {
	public final static int FIELD_AMT = 2;
	public final static String DELIM = ("\t");
	public char[][] readBoard(String fileName) {
		char[][] board = new char[10][10];
		try
		{
			//Creates the scanner to read the file
			Scanner fileScanner = new Scanner(new File(fileName));
			//While there is a next line
			for(int i = 0; i < board.length; i++) {
				String fileLine = fileScanner.nextLine();
				for(int j = 0; j< board.length; j++) {
					board[i][j] = fileLine.charAt(j);
				}
			}
			fileScanner.close();//Closes the file Scanner
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return board;
	}
	//prints out current board
	public static void printBoard(char[][] board) {
		for(int i = 0; i < board.length; i ++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	public LLQueue<String> fillCommand(String fileName) {
		LLQueue<String> robotActions = new LLQueue<String>();
		try
		{
			//Creates the scanner to read the file
			Scanner fileScanner = new Scanner(new File(fileName));
			//While there is a next line
			while(fileScanner.hasNextLine()) {
				robotActions.Enqueue(fileScanner.nextLine());
			}
			fileScanner.close();//Closes the file Scanner
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return robotActions;
	}
}
