import java.util.*;
import java.awt.*; 

public class RandomWalk {
	// Class Constant variables
	public static final Scanner CONSOLE = new Scanner(System.in);
	
	// non-Constant class variables
	public static int percentChance;

	// boolean class variables
	public static boolean stopWalk = false;

	public static void main(String[] args){
		Random r = new Random();
		
		System.out.println("Lab 7 written by Stephen A. Apolinar on 11/22/2016");
		System.out.println();

		int radius1;
	
		// get coordinates for circles, and each radius from user through keyboard
		System.out.println("Enter the radius of the circle.");
		radius1 = CONSOLE.nextInt();
		System.out.println();
		System.out.println("You chose a circle with a radius = " + radius1);
		int sizePanel = (2 * radius1) + 20;
		int x1 = sizePanel/2;
		int y1 = sizePanel/2;
		System.out.println();
		DrawingPanel panel = new DrawingPanel(sizePanel, sizePanel);
		Graphics g = panel.getGraphics();	
		CircleLocationSize(g, x1, y1, radius1);
		int x_i = x1;
		int y_i = y1;
		int s = 0;
		// Random Walk code
		while (stopWalk == false) {
			int step = r.nextInt(4);
			if (step == 0) { 	//Step Left
				g.drawLine(x_i, y_i, x_i - 1, y_i);
				x_i--;
			} else if (step == 1) { //Step Right
				g.drawLine(x_i, y_i, x_i + 1, y_i);
				x_i++;
			} else if (step == 2) { // Step Up
				g.drawLine(x_i, y_i, x_i, y_i + 1);
				y_i++;
			} else { 		// Step Down
				g.drawLine(x_i, y_i, x_i, y_i -1);
				y_i--;
			}
			panel.sleep(1);
			s++;
			System.out.println("Step: " + s);
			System.out.println("x_i = " + x_i + ", y_i = " + y_i);
			keepWalking(x1, y1, radius1, x_i, y_i);
		}	
	}

	// method for location and filling circles
	public static void CircleLocationSize(Graphics g, int LocX1, int LocY1, 
			int RadOfCir) {
		// declare variables
		int diameter;
	
		// square radiaus to find the diameter of circle for input into drawOval 
		// method.
		diameter = 2 * RadOfCir;
	
		// fillOval method
		g.setColor(Color.blue);
		g.drawOval(LocX1-RadOfCir, LocY1-RadOfCir, diameter, diameter);
	
  	}

	public static boolean keepWalking(int x_Center, int y_Center, int RadOfCir, int x_j, 
			int y_j) {
		double inputEq2 = Math.pow((x_j - x_Center), 2) + Math.pow((y_j - 
					y_Center), 2);
		double locOfWalkFromCenter = Math.sqrt(inputEq2);
		System.out.println(locOfWalkFromCenter);

		if (locOfWalkFromCenter > RadOfCir) {
			stopWalk = true;
		} return stopWalk;
	}

	/*public static int playoffs(Random r, int percentChance1) {
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
	}*/	
}
