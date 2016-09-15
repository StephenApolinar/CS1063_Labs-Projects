// WE need a Java utility (the Scanner class) for keyboard input.
import java.util.*;

/* Auto Generated Java Class */
public class HalfDollar {
	// set up a class constant named CONSOLE to read from the keyboard
	public static final Scanner CONSOLE = new Scanner(System.in);

	public static void main(String[] args) {
		// call method
		halfDollarAmount();
	}

	public static void halfDollarAmount() {
		System.out.print("Enter the number of half dollars: ");
		int halfDollar = CONSOLE.nextInt();
		double amount = halfDollar * 0.50;
		System.out.println(halfDollar + " half dollars is $" + amount);
	}
}
