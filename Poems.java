/* Created by: Stephen A. Apolinar
   Date: 09/05/2016 */
/* The beginning of every java program includes a class. */
public class Poems {
/* Every Java program contains a class with a main method.  Instructions or statements in the body of the main method (statements between {}) are executed one at a time.  Each statement ends in a semicolon (;).  Instructions in main method are executed.
System.out.println command prints a string, and then starts a new line. */ 
	public static void main(String[] args) {
		// prints name and date
		System.out.println("Lab 1 written by Stephen A. Apolinar on 09/05/2016");

		// print first verse from Mary Had a Little Lamb
		MaryFirstVerse();
		// print first three verses of This Old Man
		OldMan();
	}

/* This part of program is method calls, which are called in the main method*/

	// This method prints first verse of "Mary had a little lamb"
	public static void MaryFirstVerse() {
		System.out.println();
		System.out.println("Mary Had a Little Lamb");
		System.out.println();
		Mary();
		Little();
		Mary();
		Snow();
		System.out.println();
	}

	// This method prints first and third line of first Mary verse
	public static void Mary() {
		System.out.println("Mary had a little lamb,");
	}
	
	// This method prints second line of first Mary verse
	public static void Little() {
		System.out.println("Little lamb, little lamb,");
	}

	// This method prints the last line of first Mary verse
	public static void Snow() {
		System.out.println("Its fleece was white as snow");
	}
	
	// This method prints the first three verses of "This Old Man" composed of three method calls
	public static void OldMan() {
		System.out.println("This Old Man");
		System.out.println();
		OldManFirst();
		OldManSecond();
		OldManThird();
	}

	// This method prints the first verse of "This Old Man"
	public static void OldManFirst() {
		System.out.println("This old man, he played one");
		System.out.println("He played knick-knack on my thumb");
		OldManRefrain();
		System.out.println();
	}
	
	// This method prints the second verse of "This Old Man"
	public static void OldManSecond() {
		System.out.println("This old man, he played two");
		System.out.println("He played knick-knack on my shoe");
		OldManRefrain();
		System.out.println();
	}

	// This method prints the third verse of "This Old Man"
	public static void OldManThird() {
		System.out.println("This old man, he played three");
		System.out.println("He played knick-knack on my knee");
		OldManRefrain();
		System.out.println();
	}

	// This method prints OldMan Refrain contained in all three verses
	public static void OldManRefrain() {
		System.out.println("With a knick-knack patty-whack, give a dog a bone");
		System.out.println("This old man came rolling home");
	}
}
