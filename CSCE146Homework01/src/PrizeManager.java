//written by Christian Wolff
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
//handles creation of variables and storing their data from the file
public class PrizeManager {
	private String[] prizes;
	private int[] values;
	private int fileLength;
  	public PrizeManager(String fileName) {
		fileLength = FileUtils.fileLength(fileName);
		prizes = new String[fileLength];
		values = new int[fileLength];
		FileUtils.readFile(fileName, prizes, values);
	}
//getter: gets file length
	public int getFileLength() {
		return fileLength;
	}
//getter: gets the price of the five randomly selected prizes
	public int getPriceOfPrizes(int[] index) {
		int price = 0;
		for(int i = 0; i < index.length; i ++) {
			price += values[index[i]];
		}
		return price;
	}
//getter: gets the name of any prize[i]
	public String getPrizeName(int i) {
		return prizes[i];
	}
//Constructor: initializes the random prizes to be selected
	public int[] randomPrizes() {
		int[] indexOfPrizes = new int[5];
		int random;
		boolean duplicate = false;
			for(int i = 0; i < 5; i ++) {
				random = (int)(Math.random() * fileLength);
				for(int j = 0; j<i; j ++) {
					if(random == indexOfPrizes[j]) {
						duplicate = true;
					}
				}
				if(!duplicate) {
					indexOfPrizes[i] = random;
				}else {
					duplicate = false;
					i --;
				}
			}
		return indexOfPrizes;
	}

}
