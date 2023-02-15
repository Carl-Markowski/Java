/*
 * Carl Markowski
 * CS1450 M/W
 * Due- Mar 2, 2022
 * Assignment 5
 * This program will show my understanding and ability to use generic data types and stacks
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class MarkowskiCarlAssignment5 {

	public static void main(String[] args) throws IOException {

		// Beginning of Part one
		int values[] = { 12, 9, 10, 4, 2, 5, 15, 7, 11, 14 };

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < values.length; i++) {
			stack.push(values[i]);
		}
		int evenNum = findNumEven(stack);

		System.out.println("Stack Values After Find Number of Even Values");
		System.out.println("----------------------------------------------");
		printStack(stack);

		System.out.println("Number of even values: " + evenNum);
		// End of part one

		// Beginning of part two
		// Files and Scanners made for the two different Numbers files
		File numbers1 = new File("Numbers1.txt");
		Scanner readNumbers1 = new Scanner(numbers1);

		File numbers2 = new File("Numbers2.txt");
		Scanner readNumbers2 = new Scanner(numbers2);

		// Stack1 created and filled with values from the Numbers1.txt file
		GenericStack<Integer> intStack1 = new GenericStack<>();

		while (readNumbers1.hasNext()) {
			int number1Value = readNumbers1.nextInt();
			intStack1.push(number1Value);
		}

		// Values in stack1 printed out using the printStacks method
		System.out.println();
		System.out.println("Values read from Numbers1.txt and pushed into stack1");
		System.out.println("----------------------------------------------------");
		printStacks(intStack1);

		readNumbers1.close();

		// stack2 created and filled with the values from Numbers2.txt file
		GenericStack<Integer> intStack2 = new GenericStack<>();

		while (readNumbers2.hasNext()) {
			int number2Value = readNumbers2.nextInt();
			intStack2.push(number2Value);
		}

		// Values in stack2 printed out using the printStacks method
		System.out.println();
		System.out.println("Values read from Numbers2.txt and pushed into stack2");
		System.out.println("----------------------------------------------------");
		printStacks(intStack2);

		readNumbers2.close();

		// combineStacks method called to combine stack1 and stack2 into one stack
		GenericStack<Integer> unsortedIntStack = new GenericStack<>();
		unsortedIntStack = combineStacks(intStack1, intStack2);

		//Sort stack method called to sort the stacks
		GenericStack<Integer> sortedIntStack = new GenericStack<>();
		sortStack(unsortedIntStack, sortedIntStack);

		//Sorted stack printed out
		System.out.println("\nCombined Number Stack With Duplicates- Lowest to Greatest");
		System.out.println("---------------------------------------------------------");
		printStacks(sortedIntStack);

		//removeDuplicates method called to remove the duplicates and print it out
		System.out.println("\nDuplicates Number Stack- Largest Value On Top");
		System.out.println("---------------------------------------------");
		printStacks(removeDuplicates(sortedIntStack));

		//Sorted stack printed without duplicates
		System.out.println("\nSorted Stack Without Duplicates- Smallest to Largest Value");
		System.out.println("------------------------------------------------------------");
		printStacks(sortedIntStack);

		// Beginning of Part three
		// Files and Scanners made for the two different Numbers files
		File string1 = new File("Strings1.txt");
		Scanner readString1 = new Scanner(string1);

		File string2 = new File("Strings2.txt");
		Scanner readString2 = new Scanner(string2);

		// Stack1 created and filled with values from the Numbers1.txt file
		GenericStack<String> stringStack1 = new GenericStack<>();

		while (readString1.hasNext()) {
			String string1Value = readString1.next();
			stringStack1.push(string1Value);
		}

		// Values in stack1 printed out using the printStacks method
		System.out.println();
		System.out.println("Values read from Strings1.txt and pushed into stack1");
		System.out.println("----------------------------------------------------");
		printStacks(stringStack1);

		readString1.close();

		// stack2 created and filled with the values from Numbers2.txt file
		GenericStack<String> stringStack2 = new GenericStack<>();

		while (readString2.hasNext()) {
			String string2Value = readString2.next();
			stringStack2.push(string2Value);
		}

		// Values in stack2 printed out using the printStacks method
		System.out.println();
		System.out.println("Values read from String2.txt and pushed into stack2");
		System.out.println("----------------------------------------------------");
		printStacks(stringStack2);

		readString2.close();

		// combineStacks method called to combine stack1 and stack2 into one stack
		GenericStack<String> unsortedStringStack = new GenericStack<>();
		unsortedStringStack = combineStacks(stringStack1, stringStack2);

		//sortStack method called to sort the stacks 
		GenericStack<String> sortedStringStack = new GenericStack<>();
		sortStack(unsortedStringStack, sortedStringStack);

		//Sorted stack printed 
		System.out.println("\nCombined String Stack With Duplicates- Lowest value on top");
		System.out.println("---------------------------------------------------------");
		printStacks(sortedStringStack);

		//Remove duplicates stack called and duplicates stack printed
		System.out.println("\nDuplicates String Stack- Largest Value on Top");
		System.out.println("---------------------------------------------");
		printStacks(removeDuplicates(sortedStringStack));
		
		//Sorted stack without duplicates printed
		System.out.println("\nSorted Stack Without Duplicates- Lowest Value on Top");
		System.out.println("------------------------------------------------------------");
		printStacks(sortedStringStack);

	}// Main

	// NON GENERIC method for finding the number of even numbers in stack
	public static int findNumEven(Stack<Integer> stack) {
		// Variables to avoid the size issues with stack.size()
		int stackSize = stack.size();
		int numEven = 0;
		int value;
		Stack<Integer> tempStack = new Stack<>();

		// For loop finding all of the even numbers in the stack
		for (int i = 0; i < stackSize; i++) {
			value = stack.pop();
			tempStack.push(value);
			if (value % 2 == 0) {
				numEven++;
			}
		}

		// For loop to refill stack
		int tempStackSize = tempStack.size();
		for (int j = 0; j < tempStackSize; j++) {
			stack.push(tempStack.pop());
		}

		return numEven;
	}// findNumEven

	// NON GENERIC method for printing stack
	public static void printStack(Stack<Integer> stack) {

		int value;
		int stackSize = stack.size();
		Stack<Integer> tempStack = new Stack<>();

		// For loop to print out the pop values and push them onto temp stack
		for (int i = 0; i < stackSize; i++) {
			value = stack.pop();
			tempStack.push(value);
			System.out.println(value);
		}

		// For loop to refill stack
		int tempStackSize = tempStack.size();
		for (int j = 0; j < tempStackSize; j++) {
			stack.push(tempStack.pop());
		}
	}// printStack(Not Generic)

	// Method for printing out the different generic stacks
	public static <E> void printStacks(GenericStack<E> stack) {

		int size = stack.getSize();
		GenericStack<E> tempStack = new GenericStack<>();

		// For loop to print out values in stack
		for (int i = 0; i < size; i++) {
			tempStack.push(stack.peek());
			System.out.println(stack.pop());
		}

		// For loop to refill stack
		int tempStackSize = tempStack.getSize();
		for (int j = 0; j < tempStackSize; j++) {
			stack.push(tempStack.pop());
		}
	}// printStack(Generic)

	// Method used to combine stack1 and stack2 into an unsortedStack
	public static <E> GenericStack<E> combineStacks(GenericStack<E> stack1, GenericStack<E> stack2) {

		// Combined stack and stack size varibles
		GenericStack<E> combinedStack = new GenericStack<>();
		int stack1Size = stack1.getSize();
		int stack2Size = stack2.getSize();

		// For loop to push the values from stack1 into the combined stack
		for (int i = 0; i < stack1Size; i++) {
			combinedStack.push(stack1.pop());
		}

		// For loop to push the values from stack2 into the combined stack
		for (int j = 0; j < stack2Size; j++) {
			combinedStack.push(stack2.pop());
		}

		return combinedStack;
	}// combineStacks

	// This method sorts the various stacks
	public static <E extends Comparable<E>> void sortStack(GenericStack<E> unsortedStack, GenericStack<E> sortedStack) {

		while (!unsortedStack.isEmpty()) {

			E value = unsortedStack.pop();

			boolean foundLoc = false;
			while (!sortedStack.isEmpty() && foundLoc == false) {

				if (value.compareTo(sortedStack.peek()) > 0) {
					unsortedStack.push(sortedStack.pop());
				} else {
					foundLoc = true;
				}
			}
			sortedStack.push(value);
		}
	}// sortStack

	// This method removes the duplicate values from the combinedStack
	public static <E extends Comparable<E>> GenericStack<E> removeDuplicates(GenericStack<E> stack) {

		GenericStack<E> duplicateStack = new GenericStack<>();
		GenericStack<E> tempStack = new GenericStack<>();
		int stackSize = stack.getSize();

		while (!stack.isEmpty()) {

			E value = stack.pop();

			boolean foundLoc = false;
			while (!tempStack.isEmpty() && foundLoc == false) {

				if (value.compareTo(tempStack.pop()) == 0) {
					duplicateStack.push(value);
					foundLoc = true;
				} else {
					tempStack.push(value);
					foundLoc = true;
				}
			}
			tempStack.push(value);
		}

		int tempStackSize = tempStack.getSize();
		for (int i = 0; i < tempStackSize; i++) {
			stack.push(tempStack.pop());
		}
		return duplicateStack;
	}// removeDuplicates

}// MarkowskiCarlAssignment5

class GenericStack<E> {
	// Represents a stack of generic type

	private ArrayList<E> list;

	public GenericStack() {
		list = new ArrayList<>();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int getSize() {
		return list.size();
	}

	public E peek() {
		return list.get(getSize() - 1);
	}

	public E pop() {
		E value = list.remove(getSize() - 1);
		return value;
	}

	public void push(E value) {
		list.add(value);
	}
}
