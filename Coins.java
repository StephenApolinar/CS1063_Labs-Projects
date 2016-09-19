// WE need a Java utility (the Scanner class) for keyboard Input.
import java.util.*;

// Auto Generated Java Class
public class Coins {
	//Set up a class constant named CONSOLE to read from the keyboard.
	public static final Scanner CONSOLE = new Scanner(System.in);

	// Main Method/Program execution
	public static void main(String[] args) {
		//call methods
		coinsToDollars();
	
	}

	// Methods
	public static void coinsToDollars() {
		System.out.print("Enter the number of quarters:");
		int quarters = CONSOLE.nextInt();
		double qtrs = quarters * 0.25;
		System.out.print("Enter the number of dimes:");
		int dimes = CONSOLE.nextInt();
		double dms = dimes * 0.10;
		System.out.print("Enter the number of nickles:");
		int nickles = CONSOLE.nextInt();
		double nckls = nickles * 0.05;
		System.out.print("Enter the number of pennies:");
		int pennies = CONSOLE.nextInt();
		double lincons = pennies * 0.01;
		double amount = qtrs + dms + nckls + lincons;
		System.out.println(quarters + " quarters, " + dimes + " dimes, " + nickles + " nickles, and " + pennies + " pennies is $"  + amount);
	}
}
