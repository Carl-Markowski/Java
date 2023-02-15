package bin;

import java.util.Scanner;

public class MarkowskiCarlAssignment5 {
	/*
	 * Name: Carl Markowski
	 * Class: CS1150
	 * Section:1
	 * Due Date: October 4th, 2021
	 * Description: Assignment 5
	 * This program will show my ability to utilize while loops.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 
		// Start of user input for grades
		
		double Grade = 0;
		double grade = 0;
		double average = 0;
		double highest =0;
		double lowest = 0;
		int numexams = 0;
		double A = 0;
		double B = 0;
		double C = 0;
		double D = 0;
		double F = 0; 
		
		//Setup of while loop and user input
		System.out.println("Please enter your grades or enter -1 to stop");
		System.out.println("Enter a Grade:");
		Scanner input= new Scanner(System.in);
		Grade= input.nextDouble();
		double Average= average + Grade;
		
		while (Grade != -1){
			average= average + Grade;
			System.out.println("Enter a Grade:");
			numexams++;
			if (Grade > 90 && Grade <= 100.0) {
				A++;
			}
			else if (Grade > 80 && Grade < 90) {
				B++;
			}
			else if (Grade > 70 && Grade < 80) {
				C++;
			}
			else if (Grade >= 65 && Grade < 70) {
				D++;
			}
			else if (Grade < 65) {
				F++;
			}
			
			if (Grade > highest) {
				highest = Grade;
			}
			
			if (numexams == 1) {
				lowest = Grade;
			}
			
			if (Grade < lowest) {
				lowest = Grade;
			}
			Grade= input.nextDouble();
		}
		if (numexams >= 1) {
		
		//Code for Exam details
		System.out.println("\nThe number of exams entered= " + numexams);
		System.out.println("The average of the exams=" + (average / numexams));
		System.out.println("The highest exam= " + highest);
		System.out.println("The lowest exam= " + lowest);
		
		//Display of grade counters
		System.out.printf("\nNumber of A's = %2.2f", A);
		System.out.printf("\nNumber of B's = %2.2f", B);
		System.out.printf("\nNumber of C's = %2.2f", C);
		System.out.printf("\nNumber of D's = %2.2f", D);
		System.out.printf("\nNumber of F's = %2.2f", F);
		
		
		//Display of percentages
		System.out.printf("\n\nPercentage of A's = %2.2f", (A / numexams) * 100);
		System.out.printf("\nPercentage of B's = %2.2f", (B / numexams) * 100);
		System.out.printf("\nPercentage of C's = %2.2f", (C / numexams) * 100);
		System.out.printf("\nPercentage of D's = %2.2f", (D / numexams) * 100);
		System.out.printf("\nPercentage of F's = %2.2f", (F / numexams) * 100);
		}
		
		if(numexams == 0) {
			System.out.println("No grades were entered");
		}
	}

}
