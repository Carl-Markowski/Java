package bin;

import java.util.Scanner;

public class MarkowskiCarlAssignment7 {
	/*
	 * Name:Carl Markowski 
	 * Class: CS1150 
	 * Section:1 
	 * Due Date: October 25, 2021
	 * Description: Assignment 7 
	 * This program will show my knowledge of using
	 * different methods
	 */

	// Declaring public constants and variables
	public static final String PREVIOUS1 = "mydogblue1";
	public static final String PREVIOUS2 = "yetimonster1";
	public static int length;
	public static char numAndDig;
	public static int attempts = 3;
	public static boolean allTests = false;

	public static void main(String[] args) {
		int i = 0;
			do {
				i++;
				// Asking user for password
				System.out.println("Enter a Password:");
				Scanner input = new Scanner(System.in);
				String password;
				password = input.next();
				int length = password.length();

				if (!lengthTest(password)) {
					printErrorMessage(1);
				} else if (!onlyLettersAndDigitsTest(password)) {
					printErrorMessage(2);
				} else if (!containsOneDigitTest(password)) {
					printErrorMessage(3);
				} else if (!differentThanLastTwoPasswordsTest(PREVIOUS1, PREVIOUS2, password)) {
					printErrorMessage(4);
				} else {
					allTests = true;
					System.out.println("You've changed your password successfully");
					
				}
			} while (i <= 4);
			System.out.println("You've tired 4 times and are now locked out of your account!");
		}

	// Performs test to determine if password is between 6 and 12 characters in
	// length
	public static boolean lengthTest(String password) {
		if (!(password.length() < 6 || password.length() > 12))
			return true;
		else
			return false;
	}

	// Performs test to determine if password contains only digits and letters
	public static boolean onlyLettersAndDigitsTest(String password) {
		boolean turn = true;
		for (int i = 0; i < password.length(); i++) {
			numAndDig = password.charAt(i);
			if (!((numAndDig >= 65 && numAndDig <= 90) || (numAndDig >= 97 && numAndDig <= 122)
					|| (numAndDig >= 48 && numAndDig <= 57))) {
				turn = false;
			}
		}
		return turn;

	}

	// Performs test to determine if password contains only one digit
	public static boolean containsOneDigitTest(String password) {
		boolean turn = true;
		int count = 0;
		for (int i = 0; i < password.length(); i++) {
			numAndDig = password.charAt(i);
			if ((numAndDig >= 48 && numAndDig <= 57)) {
				count++;
			}
		}
		if (count > 1 || count < 1) {
			turn = false;
		}
		return turn;
	}

	// Performs test to determine if password is different than previous two
	// passwords
	public static boolean differentThanLastTwoPasswordsTest(String previousPassword1, String previousPassword2,
			String password) {
		if (password.equals(previousPassword1)) {
			return false;
		} else if (password.equals(previousPassword2)) {
			return false;
		} else {
			return true;
		}
	}

	public static void printErrorMessage(int errorCode) {
		if (errorCode == 1) {
			System.out.println("Password does not meet requirement: must be between 6 and 12 characters");
		} else if (errorCode == 2) {
			System.out.println("Password does not meet requirement: must contain only letters and digits");
		} else if (errorCode == 3) {
			System.out.println("Password does not meet requirement: must contain only 1 digit");
		} else if (errorCode == 4) {
			System.out.println("Password does not meet requirement: must be different than previous 2 passwords ");
		}
	}
}
