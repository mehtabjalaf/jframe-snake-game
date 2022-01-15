package SnakeProject;

import java.awt.Rectangle;
/*
 *  java awt stand for Abstract Window Toolkit
 *  it is an api to develop GUI or window based apps
 *  api stands for application program interface 
 *  awt components are platform dependent 
 *  		which means that the look and feel of the interface is OS dependent 
 *  
 */
import java.util.ArrayList;

public class Snake {
	
	//snake will be an arrayList of rectangles
	
	private ArrayList<Rectangle> body;
	
	private int w = Game.windowWidth;
	private int h = Game.windowHeight;
	private int d = Game.gameDimensions;
	
	private String move; // will do nothing, up, down, left, right
	
	public Snake() {
		body = new ArrayList<>();
		
		Rectangle holder = new Rectangle(Game.gameDimensions, Game.gameDimensions);
		holder.setLocation(Game.windowWidth / 2 * Game.gameDimensions, Game.windowHeight / 2 * Game.gameDimensions);
		// setLocation sets the rectangle in place on the frame, the location is x,y pixels of the parameters 
		body.add(holder);
		// Appends the specified element to the end of this list.
		
		holder = new Rectangle(Game.gameDimensions, Game.gameDimensions); // creating a new rectangle
		holder.setLocation((w/2 - 1) * d, (h/ 2) *d); // we need to offset this rectangle by one to the left
		
		holder = new Rectangle(Game.gameDimensions, Game.gameDimensions); // creating a new rectangle
		holder.setLocation((w/2 - 2) * d, (h/ 2) *d); // we need to offset this rectangle by one to the left
						
		move = "NOTHING";
		
	}
	
	public void move() {
		if(move != "NOTHING") {
			Rectangle first = body.get(0);
			Rectangle holder = new Rectangle(Game.gameDimensions, Game.gameDimensions);
			
			if(move == "UP") {
				holder.setLocation(first.x, first.y - Game.gameDimensions); // one tile up
			}
			else if(move == "DOWN") {
				holder.setLocation(first.x, first.y + Game.gameDimensions); // one tile down

			}
			else if(move == "LEFT") {
				holder.setLocation(first.x - Game.gameDimensions, first.y); // one tile left

			}
			else {
				holder.setLocation(first.x + Game.gameDimensions, first.y); // one tile right

			}
			
			body.add(0, holder);
			body.remove(body.size()-1); // removes last element
			
		}
	}
	
	
	public void grow() {
		Rectangle first = body.get(0);
		Rectangle holder = new Rectangle(Game.gameDimensions, Game.gameDimensions);
		
		if(move == "UP") {
			holder.setLocation(first.x, first.y - Game.gameDimensions); // one tile up
		}
		else if(move == "DOWN") {
			holder.setLocation(first.x, first.y + Game.gameDimensions); // one tile down

		}
		else if(move == "LEFT") {
			holder.setLocation(first.x - Game.gameDimensions, first.y); // one tile down

		}
		else {
			holder.setLocation(first.x + Game.gameDimensions, first.y); // one tile down

		}
		
		body.add(0, holder);
		//body.remove(body.size()-1); // removes last element - grow function DOES NOT REMOVE
	}
	
	public int getX() {
		return body.get(0).x;
	}
	
	public int getY() {
		return body.get(0).y;
	}
	
	public ArrayList<Rectangle> getBody() {
		return body;
	}

	public void setBody(ArrayList<Rectangle> body) {
		this.body = body;
	}
	
	public void up() {
		if (move != "DOWN") {
			move = "UP";
		}
	}
	public void down() {
		if (move != "UP") {
			move = "DOWN";
		}
	}
	public void left() {
		if (move != "RIGHT") {
			move = "LEFT";
		}
	}
	public void right() {
		if (move != "LEFT") {
			move = "RIGHT";
		}
	}
	

}
