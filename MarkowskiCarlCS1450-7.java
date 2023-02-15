/*
 * Carl Markowski
 * CS1450 M/W
 * Assignment 7
 * March 30,2022
 * This is assignment will show my understanding of using priority queues and normal queues
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class MarkowskiCarlAssignment7 {

	public static void main(String[] args) throws IOException {

		double carPrice = 0;
		int carYear = 0;
		String carManufacturer;
		String carModel;
		int row = 0;
		int column = 0;
		String washPlan;

		// File and scanner created in order to read from the file
		File fileName = new File("VendingMachineCars7.txt");
		Scanner readFile = new Scanner(fileName);

		// Read in the values for rows and columns to create a vending machine
		int numberRows = readFile.nextInt();
		int numberColumns = readFile.nextInt();
		VendingMachine7 vendingMachine = new VendingMachine7(numberRows, numberColumns);

		// While loop that reads in the values needed for the vending machine
		while (readFile.hasNext()) {
			column = readFile.nextInt();
			row = readFile.nextInt();
			washPlan = readFile.next();
			carPrice = readFile.nextDouble();
			carYear = readFile.nextInt();
			carManufacturer = readFile.next();
			carModel = readFile.next();

			// Cars constructor called to create the cars
			// "addCarToTower" called to add the different cars into the tower
			Cars7 car = new Cars7(carPrice, carYear, washPlan, carManufacturer, carModel);
			vendingMachine.addCarToTower(row, column, car);

		}
		readFile.close();

		System.out.println("\t\tLoading cars into the vending machine... \n");

		// "displayTower" called to display the cars in their respective spots
		vendingMachine.displayTower();

		// Basic CarWash object created
		CarWash carWash = new CarWash();
		CarWashController controller = new CarWashController();

		System.out.println("\nController: Moving cars from the vending machine to the car wash line");
		System.out.println("---------------------------------------------------------------------");

		// Moving the cars from the vending machine to the waiting line
		controller.moveCarsToWaitingLine(vendingMachine, carWash);

		// Printing out the current state of the vending machine
		System.out.println();
		System.out.println("Show Empty Vending Machine....\n");
		vendingMachine.displayTower();

		// Moving the cars into their respective car washes
		controller.moveCarsIntoCarWash(carWash);

		System.out.println();
		System.out.println("Controller: Moving cars into the car wash");
		System.out.println("-----------------------------------------");

		// Displaying the two car washes
		controller.displayBasicConveyor(carWash);

		System.out.println();
		controller.displayUnlimitedConveyor(carWash);

		//Displaying the controller moving the cars back to the car wash
		System.out.println();
		System.out.println("Controller: Moving clean cars from car wash back into Vending Machine");
		System.out.println("---------------------------------------------------------------------");
		System.out.println();
		controller.moveCarsBackToVendingMachine(vendingMachine, carWash);
		
		//Displaying the final vending machine with the cars loaded back in it
		System.out.println();
		vendingMachine.displayTower();

	}
}

class VendingMachine7 {
	// Represents the Vending Machine of cars
	// Contains one tower W/ a 2D array of cars

	private int numberRows;
	private int numberColumns;
	private Cars7[][] tower;

	public VendingMachine7(int numberRows, int numberColumns) {
		this.numberRows = numberRows;
		this.numberColumns = numberColumns;
		tower = new Cars7[numberRows][numberColumns];
	}

	public int getRows() {
		return numberRows;
	}

	public int getColumns() {
		return numberColumns;
	}

	public void addCarToTower(int row, int column, Cars7 car) {
		tower[row][column] = car;
	}

	//Displays the tower
	public void displayTower() {
		System.out.println("\tColumn 0\tColumn 1\tColumn 2\tColumn 3\tColumn 4");

		for (int rows = 0; rows < numberRows; rows++) {
			System.out.print("Row " + rows);
			for (int columns = 0; columns < numberColumns; columns++) {
				Cars7 aCar = tower[rows][columns];
				if (aCar != null) {
					System.out.print("\t " + aCar.getManufacturer() + "    ");
				} else {
					System.out.print("\t-----\t");
				}
			}
			System.out.println();
		}
	}

	public Cars7 getCarInTower(int row, int column) {
		return tower[row][column];
	}

	//Remove cars from the tower and replaces them with null
	public Cars7 removeCarFromTower(int row, int column) {

		Cars7 aCar = tower[row][column];

		if (aCar != null) {
			tower[row][column] = null;
		}
		return aCar;
	}

	//Finds the open locations in the tower 
	public int[] findOpenLocation() {

		int returnArray[] = new int[2];

		//For- loops to iterate through the tower and return the open locations
			for (int col = 0; col < numberColumns; col++) {
				for (int row = 0; row < numberRows; row++) {
					Cars7 aCar = tower[row][col];

					if (aCar == null) {
						returnArray[0] = row;
						returnArray[1] = col;
						row = numberRows;
						col = numberColumns;
					}
				}
			}
		return returnArray;
	}

}

class Cars7 implements Comparable<Cars7> {
	// Represents one Car

	private double price = 0;
	private int year = 0;
	private String manufacturer;
	private String model;
	private String washPlan;

	public Cars7(double price, int year, String washPlan, String manufacturer, String model) {
		this.price = price;
		this.year = year;
		this.manufacturer = manufacturer;
		this.model = model;
		this.washPlan = washPlan;
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
		return String.format("%-4d\t%-10s\t%-15s", year, manufacturer, model);
	}

	public String getWashPlan() {
		return washPlan;
	}

	@Override
	public int compareTo(Cars7 otherCar) {
		int returnValue = 0;

		if (this.year < otherCar.getYear()) {
			returnValue = -1;
		} else if (this.year > otherCar.getYear()) {
			returnValue = 1;
		}
		return returnValue;
	}
}

class CarWash {
	// Represents the 3 queues that make up the car wash

	private PriorityQueue<Cars7> waitingLine;
	private Queue<Cars7> unlimitedConveyor;
	private Queue<Cars7> basicConveyor;

	public CarWash() {
		waitingLine = new PriorityQueue<>();
		unlimitedConveyor = new LinkedList<>();
		basicConveyor = new LinkedList<>();
	}

	// Checks if the waiting line is empty or not
	public boolean isWaitingLineEmpty() {

		boolean returnValue = false;
		Cars7 car = waitingLine.peek();

		if (car == null) {
			returnValue = true;
		} else {
			returnValue = false;
		}
		return returnValue;
	}

	// Adds the cars from the vending machine to the waiting line
	public void addCarToWaitingLine(Cars7 car) {
		waitingLine.offer(car);
	}

	// Removes the cars from the waiting line and returns the car
	public Cars7 removeCarFromWaitingLine() {
		return waitingLine.poll();
	}

	// Returns the size of the waiting line
	public int waitingLineSize() {
		return waitingLine.size();
	}

	// "Add" method for unlimitedConveyor
	public void addUnlimited(Cars7 car) {
		unlimitedConveyor.offer(car);
	}

	// "Add" method for basicConveyor
	public void addBasic(Cars7 car) {
		basicConveyor.offer(car);
	}

	// "Remove" method for the unlimitedConveyor
	public Cars7 removeUnlimited() {
		return unlimitedConveyor.poll();
	}

	// "Remove" method for basicConveyor
	public Cars7 removeBasic() {
		return basicConveyor.poll();
	}

	// Returns the size of unlimitedConveyor
	public int unlimitedSize() {
		return unlimitedConveyor.size();
	}

	// Returns the size of basicConveyor
	public int basicSize() {
		return basicConveyor.size();
	}

	// Returns a boolean based on the state of unlimitedConveyor
	public boolean isEmptyUnlimited() {
		return unlimitedConveyor.isEmpty();
	}

	// Returns a boolean based on the state of basicConveyor
	public boolean isEmptyBasic() {
		return basicConveyor.isEmpty();
	}
}

class CarWashController {
	// Contains business logic for moving cars from the vending machine into the car
	// wash and back into vending machine

	// This method moves the cars from the vending machine to the waiting line
	public void moveCarsToWaitingLine(VendingMachine7 vendingMachine, CarWash carWash) {

		for (int row = 0; row < vendingMachine.getRows(); row++) {
			for (int col = 0; col < vendingMachine.getColumns(); col++) {

				Cars7 aCar = vendingMachine.removeCarFromTower(row, col);

				if (aCar != null) {
					System.out.println("Moved To Waiting Line: " + aCar.toString());
					carWash.addCarToWaitingLine(aCar);
				}
			}
		}
	}

	// This method moves the cars into their respective car wash based on the
	// car wash plan they were created with
	public void moveCarsIntoCarWash(CarWash carWash) {

		while (!carWash.isWaitingLineEmpty()) {
			Cars7 car = carWash.removeCarFromWaitingLine();

			if (car.getWashPlan().equals("Unlimited")) {
				carWash.addUnlimited(car);
			} else if (car.getWashPlan().equals("Basic")) {
				carWash.addBasic(car);
			}
		}
	}

	// Displays the cars currently in the Basic car wash
	public void displayBasicConveyor(CarWash carWash) {

		Queue<Cars7> tempQueue = new LinkedList<>();
		Cars7 aCar = null;

		// Using the isEmpty() function to determine whether or not to continue
		while (!carWash.isEmptyBasic()) {

			// Removes the car from the basic queue and then prints the information about
			// the car
			aCar = carWash.removeBasic();
			System.out.println("On Basic Wash Conveyor: " + aCar.toString());

			// Adds aCar to tempQueue to be later added back to the basic queue
			tempQueue.offer(aCar);
		}

		int size = tempQueue.size();
		// Adding the car back to the basic queue
		for (int i = 0; i < size; i++) {
			carWash.addBasic(tempQueue.remove());
		}
	}

	// Displays the cars currently in the unlimited car wash
	public void displayUnlimitedConveyor(CarWash carWash) {

		Queue<Cars7> tempQueue = new LinkedList<>();
		Cars7 aCar = null;

		// Using the isEmpty() function to determine whether or not to continue
		while (!carWash.isEmptyUnlimited()) {

			// Removes the car from the unlimited queue and then prints the information
			// about the car
			aCar = carWash.removeUnlimited();
			System.out.println("On Unlimited Wash Conveyor: " + aCar.toString());

			// Adds aCar to tempQueue to be later added back to the unlimited queue
			tempQueue.offer(aCar);
		}

		// Adding the car back to the unlimited queue
		int size = tempQueue.size();
		for (int i = 0; i < size; i++) {
			carWash.addUnlimited(tempQueue.remove());
		}
	}

	// This method uses the Round- Robin rule to load the vending machine with the
	// cars from the car wash
	// Unlimited first then basic
	public void moveCarsBackToVendingMachine(VendingMachine7 vendingMachine, CarWash carWash) {

		int tempArray[];
		boolean whileCondition = false;

		//Do- while loop on the condition of the basic and unlimited car washes
		//if they are both empty than the loop stops
		do {
			//tempArray hold the values from findOpenLocation
			tempArray = vendingMachine.findOpenLocation();
			Cars7 unlimitedCar = carWash.removeUnlimited();
			
			if(unlimitedCar != null) {
				System.out.println("Reloading: " + unlimitedCar.toString());
			}
			
			//Adding the car to the vending machine 
			vendingMachine.addCarToTower(tempArray[0], tempArray[1], unlimitedCar);

			tempArray = vendingMachine.findOpenLocation();
			Cars7 basicCar = carWash.removeBasic();
			
			if(basicCar != null) {
				System.out.println("Reloading: " + basicCar.toString());
			}
			
			vendingMachine.addCarToTower(tempArray[0], tempArray[1], basicCar);

			if (carWash.isEmptyBasic() && carWash.isEmptyUnlimited()) {
				whileCondition = true;
			}
		} while (whileCondition != true);
	}

}
