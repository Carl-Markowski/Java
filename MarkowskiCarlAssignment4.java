package bin;

import java.util.Random;
import java.util.Scanner;

public class MarkowskiCarlAssignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * Name: Carl Markowski
 * Class: CS1150
 * Section: 1
 * Due: Sep 27, 2021
 * Description: Assignment 4
 * This assignment will demonstrate my understanding of the math.Random function as well at the char function
 * by using a powerball lottery ticket game.
 */
		//Beginning of Lottery ticket format
		System.out.println("CS1150 Powerball Lottery Game");
		System.out.println("----------------------------------------");
		System.out.println("Enter 2 letters and 1 Powerball Number");
		System.out.println("Match: All to win jackpot");
		System.out.println("Match: One letter to win $20.00");
		System.out.println("Match: Powerball to win $4.00");
		System.out.println("----------------------------------------");
		
		//Beginning of user input code for letter and numbers
		System.out.println("Enter 2 letters between A and Z:");
		Scanner input= new Scanner(System.in);
		String let= input.next();
		char userticket= let.charAt(0);
		char Userticket= let.charAt(1);
			
		//User input vailidation
		if (userticket >= 'a' && userticket <='z'){
			
			if (Userticket >= 'a' && Userticket <='z' && let.length() == 2) {
				System.out.println("Enter 1 number between 1 and 26:");
			}
			else {
				System.out.println("Invalid Entry- Need 2 letters between A and Z for this Special Powerball");
			}
		}
		else {
			System.out.println("Invalid Entry- Need 2 letters between A and Z for this Special Powerball");
		}
		
		//Beginning of the number validation and random ticket generator
		int usernum= input.nextInt();
		if (usernum >=1 && usernum <=26) {
			System.out.println("Customer Ticket");
			System.out.printf(let.toUpperCase());
			System.out.print(usernum);
			
			//Start of random ticket generator
			System.out.println("\nPowerball Ticket");
			Random r= new Random();
			char random= (char)(r.nextInt(26) + 'A');
			char Random= (char)(r.nextInt(26) + 'A');
			int rannum= (int)(Math.random() * 26);
			System.out.print(random);
			System.out.print(Random);
			System.out.print(rannum);
			
				if (random == userticket) {
					System.out.println("\n\nYou've won $20.00");
				}
				else if (random== Userticket) {
					System.out.println("\n\nYou've won $20.00");
				}
				else if (Random == userticket) {
					System.out.println("\n\nYou've won $20.00");
				}
				else if (Random == Userticket) {
					System.out.println("\n\nYou've won $20.00");
				}
				else if (usernum == rannum) {
					System.out.println("\n\nYou've won $4.00");
				}
				else if (random != userticket && random != Userticket && usernum != rannum) {
					System.out.println("\n\nYour Powerball choices did not win");
				}
				else if (Random != userticket && Random != Userticket && usernum != rannum) {
					System.out.println("\n\nYour Powerball choices did not win");
				}
				else if (random == userticket && Random == Userticket && rannum == usernum) {
					System.out.println("POWERBALL");
				}
				else if (random == Userticket && Random == userticket && rannum == usernum) {
					System.out.println("POWERBALL");
				}
		}			
		else {
			System.out.println("Invalid Entry- Need to input 1 number between 1 and 26");
		}
		
	}

}
