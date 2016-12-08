/* Created by: Stephen A. Apolinar
   Date: 12/072016 */
// import the Abstract Window Toolkit package. */
import java.awt.*;
import java.util.*;

/* The beginning of every java program includes a class. */
public class Project3 {
	// Class Constant variables
	public static final int PANEL_WIDTH = 600;
	public static final int PANEL_HEIGHT = 400;
	public static final int PATROL_Y = PANEL_HEIGHT - 50;
	public static final int PATROL_WIDTH = 31;
	public static final int PATROL_HEIGHT = 17;
	public static final int ENEMY_Y = 20;
	public static final int ENEMY_WIDTH = 36;
	public static final int ENEMY_HEIGHT = 21;
	public static final int PATROL_MISSILE_LENGTH = 10;
	public static final int PATROL_MISSILE_MAX = 5;
	public static final int ENEMY_MISSILE_LENGTH = 5;

	// keyboard keys
	public static final int RIGHT_ARROW = 39;
	public static final int LEFT_ARROW = 37;
	public static final int UP_ARROW = 38;

	// non-Constant class variables
	public static int patrolX = PANEL_WIDTH - PATROL_WIDTH -5;
	public static int enemyX = 1;
	public static int enemyMoveAmount;
	public static double changeDirection;
	public static int patrolMissileX;
	public static int patrolMissileY = 0;;
	public static int[] patrolMissileX;
	public static int[] patrolMissileY;
	public static int enemyMissileX;
	public static int enemyMissileY = 400;
	public static int hit = 0;

	// messages
	public static final String START_MESSAGE = "Push Space Bar to Start";
	public static final String HEADING_MESSAGE = "Project 3 part 1 by Stephen A. Apolinar";
	
	// message positions
	public static final int HEADING_X = 10;
	public static final int HEADING_Y = 15;
	public static final int MESSAGE_X = 10;
	public static final int MESSAGE_Y = PANEL_HEIGHT - 10;
	
	// boolean class variables
	public static boolean running = false;
	public static boolean enemyHit = false;
	public static boolean patrolHit = false;
	
	public static Random random = new Random();
	
