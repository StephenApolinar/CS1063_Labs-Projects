/* Created by: Stephen A. Apolinar
   Date: 09/05/2016 */
/* The beginning of every java program includes a class. */
public class OldMacDonald_5 {
/* Every Java program contains a class with a main method.  Instructions or statements in the body of the main method (statements between {}) are executed one at a time.  Each statement ends in a semicolon (;).  Instructions in main method are executed.
System.out.println command prints a string, and then starts a new line. */ 
	public static void main(String[] args) {
		// print title
		title();

		// print first verse with method calls
		firstVerse();
		secondVerse();
		thirdVerse();
		

		// print second and third verses (not done yet)
	}

	// This method prints the title
	public static void title() {
		System.out.println("Old MacDonald Had a Farm");
		System.out.println();
	}

	// This method prints the Old Macdonald line
	public static void oldMacLine() {
		System.out.println("Old Macdonald had a farm, E-I-E-I-O");
	}
	
	// This method prints the moo lines
	public static void moo_moo() {
		System.out.println("With a moo-moo here and a moo-moo there");
		System.out.println("Here a moo there a moo");
		System.out.println("Everywhere a moo-moo");
	}

	// This method prints the first verse of Old MacDonald
	public static void firstVerse() {
		oldMacLine();
		System.out.println("And on his farm he had a cow, E-I-E-I-O");
		moo_moo();
		oldMacLine();
		System.out.println();
	}
	
	// This method prints the oink lines
	public static void oink_oink() {
		System.out.println("With an oink-oink here and an oink-oink there");
		System.out.println("Here an oink there an oink");
		System.out.println("Everywhere an oink-oink");
	}

	// This method prints the second verse of Old MacDonald
	public static void secondVerse() {
		oldMacLine();
		System.out.println("And on his farm he had a pig, E-I-E-I-O");
		oink_oink();
		moo_moo();
		oldMacLine();
		System.out.println();
	}
	
	// This method prints the neigh lines
	public static void neigh_neigh() {
		System.out.println("With a neigh-neigh here and a neigh-neigh there");
		System.out.println("Here a neigh there a neigh");
		System.out.println("Everywhere a neigh-neigh");
	}

	// This method prints the third verse of Old MacDonald
	public static void thirdVerse() {
		oldMacLine();
		System.out.println("And on his farm he had a horse, E-I-E-I-O");
		neigh_neigh();
		oink_oink();
		moo_moo();
		oldMacLine();
		System.out.println();
	}
}
