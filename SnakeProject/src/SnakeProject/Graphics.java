package SnakeProject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics extends JPanel implements ActionListener{

	private Timer t = new Timer(100, this);
	public String state;
	
	private Snake s;
	private SnakeFood f;
	private Game game;
	
	public Graphics(Game g) {
		t.start();
		state = "START";
		
		game = g;
		s = g.getMainSnake();
		f = g.getFood();
		
		// I need to add a keyListner to my game
		this.addKeyListener(g);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(java.awt.Graphics g) { // why did adding java.awt help? because I already have a class Graphics so it helps specify 
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g; // i used casting here! graphics has a higher hierarchy than Graphics2D in AWT class therefore i need to cast
		
		if(state == "START") {
			g2d.setColor(Color.black);
			g2d.drawString("Press Any Key", Game.windowWidth/2 * Game.gameDimensions - 40, Game.windowHeight/2 * Game.gameDimensions - 20);
		}
		
		else if (state == "RUNNING") {
			
			g2d.setColor(Color.black);
			g2d.fillRect(0, 0, Game.windowWidth * Game.gameDimensions, Game.windowHeight * Game.gameDimensions);
			
			// now food
			g2d.setColor(Color.red);
			g2d.fillRect(f.getX() * Game.gameDimensions, f.getY() * Game.gameDimensions, Game.gameDimensions, Game.gameDimensions);
			
			//now snake
			g2d.setColor(Color.blue);
			for(Rectangle r : s.getBody()) {
				g2d.fill(r);
			}
			
		}
		
		else {
			g2d.setColor(Color.black);
			g2d.drawString("Your Score: " + (s.getBody().size() - 3), Game.windowWidth/2 * Game.gameDimensions - 40, 
							Game.windowHeight/2 * Game.gameDimensions - 20);
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) { // must have this function for ActionListener to work
		repaint(); // calls paintComponent
		game.update();
		
	}
	
	/*
	 * actionListener work sort of to like frames, how each frame is needed to be "redrawn" each second.
	 */
	
	
	
	

}
