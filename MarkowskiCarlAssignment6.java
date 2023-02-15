package bin;

import java.util.Scanner;

public class MarkowskiCarlAssignment6 {
	
	// Constant and variable declaration 
	public static int sales;
	public static int potatoChipsSold;
	public static int snickersSold;
	public static int kindBarsSold;
	public static double totalsales;

	public static final double CHIPS = 1.25;
	public static final double SNICKERS = .80;
	public static final double KIND = .70;
	/*
	 * Name: Carl Markowski 
	 * Class: CS1150 
	 * Section: 1 
	 * Due Date: October 11, 2021
	 * Description: Assignment 6 
	 * This program will display my ability to use the
	 * different types of loops. As well as show my ability to use while loops and
	 * if statements together.
	 */

	public static void main(String[] args) {

		// Vending machine display format and setup
		int select = 0;
		while (select != 999) {
			System.out.println("******************************");
			System.out.println("\tSnack Machine");
			System.out.println("******************************");

			System.out.printf("\nPotato Chips   Potato Chips   Potato Chips");
			System.out.printf("\nA1  $%1.2f", CHIPS);
			System.out.printf("\tA2  $%1.2f", CHIPS);
			System.out.printf("\tA3  $%1.2f", CHIPS);
			System.out.println("\n---------------------------------------------");
			System.out.printf("\nSnickers   \tSnickers   \tSnickers");
			System.out.printf("\nB1  $%1.2f", SNICKERS);
			System.out.printf("\tB2  $%1.2f", SNICKERS);
			System.out.printf("\tB3  $%1.2f", SNICKERS);
			System.out.println("\n---------------------------------------------");
			System.out.printf("\nKind Bar   \tKind Bar   \tKind Bar");
			System.out.printf("\nC1  $%1.2f", KIND);
			System.out.printf("\tC2  $%1.2f", KIND);
			System.out.printf("\tC3  $%1.2f", KIND);
			System.out.println("\n---------------------------------------------");

			// User input and scanner setup
			System.out.println("\nHow many snacks would you like? Limit is 3.");
			Scanner input = new Scanner(System.in);
			select = input.nextInt();

			//Input validation for the number of snacks entered
			if (select >= 4 && select != 999) {
				System.out.println("Invaild Entry. Enter a number between 1 and 3:");
			}
			
			else if (select <= 3 && select > 0) {
				for (int i = 0; i < select; i++) {
					System.out.println("Enter snack selection:");
					String snack = input.next();
					char Snack = snack.charAt(0);
					int num = input.nextInt();
					
					//Invaild entry for the number selection
					if (num >= 4) {
						System.out.println("Invaild Entry. Enter A1-A3, B1-B3, C1-C3:");
					}

					if (Snack == 'A' && num == 1) {
						System.out.println("----------------------");
						System.out.println("----------A1---------");
						System.out.println("----------------------");
						System.out.println("Snack Item: Potato Chips");
						System.out.println("Snack Price: $1.25");
						System.out.println("----------------------");
						System.out.println("Thank you for you business!");
						sales++;
						potatoChipsSold++;
						totalsales += CHIPS;
					}
					if (Snack == 'A' && num == 2) {
						System.out.println("----------------------");
						System.out.println("----------A2---------");
						System.out.println("----------------------");
						System.out.println("Snack Item: Potato Chips");
						System.out.println("Snack Price: $1.25");
						System.out.println("----------------------");
						System.out.println("Thank you for you business!");
						sales++;
						potatoChipsSold++;
						totalsales += CHIPS;
					}
					if (Snack == 'A' && num == 3) {
						System.out.println("----------------------");
						System.out.println("----------A3---------");
						System.out.println("----------------------");
						System.out.println("Snack Item: Potato Chips");
						System.out.println("Snack Price: $1.25");
						System.out.println("----------------------");
						System.out.println("Thank you for you business!");
						sales++;
						potatoChipsSold++;
						totalsales += CHIPS;
					}
					if (Snack == 'B' && num == 1) {
						System.out.println("----------------------");
						System.out.println("----------B1---------");
						System.out.println("----------------------");
						System.out.println("Snack Item: Snickers");
						System.out.println("Snack Price: $.80");
						System.out.println("----------------------");
						System.out.println("Thank you for you business!");
						sales++;
						snickersSold++;
						totalsales += SNICKERS;
					}
					if (Snack == 'B' && num == 2) {
						System.out.println("----------------------");
						System.out.println("----------B2---------");
						System.out.println("----------------------");
						System.out.println("Snack Item: Snickers");
						System.out.println("Snack Price: $.80");
						System.out.println("----------------------");
						System.out.println("Thank you for you business!");
						sales += 1;
						snickersSold++;
						totalsales += SNICKERS;
					}
					if (Snack == 'B' && num == 3) {
						System.out.println("----------------------");
						System.out.println("----------B3---------");
						System.out.println("----------------------");
						System.out.println("Snack Item: Snickers");
						System.out.println("Snack Price: $.80");
						System.out.println("----------------------");
						System.out.println("Thank you for you business!");
						sales++;
						snickersSold++;
						totalsales += SNICKERS;
					}
					if (Snack == 'C' && num == 1) {
						System.out.println("----------------------");
						System.out.println("----------C1---------");
						System.out.println("----------------------");
						System.out.println("Snack Item: Kind Bar");
						System.out.println("Snack Price: $.70");
						System.out.println("----------------------");
						System.out.println("Thank you for you business!");
						sales++;
						kindBarsSold++;
						totalsales += KIND;
					}
					if (Snack == 'C' && num == 2) {
						System.out.println("----------------------");
						System.out.println("----------C2---------");
						System.out.println("----------------------");
						System.out.println("Snack Item: Kind Bar");
						System.out.println("Snack Price: $.70");
						System.out.println("----------------------");
						System.out.println("Thank you for you business!");
						sales++;
						kindBarsSold++;
						totalsales += KIND;
					}
					if (Snack == 'C' && num == 3) {
						System.out.println("----------------------");
						System.out.println("----------C3---------");
						System.out.println("----------------------");
						System.out.println("Snack Item: Kind Bar");
						System.out.println("Snack Price: $.70");
						System.out.println("----------------------");
						System.out.println("Thank you for you business!");
						sales++;
						kindBarsSold++;
						totalsales += KIND;
					}
				}
			}
		}
		
		// Print statements for the information outputted when "999" is entered
		System.out.println("Total amount of sales: $" + totalsales);
		System.out.println("Total number of snacks sold:" + sales);
		System.out.println(potatoChipsSold + " Potato Chips");
		System.out.println(snickersSold + " Snickers");
		System.out.println(kindBarsSold + " Kind Bar");

	}
}
