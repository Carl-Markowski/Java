/*
 * Carl Markowski
 * CS1450 MW
 * Assignment 10
 * Due: 04/27/2022
 * This assignment will show my abilities to utilize BST and recursive methods
 */

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class MarkowskiCarlAssignment10 {

	public static void main(String[] args) throws IOException {

		BinarySearchTree theTree = new BinarySearchTree();

		// File and scanner made to read the information from the file
		File parrotFile = new File("parrots.txt");
		Scanner readFile = new Scanner(parrotFile);

		// Variables used to hold the values from the file
		int id;
		String name;
		String songWord;

		// While loop that checks if there is another integer in the file
		while (readFile.hasNextInt()) {
			id = readFile.nextInt();
			name = readFile.next();
			songWord = readFile.next();

			// Creating the new parrot objects and adding them to the tree
			Parrot newParrot = new Parrot(id, name, songWord);

			if (theTree.insert(newParrot) == true) {

			} else {
				System.out.println("Error");
			}
		}

		// Traverse the tree in level order and print out the songWords
		System.out.println("Parrot's Song");
		System.out.println("------------------------------------");
		theTree.levelOrder();

		//Call the recursive method to get the parrots on the leaves
		System.out.println("\n\nParrots on Leaf Nodes");
		System.out.println("------------------------------------");
		theTree.visitLeaves();
	}// Main
}// MarkowskiCarlAssignment10 Class

class Parrot implements Comparable<Parrot> {
	// This class represents a single parrot

	private int id;
	private String name;
	private String songWord;

	public Parrot(int id, String name, String songWord) {
		this.id = id;
		this.name = name;
		this.songWord = songWord;
	}// Constructor
	
	//Getter for Name
	public String getName() {
		return name;
	}//getName()

	// Method to make the parrots "sing"
	public String sing() {
		return songWord;
	}// sing()

	// compareTo method that compares the "id" of the parrots
	public int compareTo(Parrot otherParrot) {

		int returnValue = 0;

		if (this.id > otherParrot.id) {
			returnValue = 1;
		} else if (this.id < otherParrot.id) {
			returnValue = -1;
		} else {
			returnValue = 0;
		}
		return returnValue;
	}// compareTo(Parrot otherParrot)
}// Parrot Class

class BinarySearchTree {
	// Class that represents a BST constructed from nodes
	// Each node contains a "parrot" and uses the parrot's id as the key

	private TreeNode root;

	public BinarySearchTree() {
		root = null;
	}// Constructor

	// Public BST method that adds the new parrots to the tree
	public boolean insert(Parrot parrotToAdd) {

		boolean returnValue = false;

		// If root is null then make parrotToAdd the root
		if (root == null) {
			root = new TreeNode(parrotToAdd);
			returnValue = true;
		}
		// Else make current equal to root and parent equal to null
		else {
			TreeNode parent = null;
			TreeNode current = root;
			while (current != null) {
				// If current's ID is greater than parrotToAdd's Id do
				// the following moves
				if (current.parrot.compareTo(parrotToAdd) == 1) {
					parent = current;
					current = current.left;
				}
				// Else if current's ID is less than parrotToAdd's ID
				// do these moves
				else if (current.parrot.compareTo(parrotToAdd) == -1) {
					parent = current;
					current = current.right;
				}
				// Else if they are duplicate, do nothing
				// NO DUPLICATES
				else {
					returnValue = false;
				}
			}
			// If parent's ID is greater than parrotToAdd's ID
			// Make the left leaf of parent the new node
			if (parent.parrot.compareTo(parrotToAdd) == 1) {
				parent.left = new TreeNode(parrotToAdd);
			}
			// Else make parent's right leaf the new node
			else {
				parent.right = new TreeNode(parrotToAdd);
			}
			returnValue = true;
		}
		return returnValue;

	}// insert(Parrot parrotToAdd)

	// Method that traverses the tree in a level order
	public void levelOrder() {

		// If root is not null add to the tempQueue
		if (root != null) {
			Queue<TreeNode> tempQueue = new LinkedList<>();
			tempQueue.offer(root);
			// While tempQueue is not empty, traverse through the tree
			while (!tempQueue.isEmpty()) {
				TreeNode tempNode = tempQueue.remove();
				System.out.print(" " + tempNode.parrot.sing());

				if (tempNode.left != null) {
					tempQueue.offer(tempNode.left);
				}
				if (tempNode.right != null) {
					tempQueue.offer(tempNode.right);
				}
			}
		}
	}// levelOrder()

	// visitLeaves() is used to call the recursive method visitLeaves
	public void visitLeaves() {
		visitLeaves(root);
	}//visitLeaves()

	//Recursive method that traverses the BST and prints
	//the names of the parrots at the leafs
	private void visitLeaves(TreeNode root) {

		//Check to see if root is null
		if (root != null) {
			//Check to see if the left and right leaves of root are null
			//if they are both null then print out name
			if (root.left == null && root.right == null) {
				System.out.println(root.parrot.getName());
			} else {
				//else, call the method inside (making it recursive) to continue 
				//to traverse the tree
				visitLeaves(root.left);
				visitLeaves(root.right);
			}
		}
	}//visitLeaves(TreeNode root)

	private class TreeNode {
		// Represents one node in the BST

		private Parrot parrot;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(Parrot parrot) {
			this.parrot = parrot;
			left = null;
			right = null;
		}
	}// TreeNode Class
}// BinarySearchTree Class
