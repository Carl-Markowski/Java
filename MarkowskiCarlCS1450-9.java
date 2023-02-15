/*
* Carl Markowski
 * CS1450 MW
 * Assignment 9
 * Due: April 20,2022
 * This program will show my ability to use single linked list and double linked list
 */
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;

public class MarkowskiCarlAssignment9 {

	public static void main(String[] args) throws IOException {

		SearchRouteLinkedList searchRoute = new SearchRouteLinkedList();

		// File and scanner made for reading in the locations
		File locationFile = new File("Locations.txt");
		Scanner readLocation = new Scanner(locationFile);

		// Variables to be read in from file
		int number = 0;
		String type;
		String name;
		String activity;

		// while loop used to read in the information from the file
		while (readLocation.hasNextInt()) {
			number = readLocation.nextInt();
			type = readLocation.next();
			name = readLocation.next();
			activity = readLocation.nextLine();

			// Creating and adding the location object to the search route linked list
			Location locationToAdd = new Location(number, type, name, activity);
			searchRoute.addInOrder(locationToAdd);
		}
		readLocation.close();

		// Printing the search route
		searchRoute.printSearchRoute();

		// Removing the types from the linked list
		searchRoute.removeType("start");
		searchRoute.removeType("gas-station");
		searchRoute.removeType("attraction");

		// Printing out the updates search route
		System.out.println("");
		System.out.println("Updated Search Route - No start, gas stations, or attraction types");
		System.out.println("");
		searchRoute.printSearchRoute();

		// Creating new file for the update file and scanner
		File updateFile = new File("Update.txt");
		Scanner readUpdate = new Scanner(updateFile);

		// Reading in the information in from the file
		while (readUpdate.hasNextInt()) {
			number = readUpdate.nextInt();
			type = readUpdate.next();
			name = readUpdate.next();
			activity = readUpdate.nextLine();

			// Creating and adding the location object to the search route linked list
			Location locationToAdd = new Location(number, type, name, activity);
			searchRoute.addInOrder(locationToAdd);
		}
		readUpdate.close();

		// Printing out the new search route
		System.out.println("");
		System.out.println("Updated Search Route - New Activities With Parrots");
		System.out.println("");
		searchRoute.printSearchRoute();

		DoubleLinkedList doubleList = new DoubleLinkedList();
		doubleList.build(searchRoute);

		System.out.println();
		doubleList.printListBackwards();
	}

}

class Location implements Comparable<Location> {
	// Represents one location in the search route

	private int number;
	private String type; // No Spaces
	private String name; // No Spaces
	private String activity; // With Spaces

	public Location(int number, String type, String name, String activity) {
		this.number = number;
		this.type = type;
		this.name = name;
		this.activity = activity;
	}

	// Getter for type
	public String getType() {
		return type;
	}

	// toString() method used to print out the name, type, and activity
	public String toString() {
		return String.format("%-12s\t\t%-25s%-50s", name, type, activity);
	}

	// compareTo() method used to sort the linked list
	public int compareTo(Location otherLocation) {

		int returnValue = 0;

		if (this.number < otherLocation.number) {
			returnValue = -1;
		} else if (this.number == otherLocation.number) {
			returnValue = 0;
		} else {
			returnValue = 1;
		}
		return returnValue;
	}
}

class SearchRouteLinkedList {
	// A single linked list class constructed from nodes
	// Represents the different locations along the search route
	public Node head;

	public SearchRouteLinkedList() {
		head = null;
	}

	// Method used to iterate through the linked list and get the number
	// of nodes in the list
	public int getSize() {

		int size = 0;

		Node temp = head;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

	// Adds the different location objects into the linked list based on
	// their sorted numbers
	public void addInOrder(Location locationToAdd) {

		Node newNode = new Node(locationToAdd);
		Node previous = null;

		if (head == null) {
			head = newNode;
		} else {
			Node current = head;

			while (current != null && newNode.location.compareTo(current.location) == 1) {
				previous = current;
				current = current.next;
			}

			if (previous == null) {
				head = newNode;
				head.next = current;
			} else {
				previous.next = newNode;
				newNode.next = current;
			}
		}
	}

	// Method that gets a certain type of location and
	// removes those types from the linked list
	public void removeType(String typeToRemove) {

		Node current = head;
		Node previous = null;

		// While loop that checks the locations for certain types, if previous is null
		// then remove the first node
		while (current != null) {
			if (current.location.getType().equalsIgnoreCase(typeToRemove)) {
				if (previous == null) {
					head = head.next;
				} else {
					previous.next = current.next;
				}
			} else {
				previous = current;
			}
			current = current.next;
		}
	}

	// Method used to remove the first location and return the
	// location in that node
	public Location removeFirstLocation() {
		
		Node temp;
		
		if(head == null) {
			return null;
		}
		temp = head;
		head = head.next;
		
		return temp.location;
	}

	// Method used to print out the search route
	public void printSearchRoute() {

		System.out.println("Location Name\t\tType\t\tSearcher's Activity");
		System.out.println("--------------------------------------------------------------");

		Node current = head;
		while (current != null) {
			System.out.println(current.location.toString());
			current = current.next;
		}
	}

	// Node class used to construct the single liked list
	private static class Node {

		private Location location;
		private Node next;

		public Node(Location location) {
			this.location = location;
			next = null;
		}
	}
}// SearchRouteLinkedList

class DoubleLinkedList {
	// Double linked list constructed from nodes with locations

	private Node head;
	private Node tail;

	public DoubleLinkedList() {
		head = null;
		tail = null;
	}

	// Method used to build the double linked list
	public void build(SearchRouteLinkedList searchRoute) {

		int size = searchRoute.getSize();
		for (int i = 0; i < size; i++) {
			
			Node aNode = new Node(searchRoute.removeFirstLocation());
			if (head == null) {
			head = aNode;
			tail = aNode;
			} else if (head.next == null){
				head.next = aNode;
				tail = aNode;
				tail.previous = head;
			}
			else {
				Node current = tail;
				tail.next = aNode;
				tail = aNode;
				tail.previous = current;
			}
		}
	}

	public void printListBackwards() {

		System.out.println("Location Name\t\tType\t\tSearcher's Activity");
		System.out.println("--------------------------------------------------------------");

		Node current = tail;
		while (current != null) {
			System.out.println(current.location.toString());
			current = current.previous;
		}
	}

	// Private inner node class for the double linked list
	private static class Node {
		private Location location;
		private Node previous;
		private Node next;

		public Node(Location location) {
			this.location = location;
			previous = null;
			next = null;
		}
	}
}
