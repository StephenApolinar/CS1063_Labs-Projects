/* Created by: Stephen A. Apolinar
 Date: 09/20/2016 */
// WE need a Java utility (the Scanner class) for keyboard Input.
import java.util.*;

// Auto Generated Java Class
public class Coins {
  //Set up a class constant named CONSOLE to read from the keyboard.
  public static final Scanner CONSOLE = new Scanner(System.in);
  
  // Main Method/Program execution
  public static void main(String[] args) {
    // prints name and date
    System.out.println("Lab 2 written by Stephen A. Apolinar on 09/20/2016");
    
    // call methods
    coinsToDollars();
    centsToCoins();
  }
  
// This part of program is method calls, which are called in the main method.
  
  // Methods
  //  coinsToDollars method calculates the total amount of all coins entered by user, and prints out coins entered.
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
  
  // centsToCoins deduces the number of coins which add up to the total cents entered by user.
  public static void centsToCoins() {
    System.out.print("Enter the number of cents:");
    int cents = CONSOLE.nextInt();
    int numQtrs = cents / 25;
    int remAfterQtrs = cents % 25;
    int numDms = remAfterQtrs / 10;
    int remAfterDms = remAfterQtrs % 10;
    int numNickles = remAfterDms / 5;
    int numLincons = remAfterDms % 5;
    System.out.println(numQtrs + " Quarters, " + numDms + " Dimes, " + numNickles + " Nickles, " + numLincons + " Pennies add up to " + cents + 
                       " cents.");
  }
}
