package SnakeProject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game implements KeyListener{
	
	private JFrame window;
	private Snake mainSnake;
	private SnakeFood food;
	private Graphics graphics;
	
	// JFrame window dimensions, static so there is only one copy of the variable, final so it is constant 
	public static final int windowHeight = 30;
	public static final int windowWidth = 30;		
	public static final int gameDimensions = 20;
	
	
	public Game() {
		window = new JFrame();
		mainSnake = new Snake();
		food = new SnakeFood(mainSnake);
		graphics = new Graphics(this);
		window.add(graphics);
		window.setTitle("Mehtab's First Project: Snake Game");
		// title - the title to be displayed in the frame's border. A null value is treated as an empty string, "".
		/*
		 *  now we need to set the size of the frame but... it is good programming practice to create
		 *  variables for the height and width so if we need to change them, we only have to change them 
		 *  from one place. -> Line 11 - 14
		 */
		window.setVisible(true);
		//Shows or hides this Window depending on the value of parameter b, in my case its my only window therefore true.
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * The setDefaultCloseOperation() method is used to specify one of several options for the close button. 
		 * Use one of the following constants to specify your choice:
		 * JFrame.EXIT_ON_CLOSE — Exit the application.
		 * JFrame.HIDE_ON_CLOSE — Hide the frame, but keep the application running.
		 * JFrame.DISPOSE_ON_CLOSE — Dispose of the frame object, but keep the application running.
		 * JFrame.DO_NOTHING_ON_CLOSE — Ignore the click.
		 * If you forget to call setDefaultCloseOperation() you will get JFrame.HIDE_ON_CLOSE by default. 
		 * This can be frustrating, because it looks like you have "killed" the program, but it keeps on running, and you see no frame.
		 */
		
		
	}
	
	public void start() {
		graphics.state = "RUNNING";
	}
	
	public void update() {
		if(graphics.state == "RUNNING") {
			if(checkFoodCollision()) {
				mainSnake.grow();
				food.random_spawn(mainSnake);
			}
			else if(checkWallCollision() || checkSelfCollision()) {
				graphics.state = "END";
						
			}
			else {
				mainSnake.move();
			}
		}
	}
	
	private boolean checkWallCollision() {
		if(mainSnake.getX() < 0 || mainSnake.getX() >= windowWidth * gameDimensions
				|| mainSnake.getY() < 0 || mainSnake.getY() >= windowHeight * gameDimensions) {
			return true;
		}
		return false;
	}

	private boolean checkFoodCollision() {
		if(mainSnake.getX() == food.getX() * gameDimensions && mainSnake.getY() == food.getY() * gameDimensions) {
			return true;
		}
		return false;
	}
	
	private boolean checkSelfCollision() {
		for(int i = 1; i < mainSnake.getBody().size(); i++) { // arrayList is .size, array is .length
			if(mainSnake.getX() == mainSnake.getBody().get(i).x &&
				mainSnake.getY() == mainSnake.getBody().get(i).y) {
					return true;
			}
		}
		return false;
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) { // only one that I will be using, every time I press a key this function will be called and its code will execute
		int keyCode = e.getKeyCode();
		
		
		if(graphics.state == "RUNNING") {
			if (keyCode == KeyEvent.VK_W) {
				// snake will go up
				mainSnake.up();
			}
			else if (keyCode == KeyEvent.VK_A) {
				// snake will go left
				mainSnake.left();
			}
			else if (keyCode == KeyEvent.VK_S) {
				// snake will go down
				mainSnake.down();
			}
			else /*(keyCode == KeyEvent.VK_D)*/ {
				// snake will go right
				mainSnake.right();
			}
		}
		
		else {
			this.start();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public JFrame getWindow() {
		return window;
	}


	public void setWindow(JFrame window) {
		this.window = window;
	}


	public Snake getMainSnake() {
		return mainSnake;
	}


	public void setMainSnake(Snake mainSnake) {
		this.mainSnake = mainSnake;
	}


	public SnakeFood getFood() {
		return food;
	}


	public void setFood(SnakeFood food) {
		this.food = food;
	}

}
