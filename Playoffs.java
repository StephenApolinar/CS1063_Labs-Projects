import java.util.*;

public class Playoffs {
	// Class Constant variables
	public static final Scanner CONSOLE = new Scanner(System.in);
	
	// non-Constant class variables
	public static int percentChance;

	// boolean class variables
	public static boolean team1 = false;

	public static void main(String[] args){
		Random r = new Random();
		System.out.println("Lab 6 written by Stephen A. Apolinar on 11/15/2016");
		System.out.println();
		//percentChance = r.nextInt(100);
		
			
		//singleGame(r, percentChance);
		playoffs(r, percentChance);
		seriesIteration(r, percentChance);
		
	}

	public static int singleGame(Random r, int percentChance1) {
		//boolean team1 = false;

		if (percentChance1 < 51) {
			//System.out.println("Team 1 won single game matchup");
			return 0;
		} else {
			//System.out.println("Team 2 won single game matchup");
			return 1;
		}
	}

	public static int playoffs(Random r, int percentChance1) {
		//boolean team1 = false;
		int x = 0;
		int y = 0;
		while (x < 4 && y < 4) {
			percentChance = r.nextInt(100);
			//System.out.println(percentChance);
			if (singleGame(r, percentChance) == 0) {
				x ++;
			} else {
				y ++;
			}
		}
		
		System.out.println();
		if (x == 4) {
			//System.out.println("Team 1 won the playoff series");
			return 0;
		} else {
			//System.out.println("Team 2 won the playoff series");
			return 1;
		}
	}

	public static void seriesIteration(Random r, int percentChance1) {

		int k = 0;
		int l = 0;
		while (k < 10 + l && l < 10 + k ) {
			//percentChance = r.nextInt(100);
			//System.out.println(percentChance);
			if (playoffs(r, percentChance) == 0) {
				System.out.print("1");
				k ++;
			} else {
				System.out.print("2");
				l ++;
			}
		}
		
		//if (playoffs(r, percentChance) == 0) {
			//System.out.print("1");
		//} else {
			//System.out.print("2");
		//}

		System.out.println();
		if (k == 10 + l) {
			System.out.println("Team 1 won playoff series iteration");
		} else if (l == 10 + k) {
			System.out.println("Team 2 won playoff series iteration");
		}
	}	
}
