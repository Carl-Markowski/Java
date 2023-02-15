package bin;

import java.util.Scanner;

/*
 * Name: Carl Markowski
 * Class: CS 1150
 * Section: 1
 * Due: Sep 20, 2021
 * Description: Assignment 3
 * This program shows my capabilities to utilize "if" statements and "switch" statements.
 * It also shows my ability to code invaild selections and valid selections to complete an order.
 */

public class MarkowskiCarlAssignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declaring variables and constants
		final double Berry_Banana_Price = 7.50;
		final double Tropical = 6.75;
		final double Green_jolt = 5.00;
		final double add_in = 1.50;
		final double tax= 8.25/100;
		
		
		//Beginning of menu
		System.out.println("Welcome to the CS1150 Smoothie Bar!!");
		System.out.println("\nOption\tType\t\tPrice");
		System.out.println("------------------------------------");
		System.out.printf ("1	Berry Banana	$%4.2f \n", Berry_Banana_Price);
		System.out.printf ("2	Tropical	$%4.2f \n", Tropical);
		System.out.printf ("3	Green Jolt	$%4.2f", Green_jolt);
	
		//Scanner input for smoothie selection
		Scanner input= new Scanner(System.in);
		System.out.println("\nSelect a smoothie: 1, 2, or 3:");
		int smoothie= input.nextInt();
		
		if (1 <= smoothie && smoothie<=3){
			System.out.println("Option\tAdd-In\t\tPrice");
			//Beginning of add-in menu
			System.out.println("------------------------------------");
			System.out.println("0\tNo Add-in");
			System.out.println("1\tAlmond Butter\t\t$1.50");
			System.out.println("2\tLime Juice\t\t$1.50");
			System.out.println("\nSelect an Add-In:");

			//Scanner input for Add-in selection
			int addin= input.nextInt();
			
			if(0<= addin && addin<=2) {
			  System.out.println("------------------------------------");
			}
			
			//Receipt calculations
			 if (smoothie == 1 && addin==0){
				System.out.println("Berry Banana Smoothie   $7.50");
				double BBS_TAX= (tax * Berry_Banana_Price) + Berry_Banana_Price;
				System.out.printf("Taxes 			$%4.2f \n", (tax * Berry_Banana_Price));
				System.out.println("------------------------------------");
				System.out.printf("Total Cost		$%4.2f", (BBS_TAX));
			}
			 if (smoothie == 1 && addin ==1) {
				System.out.println("Berry Banana Smoothie		$7.50");
				System.out.println("Add-In				$1.50");
				double BBS_AD= Berry_Banana_Price + add_in;
				double BBS_TAX= (tax * BBS_AD) + BBS_AD;
				System.out.printf("Taxes				$%4.2f \n", (tax * BBS_AD));
				System.out.println("------------------------------------");
				System.out.printf("Total Cost			$%4.2f", (BBS_TAX));
				
			}
			if (smoothie == 1 && addin ==2) {
				System.out.println("Berry Banana Smoothie		$7.50");
				System.out.println("Add-In				$1.50");
				double BBS_AD= Berry_Banana_Price + add_in;
				double BBS_TAX= (tax * BBS_AD) + BBS_AD;
				System.out.printf("Taxes				$%4.2f \n", (tax * BBS_AD));
				System.out.println("------------------------------------");
				System.out.printf("Total Cost			$%4.2f", (BBS_TAX));
			}
			if (smoothie == 2 && addin ==0) {
				System.out.println("Tropical		$6.75");
				double TRO_TAX= (tax * Tropical) + Tropical;
				System.out.printf("Taxes			$%4.2f \n", (tax * Tropical));
				System.out.println("------------------------------------");
				System.out.printf("Total Cost		$%4.2f", TRO_TAX);
			}
			if (smoothie == 2 && addin ==1) {
				System.out.println("Tropical		$6.75");
				System.out.println("Add-In			$1.50");
				double TRO_AD= Tropical + add_in;
				double TRO_TAX= (tax * TRO_AD) + TRO_AD;
				System.out.printf("Taxes			$%4.2f \n", (tax * TRO_AD));
				System.out.println("------------------------------------");
				System.out.printf("Total Cost		$%4.2f", TRO_TAX);
			}
			if (smoothie == 2 && addin == 2) {
				System.out.println("Tropical		$6.75");
				System.out.println("Add-In			$1.50");
				double TRO_AD= Tropical + add_in;
				double TRO_TAX= (tax * TRO_AD) + TRO_AD;
				System.out.printf("Taxes			$%4.2f \n", (tax * TRO_AD));
				System.out.println("------------------------------------");
				System.out.printf("Total Cost		$%4.2f", TRO_TAX);
			}
			if (smoothie ==3 && addin == 0) {
				System.out.println("Green Jolt			$5.00");
				double GRE_TAX= (tax * Green_jolt) + Green_jolt;
				System.out.printf("Taxes				$%4.2f \n", (tax * Green_jolt));
				System.out.println("------------------------------------");
				System.out.printf("Total Cost			$%4.2f", GRE_TAX);
			}
			if (smoothie == 3 && addin ==1) {
				System.out.println("Green Jolt			$5.00");
				System.out.println("Add-In				$1.50");
				double GRE_AD= Green_jolt + add_in;
				double GRE_TAX= (tax * GRE_AD) + GRE_AD;
				System.out.printf("Taxes				$%4.2f \n", (tax * GRE_AD));
				System.out.println("------------------------------------");	
				System.out.printf("Total Cost			$%4.2f", GRE_TAX);
			}
			if (smoothie == 3 && addin ==2) {
				System.out.println("Green Jolt			$5.00");
				System.out.println("Add-In				$1.50");
				double GRE_AD= Green_jolt + add_in;
				double GRE_TAX= (tax * GRE_AD) + GRE_AD;
				System.out.printf("Taxes				$%4.2f \n", (tax * GRE_AD));
				System.out.println("------------------------------------");	
				System.out.printf("Total Cost			$%4.2f", GRE_TAX);
			}
			//Invalid selection if statements
			if (0 > addin || addin > 2) {
				System.out.println("That is an invaild selection. Please run the program again. Good Bye!!");
			}
		}
		
			if (0 == smoothie || smoothie > 3) {
				System.out.println("That is an invaild selection. Please run the program again. Good Bye!!");
			}
		}
	}


