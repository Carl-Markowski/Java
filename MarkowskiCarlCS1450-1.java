/*
 * Name: Carl Markowski
 * CS1450 M/W
 * Due: Jan 26,2022
 * Assignment 1
 * This program will display my ability to manipulate arrays and use files 
 */

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;

public class MarkowskiCarlAssignment1 {

	public static void main(String[] args) throws IOException {

		// Creation of the file "assignment1.txt" and the creation of the print function
		File fileName = new File("assignment1.txt");
		PrintWriter outputFile = new PrintWriter(fileName);

		// Filling the size variables with random integers and printing the numbers to
		// the console and file
		Random r = new Random();
		int size1 = (int) (r.nextInt(15));
		int size2 = (int) (r.nextInt(15));

		System.out.println("Size1 = " + size1);
		System.out.println("Size2 = " + size2);

		// Creation of the array using the two sizes from the previous random function
		// Using a for loop to fill the array with random integers and write them to the
		// console and to the file
		int[] array = new int[size1 + size2];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 49);
			System.out.println(array[i]);
			outputFile.println(array[i]);
		}

		System.out.println("Read " + size1 + " values from file. Placing values into the first array.");
		System.out.println("Read " + size2 + " values from file. Placing values into the second array.");

		outputFile.close();

		// Scanner setup to read from file and place "size1" integers into "array1"
		Scanner readFile = new Scanner(fileName);

		// While loop used to fill "array1" with the integers from the file
		int[] array1 = new int[size1];
		int num = 0;
		while (readFile.hasNextInt() && num < array1.length) {
			array1[num] = readFile.nextInt();
			num++;
		}

		// While loop used to fill "array2" with the integers from the file
		int[] array2 = new int[size2];
		int num2 = 0;
		while (readFile.hasNextInt() && num2 < array2.length) {
			array2[num2] = readFile.nextInt();
			num2++;
		}
		readFile.close();

		// Sort() method used to sort the two arrays before being merged together
		Arrays.sort(array1);
		Arrays.sort(array2);

		// Counters made to loop through the different arrays
		// New array created to be used for merged and sorted values
		int max = 0;
		int array1Index = 0;
		int array2Index = 0;
		int mergedArrayIndex = 0;
		int arraySize = size1 + size2;
		int[] mergedArray = new int[arraySize];

		// While loop and embedded if else statements used to compare values in "array1"
		// and "array2" and
		// put them into the "mergedArray"
		while (array1Index < size1 && array2Index < size2) {
			if (array1[array1Index] < array2[array2Index]) {
				mergedArray[mergedArrayIndex] = array1[array1Index];
				array1Index++;
			} else if (array1[array1Index] > array2[array2Index]) {
				mergedArray[mergedArrayIndex] = array2[array2Index];
				array2Index++;
			} else if (array1[array1Index] == array2[array2Index]) {
				mergedArray[mergedArrayIndex] = array1[array1Index];
				mergedArrayIndex++;
				mergedArray[mergedArrayIndex] = array2[array2Index];
				array1Index++;
				array2Index++;
			}
			mergedArrayIndex++;
		}

		// While loop used to iterate through any remaining values in "array1" and
		// compare them
		// to the mergedArray
		while (array1Index < size1) {
			mergedArray[mergedArrayIndex] = array1[array1Index];
			array1Index++;
			mergedArrayIndex++;
		}

		// While loop used to iterate through any remaining values in "array2" and
		// comare them
		// to the mergedArray
		while (array2Index < size2) {
			mergedArray[mergedArrayIndex] = array2[array2Index];
			array2Index++;
			mergedArrayIndex++;
		}

		System.out.println("\nRandom values sotred in order in merged array");

		// For loop used to print put the values in mergedArray
		for (int i = 0; i < mergedArray.length; i++) {
			System.out.println(mergedArray[i]);
		}
		
		System.out.println("File is in directory: " + fileName.getAbsolutePath());

	}

}
