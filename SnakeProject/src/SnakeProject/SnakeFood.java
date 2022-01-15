package SnakeProject;

import java.awt.Rectangle;

public class SnakeFood {
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int x;
	private int y;
	
	public SnakeFood(Snake player) {
		this.random_spawn(player);
	}
	
	public void random_spawn(Snake player) { // need to make sure this random location is not a location on the snake
		x = (int) (Math.random() * Game.windowWidth);
		y = (int) (Math.random() * Game.windowHeight);
		
		boolean onSnake = true;
		while(onSnake) {
			onSnake = false;
			
			x = (int) (Math.random() * Game.windowWidth);
			y = (int) (Math.random() * Game.windowHeight);
			for (Rectangle r : player.getBody()) { // this is called an enhanced for loop
				/*
				  	The usual way to step through all the elements of an array in order is with a "standard" for loop, for example,

					for (int i = 0; i < myArray.length; i++) {
					    System.out.println(myArray[i]);
					}
					The so-called enhanced for loop is a simpler way to do this same thing. (The colon in the syntax can be read as "in.")
					
					for (int myValue : myArray) {
					    System.out.println(myValue);
					}
				 */
				
				if (r.x == x && r.y == y) {
					onSnake = true;
				}
			}
		}
	}	
}
