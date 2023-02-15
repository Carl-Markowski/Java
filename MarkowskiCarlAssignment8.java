package bin;

public class MarkowskiCarlAssignment8 {
	/*
	 * Name: Carl Markowski 
	 * Class: CS 1150 
	 * Section:1 
	 * Due Date: November 1, 2021
	 * Description: Assignment 8 
	 * This program will show my ability to create and
	 * manipulate arrays using different methods.
	 */

	// Variables and Constants Declared
	public static final int POP1 = 5500;
	public static final int POP2 = 110000;
	public static final int POP3 = 2790000;
	public static final int POP4 = 659000;
	public static final int POP5 = 105500;
	public static final int POP6 = 13400;
	public static final int POP7 = 107300;
	public static final String CITY1 = "Vail";
	public static final String CITY2 = "Pueblo";
	public static final String CITY3 = "Denver";
	public static final String CITY4 = "Colo Springs";
	public static final String CITY5 = "Greely";
	public static final String CITY6 = "Fruita";
	public static final String CITY7 = "Boulder";
	public static Dog dog1;
	public static Dog dog2;
	public static Dog dog3;
	public static Dog dog4;
	public static Dog dog5;
	public static double totalPopulation = 0;
	public static double average = 0;
	public static double largestPopulation = 0;
	public static int[] populationArray;
	public static String[] citiesArray;
	public static Dog[] dogArray;

	// Main method, used to assign constants to different arrays and print out
	// information in code
	public static void main(String[] args) {
		populationArray = new int[7];
		citiesArray = new String[7];
		dogArray = new Dog[5];

		// Assigning constants to the arrays
		populationArray[0] = POP1;
		populationArray[1] = POP2;
		populationArray[2] = POP3;
		populationArray[3] = POP4;
		populationArray[4] = POP5;
		populationArray[5] = POP6;
		populationArray[6] = POP7;

		citiesArray[0] = CITY1;
		citiesArray[1] = CITY2;
		citiesArray[2] = CITY3;
		citiesArray[3] = CITY4;
		citiesArray[4] = CITY5;
		citiesArray[5] = CITY6;
		citiesArray[6] = CITY7;

		// Creating Dogs
		dog1 = new Dog("Rover", "Woof Woof");
		dog2 = new Dog("Max", "arf arf arf");
		dog3 = new Dog("Tiny", "yap yap yap");
		dog4 = new Dog("Trooper", "ruff ruff ruff");
		dog5 = new Dog("Magoo", "bow wow bow wow");

		// Assigning Dogs to the dogArray
		dogArray[0] = dog1;
		dogArray[1] = dog2;
		dogArray[2] = dog3;
		dogArray[3] = dog4;
		dogArray[4] = dog5;

		// Print statements for information provided by the code
		System.out.println("-----------------------------");
		System.out.println("City \t\t Population");
		System.out.println("-----------------------------");
		displayPopulations(populationArray, citiesArray);

		System.out.println("\nTotal population for all cities is:" + computeTotalPopulation(populationArray));
		System.out.printf("\nAverage population for all cities is:%.2f", computeAveragePopulation(populationArray));

		System.out.println("\n\nCity with the largest population is "
				+ citiesArray[findCityWithLargestPopulation(populationArray)] + " which has a population of "
				+ populationArray[findCityWithLargestPopulation(populationArray)]);

		displayCitiesWithAboveAveragePopulation(populationArray, citiesArray, average);

		makeDogsBark(dogArray);

	}

	// This method displays the table of the different cities and populations
	public static void displayPopulations(int[] population, String[] cities) {
		System.out.println(CITY1 + "\t\t" + POP1);
		System.out.println(CITY2 + "\t\t" + POP2);
		System.out.println(CITY3 + "\t\t" + POP3);
		System.out.println(CITY4 + "\t" + POP4);
		System.out.println(CITY5 + "\t\t" + POP5);
		System.out.println(CITY6 + "\t\t" + POP6);
		System.out.println(CITY7 + "\t\t" + POP7);
	}

	// This method computes the total population from the array above
	public static double computeTotalPopulation(int[] population) {
		totalPopulation = (POP1 + POP2 + POP3 + POP4 + POP5 + POP6 + POP7);
		return totalPopulation;
	}

	// This method computes the average population of all the cities
	public static double computeAveragePopulation(int[] population) {
		totalPopulation = (POP1 + POP2 + POP3 + POP4 + POP5 + POP6 + POP7);
		average = (totalPopulation / 7);
		return average;
	}

	// This method finds the city with the largest population
	public static int findCityWithLargestPopulation(int[] population) {
		int max = populationArray[0];
		int index = 0;
		for (int i = 1; i < populationArray.length; i++) {
			if (populationArray[i] > max) {
				max = populationArray[i];
				index = i;
			}
		}
		return index;
	}

	// This method displays the cities with population that is above the average
	public static void displayCitiesWithAboveAveragePopulation(int[] population, String[] cities, double average) {
		totalPopulation = (POP1 + POP2 + POP3 + POP4 + POP5 + POP6 + POP7);
		average = (totalPopulation / 7);
		for (int i = 0; i < populationArray.length; i++) {
			if (populationArray[i] > average) {
				System.out.println("\n" + citiesArray[i] + " has " + populationArray[i] + " which is above the average of "
						+ computeAveragePopulation(populationArray));
			}

		}
	}

	// This method makes the dogs bark
	public static void makeDogsBark(Dog[] dogArray) {
		for (int i =0; i < dogArray.length;i++) {
			System.out.printf("\n%s barks like this %s", dogArray[i].getName(), dogArray[i].getBark());
		}
	}

}

class Dog {

	private String name;
	private String bark;
	
	public Dog(String name, String bark) {
		this.name = name;
		this.bark = bark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBark() {
		return bark;
	}

	public void setBark(String bark) {
		this.bark = bark;
	}
} // Dog
