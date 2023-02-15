/*
 * Carl Markowski
 * CS1450 M/W
 * Due- Feb,23,2022
 * Assignment 4
 * This program will show my ability utilize 2D arrays and mainuplate them using methods
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MarkowskiCarlAssignment4 {

	public static void main(String[] args) throws IOException {

		double carPrice = 0;
		int carYear = 0;
		String carManufacturer;
		String carModel;
		int row = 0;
		int column = 0;

		// File and scanner created in order to read from the file
		File fileName = new File("VendingMachineCars.txt");
		Scanner readFile = new Scanner(fileName);

		// Read in the values for rows and columns to create a vending machine
		int numberRows = readFile.nextInt();
		int numberColumns = readFile.nextInt();
		VendingMachine vendingMachine = new VendingMachine(numberRows, numberColumns);

		// While loop that reads in the values needed for the vending machine
		while (readFile.hasNext()) {
			column = readFile.nextInt();
			row = readFile.nextInt();
			carPrice = readFile.nextDouble();
			carYear = readFile.nextInt();
			carManufacturer = readFile.next();
			carModel = readFile.next();

			// Cars constructor called to create the cars
			// "addCarToTower" called to add the different cars into the tower
			Cars car = new Cars(carPrice, carYear, carManufacturer, carModel);
			vendingMachine.addCarToTower(row, column, car);

		}
		readFile.close();

		System.out.println("\t\tLoading cars into the vending machine... \n");
		
		//"displayTower" called to display the cars in their respective spots
		vendingMachine.displayTower();
		
		//"printInventory" method called
		printInventory(vendingMachine);
		
	}
	
	public static void printInventory (VendingMachine vendingMachine) {
		ArrayList <Cars> compareList = new ArrayList<>();
		
		//for loops used to iterate through the tower and add it to the array list
		for(int row = 0; row < vendingMachine.getRows(); row++) {
			for(int col = 0; col < vendingMachine.getColumns(); col++) {
				Cars carToCompare = vendingMachine.getCarInTower(row, col);
				if (carToCompare != null) {
					compareList.add(carToCompare);
				}
			}
		}
		
		//Collections.sort() used to sort the cars from low to high price
		Collections.sort(compareList);
		
		System.out.println("\n------------------------------------------");
		System.out.println("\tVENDING MACHINE INVENTORY");
		System.out.println("\t(From Low to High)");
		System.out.println("------------------------------------------");
		System.out.println("Year\tManufacturer\tModel\t\tPrice");
		System.out.println("------------------------------------------");
		
		//for loop used to display the cars inside of the array list
		for(int i = 0; i < compareList.size(); i++) {
			System.out.println(compareList.get(i));
		}
	}
}

class VendingMachine {
	// Represents the Vending Machine of cars
	// Contains one tower W/ a 2D array of cars

	private int numberRows;
	private int numberColumns;
	private Cars[][] tower;

	public VendingMachine(int numberRows, int numberColumns) {
		this.numberRows = numberRows;
		this.numberColumns = numberColumns;
		tower = new Cars[numberRows][numberColumns];
	}

	public int getRows() {
		return numberRows;
	}

	public int getColumns() {
		return numberColumns;
	}

	public void addCarToTower(int row, int column, Cars car) {
		tower[row][column] = car;
	}

	public void displayTower() {
		System.out.println("\tColumn 0\tColumn 1\tColumn 2\tColumn 3\tColumn 4");

		for (int rows = 0; rows < numberRows; rows++) {
			System.out.print("Row " + rows);
			for (int columns = 0; columns < numberColumns; columns++) {
				Cars aCar = tower[rows][columns];
				if (aCar != null) {
					System.out.print("\t " + aCar.getManufacturer() + "    ");
				} else {
					System.out.print("\t-----\t");
				}
			}
			System.out.println();
		}
	}

	public Cars getCarInTower(int row, int column) {
		return tower[row][column];
	}
}

class Cars implements Comparable<Cars> {
	// Represents one Car

	private double price = 0;
	private int year = 0;
	private String manufacturer;
	private String model;


	public Cars(double price, int year, String manufacturer, String model) {
		this.price = price;
		this.year = year;
		this.manufacturer = manufacturer;
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public int getYear() {
		return year;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getModel() {
		return model;
	}

	public String toString() {
		return String.format("%-4d\t%-10s\t%-15s\t%-1.2f", year, manufacturer, model, price);
	}	
	
	@Override
	public int compareTo(Cars otherCar) {
		int returnValue = 0;
		
		if(this.price < otherCar.getPrice()) {
			returnValue = -1;
		}
		else if (this.price > otherCar.getPrice()) {
			returnValue = 1;
		}
		return returnValue;
	}
}
