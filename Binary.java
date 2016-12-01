/* Created by: Stephen A. Apolinar
   Date: 11/15/2016 */
import java.util.*;	// Java utility (Scanner class) for keyboard input.

public class Binary {
	// non-Constant class variables
	public static int num;

	public static void main(String[] args){
		Scanner CONSOLE = new Scanner(System.in);
		// prints Lab, Name, and date.
		System.out.println("Lab 8 written by Stephen A. Apolinar on 11/15/2016");
		System.out.println();
		
		System.out.println("This Program Converts An Integer Into Binary Numbers");
		System.out.println();
		// String variable for getInt(); method.	
		String userPrompt = ("Choose a positive integer: ");
		int execute = 1;
		while (execute == 1) {
			System.out.println();
			getInt(CONSOLE, userPrompt);

			//This while loop is used as check point to ensure the return 
			// integer is between o and 100. Before running the simulation.
			while (num < 0) {
				getInt(CONSOLE, userPrompt);
			}
			// After a good integer value is attained the simulation 
			// is run with the following submethod.
			//convertToBinary(num);
			//System.out.println(Arrays.toString(convertToBinary(num)));
			/*for (int i = 0; i < binaryNums.length; i++) {
				System.out.print(binaryNums[i]);
			}*/
			System.out.println();
			printBinaryArray(convertToBinary(num));
			System.out.println();
			System.out.println("Do you want to continue (yes or no)? ");
			CONSOLE.nextLine();
			if (CONSOLE.nextLine() != "yes") {
				System.out.println("You answered no. Have a nice day.");
				execute = 0;
			}
		}
					
	}
	
	// prompts until a valid number is entered
	public static int getInt(Scanner CONSOLE, String prompt) {
		//int userInput;
		System.out.print(prompt);
		System.out.println();
		// first ensures the user inputs an integer
		while (!CONSOLE.hasNextInt()) {
			System.out.println();
			CONSOLE.next(); // to discard the input
			System.out.println("Not a positive integer; try again.");
			System.out.println();
			System.out.println(prompt);
		}
		return num = CONSOLE.nextInt();
	}

	// Method simulates a singleGame.
	public static int[] convertToBinary(int decimal) {
		int len = 0;
		for (int i = decimal; i > 0; i /= 2) {
			len++;
			//System.out.print(len);  //debugging Statement
		}

		int[] bit = new int[len];
		int index = 0;
		for (int i = decimal; i > 0; i /= 2) {
			if ((i % 2) != 0) {
				bit[index] = 1;
			} else {
				bit[index] = 0;
			}
			index++;
		}
		//System.out.print(Arrays.toString(bit));  //debugging Statement
		return bit;
	}

	// Method simulates a playoff series.
	public static void printBinaryArray(int[] binary) {
		for (int i = binary.length -1; i >= 0; i--) {
			System.out.print(binary[i]);
		}
	
	}
}
