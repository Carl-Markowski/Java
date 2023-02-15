/*
 * Carl Markowski
 * CS1450 MW
 * Assignment 8
 * April 6,2022
 * This assignment will show my ability to utilize iterators 
 */

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class MarkowskiCarlAssignment8 {

	public static void main(String[] args) throws IOException {

		// ArrayLists created to hold the values from the files
		ArrayList<Character> msg1 = new ArrayList<>();
		ArrayList<Integer> msg2 = new ArrayList<>();
		ArrayList<Integer> key1 = new ArrayList<>();

		// Files created for the first message
		File msg1File = new File("ListMessage1.txt");
		File msg2File = new File("ListMessage2.txt");
		File keyFile = new File("ListKey.txt");

		// Scanner for msg1 and while loop to fill the arraylist
		Scanner msg1Scan = new Scanner(msg1File);
		int charCount = 0;
		String msg1String = msg1Scan.next();

		while (charCount < msg1String.length()) {
			msg1.add(msg1String.charAt(charCount));
			charCount++;
		}

		msg1Scan.close();

		// Scanner for msg2 and while loop to fill the arraylist
		Scanner msg2Scan = new Scanner(msg2File);
		int msg2Size = msg2Scan.nextInt();

		while (msg2Scan.hasNext()) {
			msg2.add(msg2Scan.nextInt());
		}

		msg2Scan.close();

		// Scanner for key and while loop to fill the arraylist
		Scanner keyScan = new Scanner(keyFile);
		int keySize = keyScan.nextInt();

		while (keyScan.hasNext()) {
			key1.add(keyScan.nextInt());
		}

		keyScan.close();

		// Iterators made for the different arraylists
		Iterator<Character> msg1Iterator = msg1.iterator();
		Iterator<Integer> msg2Iterator = msg2.iterator();
		Iterator<Integer> keyIterator = key1.iterator();

		//Created a Decrypter object and called the unscramble method to unscramble the first message
		Decrypter decrypter = new Decrypter();
		System.out.print("The Secret Message Is: ");
		System.out.println(decrypter.unscramble(keyIterator, msg1Iterator, msg2Iterator));

		// Queues made for the second secret message
		Queue<Character> qMsg1 = new LinkedList<>();
		Queue<Integer> qMsg2 = new LinkedList<>();
		Queue<Integer> qKey = new LinkedList<>();

		// Files made to scan for second message
		File qMsg1File = new File("QueueMessage1.txt");
		File qMsg2File = new File("QueueMessage2.txt");
		File qKeyFile = new File("QueueKey.txt");

		// Scanner and while loop made to fill the first queue
		Scanner qMsg1Scan = new Scanner(qMsg1File);
		int queueCount = 0;
		String queueString = qMsg1Scan.next();

		while (queueCount < queueString.length()) {
			qMsg1.add(queueString.charAt(queueCount));
			queueCount++;
		}

		qMsg1Scan.close();

		// Scanner and while loop made to fill the second queue
		Scanner qMsg2Scan = new Scanner(qMsg2File);
		int qMsg2Size = qMsg2Scan.nextInt();

		while (qMsg2Scan.hasNext()) {
			qMsg2.add(qMsg2Scan.nextInt());
		}

		qMsg2Scan.close();

		// Scanner and while loop made to fill the Key queue
		Scanner qKeyScan = new Scanner(qKeyFile);
		int qKeySize = qKeyScan.nextInt();

		while (qKeyScan.hasNext()) {
			qKey.add(qKeyScan.nextInt());
		}

		qKeyScan.close();

		//Iterators for the queues created and passed to the the decrypter.unscramble() method
		Iterator<Character> qMsg1Iterator = qMsg1.iterator();
		Iterator<Integer> qMsg2Iterator = qMsg2.iterator();
		Iterator<Integer> qKeyIterator = qKey.iterator();

		//decrypter.unscramble called to unscramble the second message
		System.out.println(decrypter.unscramble(qKeyIterator, qMsg1Iterator, qMsg2Iterator));
	}

}

//Decrypter class made to decrypt the secret messages
class Decrypter {
	// This class decrypts secret messages

	private MessageStack stack;

	public Decrypter() {
		stack = new MessageStack();
	}

	//Method used to unscramble the messages based on the key 
	public String unscramble(Iterator<Integer> keyIterator, Iterator<Character> msg1Iterator,
			Iterator<Integer> msg2Iterator) {

		//string created to return and int for the char conversion
		String returnString = "";
		int intToBeConverted = 0;

		//While loop on the condition  of the key having another value
		while (keyIterator.hasNext()) {
			
			//temporary value used to check if '1' or '0' is next in the key
			int keyValue = keyIterator.next();

			//If keyValue = 0 then push on the next character from msg1 to the stack
			if (keyValue == 0) {
				stack.push(msg1Iterator.next());
				
				//If keyValue = 1 convert the next value in msg2 into a character and then push it onto the 
				//stack
			} else if (keyValue == 1) {
				intToBeConverted = msg2Iterator.next();
				stack.push((char) intToBeConverted);
			}
		}

		//while stack has another value add returnString and the next character from the
		//stack to the return string
		while (!stack.isEmpty()) {
			returnString += stack.pop();

		}
		return returnString;
	}

}

//MessageStack class created to have the proper stack methods
class MessageStack {

	private Stack<Character> aStack;

	public MessageStack() {
		aStack = new Stack<>();
	}

	public boolean isEmpty() {
		return aStack.isEmpty();
	}

	public int size() {
		return aStack.size();
	}

	public void push(Character value) {
		aStack.push(value);
	}

	public Character pop() {
		return aStack.pop();
	}
}
