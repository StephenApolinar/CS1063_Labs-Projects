public class PrintStars2b {
	public static void main(String[] args) {

		for (int line = 1; line <= 6; line++) {
			for (int space = 1; space <= (6 - 1 * line); space++) {
			// print a line using the current value of count
				System.out.print(" ");
			}
			for (int aster = 1; aster <= (-1 + 2 * line); aster++) {
				System.out.print("*");
			}
			System.out.println();
		}
	
	}
}
