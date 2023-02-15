/*
 * Name: Carl Markowski
 * Class- CS1450 M/W
 * Due: Feb 9, 2022
 * Assignment 3
 * This program will show my ability to code interfaces and abstract classes
 */

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class MarkowskiCarlAssignment3 {

	public static void main(String[] args) throws IOException {

		// File and scanner created in order to read from the file
		File fileName = new File("Animals.txt");
		Scanner readFile = new Scanner(fileName);

		int size = readFile.nextInt();
		Animal[] animalsArray = new Animal[size];

		for (int i = 0; i < animalsArray.length; i++) {
			String species = readFile.next();
			String name = readFile.next();
			int fileSwimSpeed = readFile.nextInt();
			int fileRunSpeed = readFile.nextInt();
			int fileClimbSpeed = readFile.nextInt();

			if (species.equals("alligator")) {
				animalsArray[i] = new Alligator(species, name, fileSwimSpeed, fileRunSpeed);
				animalsArray[i].setName(name);
				animalsArray[i].setSpecies(species);
			} else if (species.equals("bear")) {
				animalsArray[i] = new Bear(species, name, fileSwimSpeed, fileRunSpeed, fileClimbSpeed);
				animalsArray[i].setName(name);
				animalsArray[i].setSpecies(species);
			} else if (species.equals("giraffe")) {
				animalsArray[i] = new Giraffe(species, name, fileRunSpeed);
				animalsArray[i].setName(name);
				animalsArray[i].setSpecies(species);
			} else if (species.equals("monkey")) {
				animalsArray[i] = new Monkey(species, name, fileRunSpeed, fileClimbSpeed);
				animalsArray[i].setName(name);
				animalsArray[i].setSpecies(species);
			} else if (species.equals("sloth")) {
				animalsArray[i] = new Sloth(species, name, fileSwimSpeed, fileClimbSpeed);
				animalsArray[i].setName(name);
				animalsArray[i].setSpecies(species);
			} else {
				System.out.println("test");
			}
		}

		//for (int i = 0; i < animalsArray.length; i++) {
		//	System.out.printf("\n" + animalsArray[i].getSpecies() + "\t" + animalsArray[i].getName() + "\n");
		//	System.out.printf("\n" + ((Swimmer) animalsArray[i]).swim() + ((Runner)animalsArray[i]).run());
		//}

		readFile.close();
		displayAnimal(animalsArray);
		findMostSkilled(animalsArray);
	}

	public static void displayAnimal(Animal[] animalsArray) {

		System.out.println("------------------------------------------------");
		System.out.println("All Animals in Array");
		System.out.println("------------------------------------------------");

		for(int i = 0; i < animalsArray.length; i++) {
			System.out.printf("\n" +animalsArray[i].getName() + " the " + animalsArray[i].getSpecies() + " says " + animalsArray[i].makeNoise());
			System.out.printf("\nSwimming speed is: " + ((Swimmer)animalsArray[i]).swim());
			System.out.printf("\nRunning speed is: " + ((Runner)animalsArray[i]).run());
			System.out.printf("\nSwimming speed is: " + ((Climber)animalsArray[i]).climb());
			
		 }
		
		System.out.println("-------------------------");
		System.out.println("Most Skilled Animal");
		System.out.println("-------------------------");
		System.out.printf("\nThe winner is " + animalsArray[findMostSkilled(animalsArray)].getName() + " the " + animalsArray[findMostSkilled(animalsArray)].getSpecies());
		System.out.printf(animalsArray[findMostSkilled(animalsArray)].makeNoise());
		System.out.printf("\nSwimming Speed: " + ((Swimmer)animalsArray[findMostSkilled(animalsArray)]).swim());
		System.out.printf("\nSwimming Speed: " + ((Runner)animalsArray[findMostSkilled(animalsArray)]).run());
		System.out.printf("\nSwimming Speed: " + ((Climber)animalsArray[findMostSkilled(animalsArray)]).climb());
		
		
	}

	//public static ArrayList<Animal> findClimbers(Animal[] animals) {

	//}

	public static int findMostSkilled(Animal[] animalsArray) {
		Animal highestSkilled = animalsArray[0];
		int mostSkill = 0;
		int i = 0;
		for(i = 0; i < animalsArray.length; i++) {
			int skill1 = ((Swimmer) animalsArray[i]).swim();
			int skill2 = ((Runner)animalsArray[i]).run();
			int skill3 = ((Climber)animalsArray[i]).climb();
			int sum = skill1 + skill2 + skill3;
			
			if (sum < mostSkill) {
				mostSkill = i;
				highestSkilled = animalsArray[mostSkill];
			}
			
			}
		return i;
	}

}

//Interfaces representing different actions 
interface Swimmer {

	public final int SWIMSPEED = 0;

	public abstract int swim();
}

interface Runner {

	public final int RUNSPEED = 0;

	public abstract int run();
}

interface Climber {

	public final int CLIMBSPEED = 0;

	public abstract int climb();
}

abstract class Animal {
	// Abstract class that represents a generic animal
	// Superclass

	private String name;
	private String species;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public abstract String makeNoise();

}

class Alligator extends Animal implements Swimmer, Runner {

	public Alligator(String name, String species, int swimSpeed, int runSpeed) {
		super();
	}

	public int swim() {
		return SWIMSPEED;
	}

	public int run() {
		return RUNSPEED;
	}

	public String makeNoise() {
		String noise = "Crunch Crunch Crunch";
		return noise;
	}
}

class Bear extends Animal implements Swimmer, Runner, Climber {

	public Bear(String name, String species, int swimSpeed, int runSpeed, int climbSpeed) {
		super();
	}

	public int swim() {
		return SWIMSPEED;
	}

	public int run() {
		return RUNSPEED;
	}

	public int climb() {
		return CLIMBSPEED;
	}

	public String makeNoise() {
		String noise = "Growl Growl Growl";
		return noise;
	}
}

class Giraffe extends Animal implements Runner {

	public Giraffe(String name, String species, int runSpeed) {
		super();
	}

	public int run() {
		return RUNSPEED;
	}

	public String makeNoise() {
		String noise = "Bleat Bleat Bleat";
		return noise;
	}
}

class Monkey extends Animal implements Runner, Climber {

	public Monkey(String name, String species, int runSpeed, int swimSpeed) {
		super();
	}

	public int run() {
		return RUNSPEED;
	}

	public int climb() {
		return CLIMBSPEED;
	}

	public String makeNoise() {
		String noise = "Screech Screech Screech";
		return noise;
	}
}

class Sloth extends Animal implements Swimmer, Climber {

	public Sloth(String name, String species, int swimSpeed, int climbSpeed) {
		super();
	}

	public int swim() {
		return SWIMSPEED;
	}

	public int climb() {
		return CLIMBSPEED;
	}

	public String makeNoise() {
		String noise = "Squeak Squeak Squeak";
		return noise;
	}
}
