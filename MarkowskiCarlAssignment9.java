package bin;

import java.util.Random;

public class MarkowskiCarlAssignment9 {
	/*
	 * Name: Carl Markowski Class: CS1150 Section:1 Due Date: 11/09/2021
	 * Description: Assignment 9 This program will show my ability to manipulate
	 * arrays
	 */
	
	//Public Arrays 
	public static int [] list;
	public static int [] list2;
	public static String arrayName;
	
	
	public static void main(String[] args) {
		int[] list= new int[10];
		int[] list2= new int[10];
		Random ranNum = new Random(75);
		int random= ranNum.nextInt();
		
		//These two methods fill the arrays with their respective values
		fillWithEvenValues(list);
		fillWithOddValues(list2);
		
	
	//Display method called to display the sorted even and odd arrays
	displayList(list, list2, arrayName);
	
	}
		// Fill an array with even randomly generated values 
	public static void fillWithEvenValues (int[] list) {
		for (int i = 0; i < list.length; i++) {
			list[i] = (int)(Math.random() * 75);	
		}
		int smallest = list[0];
		for (int j = 0; j < list.length; j++) {
			if (smallest > list[j]) {
				smallest = list[j];
				list[0] = smallest;
			}
		}
	}
	 
		// Fill an array with odd randomly generated values 
	public static void fillWithOddValues (int[] list2) {
		for (int i = 0; i < list2.length; i++) {
			list2[i] = (int)(Math.random() * 75);	
		}
		int smallest = list2[0];
		for (int j = 0; j < list2.length; j++) {
			if (smallest > list2[j]) {
				smallest = list2[j];
				list2[0] = smallest;
			}
		}
	}
		 
		// Displays the values in an array.  arrayName is a string describing the array 
	public static void displayList (int[] list, int[] list2, String arrayName) {
	
	 	System.out.println("Even Array Sorted");
	 	System.out.println("-------------------------------------------------------------");
		for (int i =0;i < list.length; i++){
			System.out.println("array [" + i + "] =" + list[i]);
		}
		
		System.out.println("\nOdd Array Sorted");
	 	System.out.println("-------------------------------------------------------------");
		for (int i =0; i < list2.length; i++){
			System.out.println("array [" + i + "] =" + list2[i]);
		}
	}

		
		 
/*		// Merge two arrays into one unsorted array 
	public static void mergeArrays(int[] list1, int[] list2, int[] merged)  
		 
		// Sort an array into descending order 
	public static void descendingOrderSort (int[] list) {

	// Merge two sorted arrays into one sorted array without using Arrays.sort
	// method
	public static void sortedMerge(int[] list1, int[] list2, int[] merged)  
		
*/	
		
		
		
		
	}


