/* Created by: Stephen A. Apolinar
   Date: 11/06/2016 */
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
	public static int patrolMissileY = 0;

	// messages
	public static final String START_MESSAGE = "Push Space Bar to Start";
	public static final String HEADING_MESSAGE = "Project 3 part 1 by Stephen A. Apolinar";
	
	// message positions
	public static final int HEADING_X = 10;
	public static final int HEADING_Y = 15;
	public static final int MESSAGE_X = 10;
	public static final int MESSAGE_Y = PANEL_HEIGHT - 10;
	// boolean class variables
	public static boolean hit = false;
	public static boolean running = false;
	
	public static Random random = new Random();
	
	// Main method
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGHT);
		Graphics g = panel.getGraphics( );
		g.drawString("Project 2 by Stephen A. Apolinar", 10, 15);
		
		//gameOn = false;
		restart(g);
		running = false;
		showMessage(g, START_MESSAGE, Color.BLACK);
		startGame(panel, g);
	}

	public static void showMessage(Graphics g, String message, Color c) {
		g.setColor(c);
		g.drawString(message, MESSAGE_X, MESSAGE_Y);
	}
	
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
			//changeDirection = random.nextDouble();
			handleKeys(panel, g);
			movePatrolMissileAndDraw(g);
			// changes boolean class variable value,
			// causing Enemy vehicle method to execute
			// else if code.
			if (detectHit() == true) {
				hit = true;
			}
			panel.sleep(50);	
		}
	}

	public static void restart(Graphics g) {
		running = true;
		hit = false;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
		showHeading(g, HEADING_MESSAGE, Color.BLACK);
		patrolMissileY = 0;
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
		//enemyMoveAmount = 1;
		// code sequence for moving Enemy vehicle must be 
		// performed within If statement, inorder to 
		// execute the stop sequence in Else If statement.
		if (hit == false) {
			
			//System.out.println(changeDirection);
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
			//changeDirection = random.nextDouble;
			if (random.nextDouble() < .02) {
				enemyMoveAmount = -1;
				g.setColor(Color.WHITE);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
				enemyX = enemyX + enemyMoveAmount;
				g.setColor(Color.RED);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
			} else if (random.nextDouble() < .02) {
				enemyMoveAmount = 0;
				g.setColor(Color.WHITE);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
				enemyX = enemyX + enemyMoveAmount;
				g.setColor(Color.RED);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
			} else if (random.nextDouble() < .02) {
				enemyMoveAmount = 1;
				g.setColor(Color.WHITE);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
				enemyX = enemyX + enemyMoveAmount;
				g.setColor(Color.RED);
				g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
			}
			g.setColor(Color.WHITE);
			g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
			enemyX = enemyX + enemyMoveAmount;
			g.setColor(Color.RED);
			g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
			// prints statement if vehicle travels off screen.
			/*if (enemyX <= 1) {
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
			}*/
		} else if (hit == true) {
			// else if statement executes vehicle stop,
			// changes vehicle to black, and prints.
			g.setColor(Color.BLACK);
			g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
			g.setColor(Color.GREEN);
			g.drawString("Enemy ship hit!", 5, 395);
		}
		// prints statement if vehicle travels off screen.
		/*if (enemyX < 1) {
			enemyMoveAmount = 1;
			g.setColor(Color.WHITE);
			g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
			enemyX = enemyX + enemyMoveAmount;
			g.setColor(Color.RED);
			g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
		}
		if (enemyX >= PANEL_WIDTH - ENEMY_WIDTH) {
			enemyMoveAmount = -1;
			g.setColor(Color.WHITE);
			g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
			enemyX = enemyX + enemyMoveAmount;
			g.setColor(Color.RED);
			g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
		}*/
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
			return;
		}
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

		if (arrowKeys == ' ') {
			restart(g);
		}

	}

	// submethod for missile movement rules, and movement sequence.
	public static void movePatrolMissileAndDraw(Graphics g) {
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
	
	// submethod for Detecting a hit on Enemy ship.
	public static boolean detectHit() {
		// Must declare boolean variable within the method for return value, 
		// and initialze the variable to the opposite boolean value of 
		// the value desired from method.  To ensure the method is executing
		// correctly.
		boolean enemyHit = false;
		// You may link multiple test values within an If statement.
		if (patrolMissileY >= ENEMY_Y && patrolMissileY <= (ENEMY_Y + ENEMY_HEIGHT)
			       	&& patrolMissileX >= enemyX && patrolMissileX <= (enemyX +
				       	ENEMY_WIDTH)) {
			// if all test values are true the variable changes boolean value.
			enemyHit = true;
		} return enemyHit;
	}
}
