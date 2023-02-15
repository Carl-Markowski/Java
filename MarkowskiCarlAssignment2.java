package bin;

import java.util.Scanner;

/* 
 * Name- Carl Markowski
 * Class- CS1150
 * Section- 1
 * Due- Sep 13, 2021
 * Description- Assignment 2
 * This assignment demonstrates my ability to utilize user input in future calculations in order to determine different weather factors of two places.
 * It also shows my ability to properly order arithmetic expressions and use constants, variables, and exponents.
 */

public class MarkowskiCarlAssignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Beginning of the Location 1 information code
		System.out.println("Location #1 Information \n");
		System.out.println("------------------------ \n");
		
		//This piece of code stores the value entered for the name of location 1
		Scanner input= new Scanner(System.in); 
		System.out.print("Enter name of 1st location: ");
		String namLoc1 = input.next();
		System.out.println("Enter name of 1st locaction: " + namLoc1);
		
		
		//This piece of code stores the value for the wind speed of location 1
		Scanner Input= new Scanner(System.in); 
		System.out.print("Enter the wind speed of the 1st location: ");
		double winSpd1 = Input.nextDouble();
		System.out.println("Enter the wind speed of the 1st location: " + winSpd1);
		
		
		//This piece of code stores the value for the temp of location 1
		Scanner iNput= new Scanner(System.in); 
		System.out.print("Enter the temp in Fahrenheit at 1st location: ");
		double fahrenheit1 = iNput.nextDouble();
		System.out.println("Enter the temp in Fahrenheit at 1st location: " + fahrenheit1);
		//End of Location 1 information code
		
		
		//Beginning of location 2 code
		System.out.println("\n Location #2 Information");
		System.out.println("------------------------");
		
		//This piece of code stores the value for the name of location 2
		Scanner inPut= new Scanner(System.in); 
		System.out.print("Enter the name of 2nd location: ");
		String namLoc2 = inPut.next();
		System.out.println("Enter the name of 2nd location: " + namLoc2);
		
		
		//This piece of code stores the value of the wind speed at 2nd location
		Scanner inpUt= new Scanner(System.in); 
		System.out.print("Enter the wind speed at 2nd location: ");
		double winSpd2 = Input.nextDouble();
		System.out.println("Enter the wind speed at 2nd location: " + winSpd2);
		
		
		//This piece of code stores the value for the temp at 2nd location
		Scanner inpuT= new Scanner(System.in); 
		System.out.print("Enter the temp in Fahrenheit at 2nd location: ");
		double fahrenheit2 = inpuT.nextDouble();
		System.out.println("Enter the temp in Fahernheit at 2nd location: " + fahrenheit2);
		
		
		//The following code is the beginning of the wind chill calculator
		System.out.println("\n****************************************");
		System.out.println("\tWind Chill Calculator");
		System.out.println("****************************************");
		
		//Declaring constants and other variables
		final double EXPONENT_CONSTANT = 0.16;
		double celsius1;
		double celsius2;
		double winchillf1;
		double winchillf2;
		double winchillc1;
		double winchillc2;
		double tempc2;
		double tempc1;
		
		
		
		
		
		//Start of wind chill calculator
		System.out.println("Location\tWind Speed\tTemperature(F)\tWind Chill(f)\t"
				+ "Temperature(C)\tWind Chill(C)");
		System.out.println("-------------------------------------------------------------------------"
				+ "--------------------");
		//Location 1 calculations 
		System.out.printf("%s", namLoc1);
		System.out.printf("\t%6.2f", winSpd1);
		System.out.printf("\t\t%6.2f", fahrenheit1);
		System.out.printf("\t\t%6.2f", 35.74 + (.6215 * fahrenheit1) - (35.75 * Math.pow(winSpd1, EXPONENT_CONSTANT)) +
				(.4275 * fahrenheit1 * Math.pow(winSpd1, EXPONENT_CONSTANT)));
		System.out.printf("\t\t%6.2f", (5.0 / 9) * (fahrenheit1 - 32));
		celsius1 = 35.74 + (.6215 * fahrenheit1) - (35.75 * Math.pow(winSpd1, EXPONENT_CONSTANT)) +
				(.4275 * fahrenheit1 * Math.pow(winSpd1, EXPONENT_CONSTANT));
		System.out.printf("\t\t%6.2f", (5.0 / 9) * (celsius1 - 32));
		
		//Location 2 Calculations
		System.out.printf("\n%s", namLoc2);
		System.out.printf("\t%6.2f", winSpd2);
		System.out.printf("\t\t%6.2f", fahrenheit2);
		System.out.printf("\t\t%6.2f", 35.74 + (.6215 * fahrenheit2) - (35.75 * Math.pow(winSpd2, EXPONENT_CONSTANT)) +
				(.4275 * fahrenheit2 * Math.pow(winSpd2, EXPONENT_CONSTANT)));
		System.out.printf("\t\t%6.2f", (5.0 / 9) * (fahrenheit2 -32));
		celsius2= 35.74 + (.6215 * fahrenheit2) - (35.75 * Math.pow(winSpd2, EXPONENT_CONSTANT)) +
				(.4275 * fahrenheit2 * Math.pow(winSpd2, EXPONENT_CONSTANT));
		System.out.printf("\t\t%6.2f", (5.0 / 9) * (celsius2 -32));
		//End of location calculations
		
		System.out.println("\n---------------------------------------------------------------------------------------------");
		
		//Start of differences
		System.out.print("Differences");
		System.out.printf("\t%6.2f", winSpd1 - winSpd2);
		System.out.printf("\t\t%6.2f", fahrenheit1 - fahrenheit2);
		winchillf1= 35.74 + (.6215 * fahrenheit1) - (35.75 * Math.pow(winSpd1, EXPONENT_CONSTANT)) +
				(.4275 * fahrenheit1 * Math.pow(winSpd1, EXPONENT_CONSTANT));
		winchillf2= 35.74 + (.6215 * fahrenheit2) - (35.75 * Math.pow(winSpd2, EXPONENT_CONSTANT)) +
				(.4275 * fahrenheit2 * Math.pow(winSpd2, EXPONENT_CONSTANT));
		winchillc1= (5.0 / 9) * (celsius1 -32);
		winchillc2= (5.0 / 9) * (celsius2 -32);
		tempc1= (5.0 / 9) * (fahrenheit1 -32);
		tempc2= (5.0 / 9) * (fahrenheit2 - 32);
		System.out.printf("\t\t%6.2f", winchillf1 - winchillf2);
		System.out.printf("\t\t%6.2f", tempc1 - tempc2);
		System.out.printf("\t\t%6.2f", winchillc1 - winchillc2);
		
		//End of code
	}
}