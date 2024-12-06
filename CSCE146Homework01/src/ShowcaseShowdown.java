//written by Christian Wolff
import java.util.Scanner;
//Handles all frontend inputs and game logic 
public class ShowcaseShowdown {
	public static final String FILE_NAME = "./prizeList.txt"; 
    public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		//creates new prize manager from file FILE_NAME
		PrizeManager prizeManager = new PrizeManager(FILE_NAME);
		boolean run = true;
		System.out.println("Welcome to showcase showdown");
		while(run) {
			int[] indexOfPrizes = prizeManager.randomPrizes();
			int priceOfPrizes = prizeManager.getPriceOfPrizes(indexOfPrizes);
			System.out.println("Your Prizes include: ");
			for (int i = 0; i < 5; i++) {
				System.out.println(prizeManager.getPrizeName(indexOfPrizes[i]));
	        }
	        System.out.println("Guess the price of the prizes within $1300, and without going over.");
	        int guess = keyboard.nextInt();		
	        if (guess > priceOfPrizes) {
                System.out.println("Your guess was over.");
                System.out.println("You Lose.");
            } else if (guess < priceOfPrizes - 1300) {
                System.out.println("Your guess was too far under.");
                System.out.println("You Lose.");
            } else {
                System.out.println("You Win!!!");
            }

            System.out.println("You guessed " + guess + " and the actual cost was " + priceOfPrizes);
            System.out.println("Would you like to play again?");
            System.out.println("1: Yes");
            System.out.println("2: No");
            if (keyboard.nextInt() == 2) {
                run = false;
            }    
		}
	}
}
