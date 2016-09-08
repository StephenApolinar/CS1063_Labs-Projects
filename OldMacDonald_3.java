/* Created by: Stephen A. Apolinar
   Date: 09/05/2016 */
/* The beginning of every java program includes a class. */
public class OldMacDonald_3 {
/* Every Java program contains a class with a main method.  Instructions or statements in the body of the main method (statements between {}) are executed one at a time.  Each statement ends in a semicolon (;).  Instructions in main method are executed.
System.out.println command prints a string, and then starts a new line. */ 
	public static void main(String[] args) {
		// print title
		System.out.println("Old MacDonald Had a Farm");
		System.out.println();

		// print first verse with method calls
		firstVerse();
		

		// print second and third verses (not done yet)
	}

	// This method prints the Old Macdonald line
	public static void oldMacLine() {
		System.out.println("Old Macdonald had a farm, E-I-E-I-O");
	}
	
	// This method prints the first verse of Old MacDonald
	public static void firstVerse() {
		oldMacLine();
		System.out.println("And on his farm he had a cow, E-I-E-I-O");
		System.out.println("With a moo-moo here and a moo-moo there");
		System.out.println("Here a moo there a moo");
		System.out.println("Everywhere a moo-moo");
		oldMacLine();
		System.out.println();
	}
}
