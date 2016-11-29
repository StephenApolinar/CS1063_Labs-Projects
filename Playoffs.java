/* Created by: Stephen A. Apolinar
   Date: 11/15/2016 */
import java.util.*;	// Java utility (Scanner class) for keyboard input.

public class Playoffs {
	// Class Constant variables
	//public static final Scanner CONSOLE = new Scanner(System.in);
	
	// non-Constant class variables
	//public static int percentChance;

	// boolean class variables
	//public static boolean team1 = false;

	public static void main(String[] args){
		Scanner CONSOLE = new Scanner(System.in);
		Random r = new Random();	// randoom number object
		// prints Lab, Name, and date.
		System.out.println("Lab 6 written by Stephen A. Apolinar on 11/15/2016");
		System.out.println();
		
		int correctType;
		int percentChance;
		
		String userPrompt = ("The percent chance Team 1 will win a game?" 
				+ "\nChoose a number between 0 and 100. ");
		correctType = getInt(CONSOLE, userPrompt);
		percentChance = goodValue(CONSOLE, userPrompt, correctType);
		//int randomGenerator = r.nextInt(100);
			
		//singleGame(r, percentChance);
		//playoffs(r, percentChance);
		seriesIteration(r, percentChance);
		
	}
	
	// prompts until a valid number is entered
	public static int getInt(Scanner CONSOLE, String prompt) {
		//int userInput;
		System.out.print(prompt);
		// first ensures the user inputs an integer
		while (!CONSOLE.hasNextInt()) {
			CONSOLE.next(); // to discard the input
			System.out.println("Not an integer; try again.");
			System.out.println(prompt);
			//CONSOLE.nextInt();
		} return CONSOLE.nextInt();
	}

	public static int goodValue(Scanner CONSOLE, String prompt, int valueInRange) {
		// test for valid number between 0 and 100
		while (valueInRange < 1 || valueInRange > 99) {
			CONSOLE.next(); // discard input
			System.out.println("Number is not between 0 and 100!");
			System.out.println(prompt);
		} return CONSOLE.nextInt();	
	}

	// Method simulates a singleGame.
	public static int singleGame(Random r, int percentChance1) {
		
		if (r.nextInt(100) < percentChance1) {
			//System.out.println("Team 1 won single game matchup");
			return 0;
		} else {
			//System.out.println("Team 2 won single game matchup");
			return 1;
		}
	}

	// Method simulates a playoff series.
	public static int playoffs(Random r, int percentChance1) {
		int x = 0;
		int y = 0;
		while (x < 4 && y < 4) {
			//percentChance = r.nextInt(100);
			//System.out.println(percentChance);
			if (singleGame(r, percentChance1) == 0) {
				x ++;
			} else {
				y ++;
			}
		}
		// The print statement below was used to check this method for
		// proper execution.  It was causing seriesIteration method 
		// to print out each "1" and "2" on seperate lines.  The 
		// program required for "1" and "2" to be printed on a single
		// horizontal line.  It was commented out after debugging 
		// trouble shoot.
		//System.out.println();
		if (x == 4) {
			//System.out.println("Team 1 won the playoff series");
			return 0;
		} else {
			//System.out.println("Team 2 won the playoff series");
			return 1;
		}
	}

	// Method iterates the playoffs method until one team has won 10 
	// series more than the opposing team.   
	public static void seriesIteration(Random r, int percentChance1) {
		int k = 0;
		int l = 0;
		// call to submethods within this method.
		// This method requires these methods to execute.
		singleGame(r, percentChance1);
		playoffs(r, percentChance1);

		while (k < 10 + l && l < 10 + k ) {
			// statements below were used to trouble shoot 
			// program during intial build.
			//percentChance = r.nextInt(100);
			//System.out.println(percentChance);
			
			// if/else test checks for return value of the playoffs 
			// method, and prints out which team won on a horizontal
			// line.
			if (playoffs(r, percentChance1) == 0) {
				System.out.print("1");
				k ++;
			} else {
				System.out.print("2");
				l ++;
			}
		}
		
		System.out.println();
		// checks value of k and l in while loop to determine when a team
		//  has won a series ten more times than the other team.
		if (k == 10 + l) {
			System.out.println("Team 1 won playoff series iteration");
		} else if (l == 10 + k) {
			System.out.println("Team 2 won playoff series iteration");
		}
	}	
}
