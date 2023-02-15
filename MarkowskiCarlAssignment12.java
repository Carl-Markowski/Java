package bin;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MarkowskiCarlAssignment12 {


	public static void main(String[] args) throws IOException {
		File inputFileName = new File("assignment12");
		Scanner inputFile = new Scanner (inputFileName);
		Animal[] animalArray = new Animal[5];
		animalArray[0] = new Bear(null, null, null, 0);
		animalArray[1] = new Animal(null, null, null, 0);
		animalArray[2] = new Wolf(null, null, null, 0);
		animalArray[3] = new Panther(null, null, null, 0);
		animalArray[4] = new Penguin(null, null, null, 0);
		
		String type = inputFile.next();
		System.out.println(type);
		inputFile.close();
		
		
	}

}

//Superclass Animal
class Animal {
	
	//Private data fields for "getters"
	private String name;
	private String food;
	private String location;
	private double weight;

	//Initialization of private data fields for created "Animals"
	public Animal(String name, String food, String location, double weight) {
		this.name = name;
		this.food = food;
		this.location = location;
		this.weight = weight;
	}

	//Getter for name
	public String getName() {
		return name;
	}

	//Getter for food
	public String getFood() {
		return food;
	}

	//Getter for location
	public String getLocation() {
		return location;
	}

	//Getter for weight
	public double getWeight() {
		return weight;
	}

	//Represents an action being done by the animal
	public void eat() {
		System.out.println("Animal is eating");
	}

	public void sleep() {
		System.out.println("Animal is sleeping");
	}

	public void swim() {
		System.out.println("Animal is swimming");
	}
}

//Subclass "Panther" of the Animal superclass
class Panther extends Animal {

	public Panther(String name, String food, String location, double weight) {
		super(name, food, location, weight);
	}
	
	public void eat() {
		System.out.println("Panther is eating");
	}
	public void sleep() {
		System.out.println("Panther is Sleeping");
	}
}

//Subclass "Penguin" of the Animal superclass
class Penguin extends Animal {

	public Penguin(String name, String food, String location, double weight) {
		super(name, food, location, weight);
	}
	
	public void eat() {
		System.out.println("Penguin is eating");
	}
	
	public void swim() {
		System.out.println("Penguin is swimming");
	}
}

//Subclass "Bear" of the Animal superclass
class Bear extends Animal {

	public Bear(String name, String food, String location, double weight) {
		super(name, food, location, weight);
	}
	
	public void eat() {
		System.out.println("Bear is eating");
	}
	
	public void sleep() {
		System.out.println("Bear is sleepig");
	}
	
	public void swim() {
		System.out.println("Bear is swimming");
	}
}

//Subclass "Wolf" of the Animal superclasss
class Wolf extends Animal {

	public Wolf(String name, String food, String location, double weight) {
		super(name, food, location, weight);
	}
}