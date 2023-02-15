/*
 * Name: Carl Markowski
 * CS1450 MW
 * Due: Feb 2, 2022
 * Assignment 2
 * This program will display my ability to program classes and subclasses as well as methods
 * to produce certain tables of information
 */

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class MarkowskiCarlAssignment2 {

	public static void main(String[] args) throws IOException {

		// Creation of file of "Vehicles.txt" for gathering information
		// Creation of scanner for reading the file
		File fileName = new File("Vehicles.txt");
		Scanner readFile = new Scanner(fileName);

		// vehicles array created and set to "size"
		int size = readFile.nextInt();
		Vehicle[] vehicles = new Vehicle[size];

		// For loop to iterate through the size of the vehicles array
		// and read in the values from the file
		for (int i = 0; i < vehicles.length; i++) {
			String type = readFile.next();
			String name = readFile.nextLine();

			// if statements are used to determine the proper constructor that
			// needs to be called
			if (type.equals("bus")) {
				vehicles[i] = new Bus(type, name);
			} else if (type.equals("car")) {
				vehicles[i] = new Car(type, name);
			} else if (type.equals("motorcycle")) {
				vehicles[i] = new Motorcycle(type, name);
			} else if (type.equals("train")) {
				vehicles[i] = new Train(type, name);
			} else {
				System.out.println("test");
			}
		}

		// Beginning format for the display table
		System.out.printf("---------------------------------------");
		System.out.printf("\nType \t\tName \t\tSound");
		System.out.printf("\n---------------------------------------");

		// For loop to iterate through the vehicles array and print out the values
		for (int i = 0; i < vehicles.length; i++) {
			System.out.printf("\n" + vehicles[i].getType() + "\t" + vehicles[i].getName() + "\t");
			vehicles[i].sound();
		}

		readFile.close();

		RepairShop repairShop = new RepairShop();
		
		//Two public methods called from the RepairShop class to complete different tasks
		repairShop.fillRepairShop(vehicles);
		repairShop.printRepairShopDetails();

	}
}

class Vehicle {
	// Class that represents a generic type of vehicle
	// Superclass

	private String type;
	private String name;

	public Vehicle(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void sound() {
		System.out.println("generic sound");
	}
}

class Bus extends Vehicle {
	// Represents a specific Vehicle type, "Bus"
	// Subclass of Vehicle

	public Bus(String type, String name) {
		super("Bus", name);
	}

	public void sound() {
		System.out.println(" Rum-rum-rum-rummm");
	}
}

class Car extends Vehicle {
	// Represents a specific type of Vehicle, "Car"
	// Subclass of Vehicle

	public Car(String type, String name) {
		super(type, name);
	}

	public void sound() {
		System.out.println(" Vroom-vroom-vroommm");
	}
}

class Motorcycle extends Vehicle {
	// Represents a specific type of Vehicle, "Motorcycle"
	// Subclass of Vehicle

	public Motorcycle(String type, String name) {
		super(type, name);
	}

	public void sound() {
		System.out.println(" Bom-bom-bom");
	}
}

class Train extends Vehicle {
	// Represents a specific type of Vehicle, "Train"
	// Subclass of Vehicle

	public Train(String type, String name) {
		super(type, name);
	}

	public void sound() {
		System.out.println(" Chooga-chooga-chooga");
	}
}

class RepairShop {
	// Class that represents the RepairShop that only works on cars and motorcycles

	private int numCars;
	private int numMotorcycles;
	private Vehicle[] vehiclesToRepair;

	public RepairShop() {
		// Default constructor
	}

	public void fillRepairShop(Vehicle[] vehicles) {
		//Method used to fill the vehiclesToRepair array with
		//only cars and motorcycles
		

		// For loop to increment the amount of cars and motorcycles
		// from incoming array
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] instanceof Car) {
				numCars++;
			} 
			else if (vehicles[i] instanceof Motorcycle) {
				numMotorcycles++;
			}
		}
		
		int counter = 0;
		vehiclesToRepair = new Vehicle[numCars + numMotorcycles];

		//For loop to iterate through the vehicles array and transfer the proper
		//objects into the vehiclesToRepair array
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i].getType().equals("car") || vehicles[i].getType().equals("motorcycle")) {
				vehiclesToRepair[counter] = vehicles[i];
				counter++;
			} 
		}		
	}

	public void printRepairShopDetails() {
		// Method to print out the cars and motorcycles inside of the
		// vehiclesToRepair array

		System.out.println("----------------------------------");
		System.out.println("Cars and Mortorcycles repair shop");
		System.out.println("----------------------------------");

		System.out.println("Number of Cars: " + numCars);
		System.out.println("Number of Motorcycles: " + numMotorcycles);
		System.out.println("");
		
		for (int i = 0; i < vehiclesToRepair.length; i++) {
			System.out.printf(vehiclesToRepair[i].getType() + "\t---" + vehiclesToRepair[i].getName());
			System.out.println("");
		}

	}
}