	// Main method
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGHT);
		Graphics g = panel.getGraphics( );
		g.drawString("Project 3 by Stephen A. Apolinar", 10, 15);
		
		int[] patrolMissileX = new int[PATROL_MISSILE_MAX];
		int[] patrolMissileY = new int[PATROL_MISSILE_MAX];

		//gameOn = false;
		restart(g);
		//running = false;
		showMessage(g, START_MESSAGE, Color.BLACK);
		startGame(panel, g);
	}
	// method call to print statement at start of program
	public static void showMessage(Graphics g, String message, Color c) {
		g.setColor(c);
		g.drawString(message, MESSAGE_X, MESSAGE_Y);
	}
	// method call to print Heading Message
	public static void showHeading(Graphics g, String message, Color c) {
		g.setColor(c);
		g.drawString(message, HEADING_X, HEADING_Y);
	}

	// submethod calls startGame, which makes calls to other
	// submethods within the program.
	public static void startGame(DrawingPanel panel, Graphics g) {
		drawPatrol(g, Color.GREEN);
		while (true) {
			moveEnemyShipAndDraw(g);
			moveEnemyMissileAndDraw(g);
			//changeDirection = random.nextDouble();
			handleKeys(panel, g);
			movePatrolMissileAndDraw(g);
			// changes boolean class variable value,
			// causing Enemy vehicle method to execute
			// else if code.
			detectHit();
			if (hit == 1) {
				enemyHit = true;
			} else if (hit == -1) {
				patrolHit = true;
			}
			panel.sleep(50);	
		}
	}
	// method resets program with space bar push
	public static void restart(Graphics g) {
		running = true;
		int[] patrolMissileX = {0, 0, 0, 0, 0};
		int[] patrolMissileY = {0, 0, 0, 0, 0};
		hit = 0;
		enemyHit = false;
		patrolHit = false;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
		showHeading(g, HEADING_MESSAGE, Color.BLACK);
		patrolMissileY = 0;
		enemyMissileX = 400;
		enemyX = 0;
		patrolX = PANEL_WIDTH - PATROL_WIDTH -5;
		drawPatrol(g, Color.GREEN);
	}

	// submethod calls Patrol vehicle
	public static void drawPatrol(Graphics g, Color c) {
		// All variables for method are in Class Constant & 
		// (non Constant) class variables.
		// calls method to set color, and sends in parameter.
		g.setColor(c);
		// calls method to fill square, uses variables within
		//  the scope of submethod.
		g.fillRect(patrolX, PATROL_Y, PATROL_WIDTH, PATROL_HEIGHT);
	}

	// submethod calls Enemy ship
	public static void moveEnemyShipAndDraw(Graphics g) {
		// variable for pixel shit of Enemy vehicle.	

		// code sequence for moving Enemy vehicle.
		if (enemyHit == false && patrolHit == false) {
			if (enemyX <= 1) {
				enemyMoveAmount = 1;
				g.setColor(Color.WHITE);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
				enemyX = enemyX + enemyMoveAmount;
				g.setColor(Color.RED);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
			} else if (enemyX >= PANEL_WIDTH - ENEMY_WIDTH) {
				enemyMoveAmount = -1;
				g.setColor(Color.WHITE);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
				enemyX = enemyX + enemyMoveAmount;
				g.setColor(Color.RED);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
			}
			
			if (random.nextDouble() < .02) {
				enemyMoveAmount = -1;
				g.setColor(Color.WHITE);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
				enemyX = enemyX + enemyMoveAmount;
				g.setColor(Color.RED);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
				if (enemyMissileY == 400 && running == false) {
				enemyMissileX = enemyX + (ENEMY_WIDTH/2);
				enemyMissileY = (ENEMY_Y + ENEMY_HEIGHT) + 1;
				}
			} else if (random.nextDouble() < .02) {
				enemyMoveAmount = 0;
				g.setColor(Color.WHITE);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
				enemyX = enemyX + enemyMoveAmount;
				g.setColor(Color.RED);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
				if (enemyMissileY == 400 && running == false) {
				enemyMissileX = enemyX + (ENEMY_WIDTH/2);
				enemyMissileY = (ENEMY_Y + ENEMY_HEIGHT) + 1;
				}
			} else if (random.nextDouble() < .02) {
				enemyMoveAmount = 1;
				g.setColor(Color.WHITE);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
				enemyX = enemyX + enemyMoveAmount;
				g.setColor(Color.RED);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
				if (enemyMissileY == 400 && running == false) {
				enemyMissileX = enemyX + (ENEMY_WIDTH/2);
				enemyMissileY = (ENEMY_Y + ENEMY_HEIGHT) + 1;
				}
			}
			g.setColor(Color.WHITE);
			g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
			enemyX = enemyX + enemyMoveAmount;
			g.setColor(Color.RED);
			g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
		} else if (enemyHit == true) {
			// else if statement executes vehicle stop,
			// changes vehicle to black, and prints.
			g.setColor(Color.BLACK);
			g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
			g.drawString("ENEMY SHIP HIT!", PANEL_WIDTH/2, PANEL_HEIGHT/2);
		} 
	}

	// submethod calls Arrow keys for control of Patrol vehicle
	public static void handleKeys(DrawingPanel panel, Graphics g) {
		// variable for pixel shift of Patrol vehicle
		int deltaX = 3;
		// declares a variable as an integer that is equal to 
		// the return value of panel.getKeyCode object.
		int arrowKeys = panel.getKeyCode();
		// If return KeyCode is 0 nothing happens.
		if (arrowKeys == 0) {
			if (patrolHit == true) {
				//patrolX = patrolX + 0;
				g.setColor(Color.BLACK);
				g.fillRect(patrolX, PATROL_Y, PATROL_WIDTH, PATROL_HEIGHT);
				g.drawString("PATROL SHIP HIT!", PANEL_WIDTH/2, PANEL_HEIGHT/2);
			}
		return;
		}
		if (arrowKeys == ' ') {
			restart(g);
			running = false;
		}
		
		if (patrolHit == false && enemyHit == false) {
			// If return KeyCode is Right_ARROW, vehicle moves right
			if (arrowKeys == RIGHT_ARROW) {
				g.setColor(Color.WHITE);
				g.fillRect(patrolX, PATROL_Y, PATROL_WIDTH, PATROL_HEIGHT);
				patrolX = patrolX + deltaX;
				g.setColor(Color.GREEN);
				g.fillRect(patrolX, PATROL_Y, PATROL_WIDTH, PATROL_HEIGHT);
				// Prevents vehicle from running off screen
				if (patrolX >= PANEL_WIDTH - PATROL_WIDTH) {
					g.setColor(Color.WHITE);
					g.fillRect(patrolX, PATROL_Y, PATROL_WIDTH, PATROL_HEIGHT);
					patrolX = (PANEL_WIDTH - PATROL_WIDTH) - 3;
					g.setColor(Color.GREEN);
					g.fillRect(patrolX, PATROL_Y, PATROL_WIDTH, PATROL_HEIGHT);
				}
			}
			// If return KeyCode is Left_ARROW, vehicle moves left
			if (arrowKeys == LEFT_ARROW) {
				g.setColor(Color.WHITE);
				g.fillRect(patrolX, PATROL_Y, PATROL_WIDTH, PATROL_HEIGHT);
				patrolX = patrolX - deltaX;
				g.setColor(Color.GREEN);
				g.fillRect(patrolX, PATROL_Y, PATROL_WIDTH, PATROL_HEIGHT);
				// Prevents vehicle from running off screen
				if (patrolX <= 0) {
					g.setColor(Color.WHITE);
					g.fillRect(patrolX, PATROL_Y, PATROL_WIDTH, PATROL_HEIGHT);
					patrolX = 3;
					g.setColor(Color.GREEN);
					g.fillRect(patrolX, PATROL_Y, PATROL_WIDTH, PATROL_HEIGHT);
				}
			}
			// KeyCode must return UP_ARROW, and patrolMissileY == 0,
			// in order to set parameter to fire missile.  This double 
			// requirement test ensures one missile fires at a time.
			if (arrowKeys == UP_ARROW && patrolMissileY == 0) {
				// initializes missile fire position at center, and
				// in front of vehicle.
				patrolMissileX = patrolX + (PATROL_WIDTH/2);
				patrolMissileY = PATROL_Y - 11;
			}
		} else if (patrolHit == true) {
			//patrolX = patrolX + 0;
			g.setColor(Color.BLACK);
			g.fillRect(patrolX, PATROL_Y, PATROL_WIDTH, PATROL_HEIGHT);
			g.drawString("PATROL SHIP HIT!", PANEL_WIDTH/2, PANEL_HEIGHT/2);
		} 
	}

	// submethod for missile movement rules, and movement sequence.
	public static void movePatrolMissileAndDraw(Graphics g, int[] patrolMissileX[i],int[] patrolMissileY[i]) {
		// variable for pixel shift of missile up the screen
		int deltaY = 5;
		// If patrolMissileY is greater than 0, code sequence for
		// missile travel up the screen.
		if (patrolMissileY > 0) {
			g.setColor(Color.WHITE);
			g.drawLine(patrolMissileX, patrolMissileY, patrolMissileX, patrolMissileY
				       	- PATROL_MISSILE_LENGTH);
			patrolMissileY = patrolMissileY - deltaY;
			g.setColor(Color.BLACK);
			g.drawLine(patrolMissileX, patrolMissileY, patrolMissileX, patrolMissileY
				       	- PATROL_MISSILE_LENGTH);
		// else if patrolMissileY is 0, or negative, draw in 
		// white. Then reinitialize to 0.
		} else if (patrolMissileY <= 0) {
			g.setColor(Color.WHITE);
			g.drawLine(patrolMissileX, patrolMissileY, patrolMissileX, patrolMissileY
				       	- PATROL_MISSILE_LENGTH);
			patrolMissileY = 0;
		}
	}

	public static void moveEnemyMissileAndDraw(Graphics g) {
		// variable for pixel shift of missile up the screen
		int deltaY = 5;
		// If patrolMissileY is greater than 0, code sequence for
		// missile travel up the screen.
		if (enemyMissileY < 400) {
			g.setColor(Color.WHITE);
			g.drawLine(enemyMissileX, enemyMissileY, enemyMissileX, enemyMissileY
				       	+ ENEMY_MISSILE_LENGTH);
			enemyMissileY = enemyMissileY + deltaY;
			g.setColor(Color.RED);
			g.drawLine(enemyMissileX, enemyMissileY, enemyMissileX, enemyMissileY
				       	+ ENEMY_MISSILE_LENGTH);
		// else if patrolMissileY is 0, or negative, draw in 
		// white. Then reinitialize to 0.
		} else if (enemyMissileY >= 400) {
			g.setColor(Color.WHITE);
			g.drawLine(patrolMissileX, patrolMissileY, patrolMissileX, patrolMissileY
				       	- PATROL_MISSILE_LENGTH);
			enemyMissileY = 400;
		}
	}

	// submethod for Detecting a hit on Enemy ship.
	public static int detectHit() {
		// Used and integer return for logic test.
		// You may link multiple test values within an If statement.
		if (patrolMissileY >= ENEMY_Y && patrolMissileY <= (ENEMY_Y + ENEMY_HEIGHT)
			       	&& patrolMissileX >= enemyX && patrolMissileX <= (enemyX +
				       	ENEMY_WIDTH)) {
			// if all test values are true the variable changes boolean value.
			hit = 1;
		} else if (enemyMissileY >= PATROL_Y && enemyMissileY <= (PATROL_Y + PATROL_HEIGHT)
			       	&& enemyMissileX >= patrolX && enemyMissileX <= (patrolX +
				       	PATROL_WIDTH)) {
			// if all test values are true the variable changes boolean value.
			hit = -1;
		} else {
			hit = 0;
		} return hit;
	}

	// submethod for available missiles
	public static int getEmptyPatrolMissileIndex() {
		for (int i = 0; i < patrolMissileY.length; i++) {
			if (patrolMissileY[i] <= 0) {
				return patrolMissileY[i];
			} else {
				return -1;
			}
		}
	}

	public static void movePatrolMissileAndDraw(Graphics g) {
		int patrolIndex = getEmptyPatrolMissileIndex();
		if (patrolIndex != -1) {
			patrolMissileX[patrolIndex] = patrolMissileX;
			patrolMissileY[patrolIndex] = patrolMissileY;
		}
	}
}
