//Written by <<Christian Wolff>>

import java.util.Scanner;

public class VectorMathProblems {
	public static void main(String[] args) {
		int array_size;
		int mathProblem;
		boolean run = true;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the Vector Operations Program!");
		
		do {
			
			do {
				//Run at least once to determine what the user wants to do
				System.out.println("Enter 1. To Add 2 Vectors");
				System.out.println("Enter 2. To Subtract 2 Vectors");
				System.out.println("Enter 3. To Find the Magnitude of a Vector");
				System.out.println("Enter 9. To Quit");	
				mathProblem = keyboard.nextInt();
				if(!(mathProblem == 1 ||mathProblem == 2 ||mathProblem == 3 ||mathProblem == 9)) {
					//if the user inputs an invalid number output error message and ask them what they would like to do again
					System.out.println("Please enter a valid number");
				}
			}while(!(mathProblem == 1 ||mathProblem == 2 ||mathProblem == 3 ||mathProblem == 9));
			
			if(mathProblem == 9) {
				//exit code if user inputs 9
				System.out.println("GoodBye");
				run = false;
				break;
			}
			
			do {
				System.out.println("Enter the size of vectors");
				array_size = keyboard.nextInt();
				if(array_size < 1) {
					//if user does not input a valid vector length ask again
					System.out.println("please enter a valid size of vectors (size of vectors greater than 0)");
				}
			}while(array_size < 1);
			
			double[] vector1 = new double[array_size];
			double[] vector2 = new double[array_size];
			
			if(mathProblem == 1) {
				vector1= newVector(vector1.length);
				vector2= newVector(vector1.length);
				add(vector1, vector2);
			}
			else if(mathProblem== 2) {
				vector1= newVector(vector1.length);
				vector2= newVector(vector1.length);
				subtract(vector1, vector2);
			}
			else if(mathProblem== 3) {
				vector1= newVector(vector1.length);
				magnitude(vector1);
			}
		//Runs the whole program until user enters 9 and it exits
		}while (run);		
		
	}
	//creates new vector according to user
	static double[] newVector(int arraySize) {
		Scanner keyboard = new Scanner(System.in);
		double [] vector = new double[arraySize];
		System.out.println("Please enter the values for the vector");
		for(int i = 0; i<arraySize; i++) {
			//creates an array of doubles entered by user
			vector[i] = keyboard.nextDouble();
		}
		return vector;
	}
	//prints out the vector
	static void printVector(double[] vector) {
		for(int i = 0; i<vector.length; i ++) {
			System.out.println(vector[i]);
		}
	}
	static void add(double[] vector1, double[] vector2) {
		printVector(vector1);
		System.out.println("+");
		printVector(vector2);
		System.out.println("=");
		for(int i = 0; i<vector1.length; i ++) {
			//adds to doubles and outputs result
			System.out.println(vector1[i]+vector2[i]);
		}
		
	}
	static void subtract(double[] vector1, double[] vector2) {
		printVector(vector1);
		System.out.println("-");
		printVector(vector2);
		System.out.println("=");
		for(int i = 0; i<vector1.length; i ++) {
			//outputs the difference of two vectors
			System.out.println(vector1[i]-vector2[i]);
		}
		
	}
	static void magnitude(double[] vector1) {
		int summation = 0;
		for(int i =0; i<vector1.length;i++ ) {
			summation += Math.pow(vector1[i],2);
		}
		//outputs the magnitude
		System.out.println("The magnitude of the vector is:");
		System.out.println(Math.sqrt(summation));
	}	
	
}
