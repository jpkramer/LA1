import java.awt.*;

/**
 * Rect.java
 * Class for a rectangle.
 * 
 * Written by THC for CS 10 Lab Assignment 1.
 *
 * @author Tom Cormen
 * @author Jonathan Kramer
 * @see Shape
 */
public class Rect extends Shape {
private Point firstPoint, secondPoint; 
	
	/**
	 * Constructor that sets the color and initial point of the shape
	 *	 
	 * @param c
	 * @param p1
	 */
	public Rect(Color c, Point p1) {
		super(c);
		firstPoint = p1;
		secondPoint = new Point(firstPoint.x,firstPoint.y);
	}
	
	/** 
	 * finds top left point
	 */
	public Point getTopLeft(){
		return new Point(Math.min(firstPoint.x, secondPoint.x), Math.min(firstPoint.y, secondPoint.y));
	}
	
	/**
	 * fills in Rect based on shape dimensions
	 */
	public void drawShape(Graphics page) {
		page.fillRect(getTopLeft().x, getTopLeft().y, getWidth(), getHeight());
	}		
	
	/**
	 * checks if a point is within the bounds of the Rect
	 */
	public boolean containsPoint(Point p) {
		return (p.x > getTopLeft().x) && (p.x < (getTopLeft().x + getWidth())) && (p.y > getTopLeft().y) && (p.y < (getTopLeft().y + getHeight()));
	}
	
	/**
	 * moves the location of the two major points to move the entire shape
	 */
	public void move(int deltaX, int deltaY) {
		firstPoint.x += deltaX;
		firstPoint.y += deltaY;
		secondPoint.x += deltaX;
		secondPoint.y += deltaY;
	}

	/**
	 * finds the center of the shape using the height, width, and coordinates of the top left corner
	 */
	public Point getCenter() {
		int xCenter = getTopLeft().x + (getWidth()/2);
		int yCenter = getTopLeft().y + (getHeight()/2);
		Point Center = new Point(xCenter,yCenter);
		return Center;
	}
	
	/**
	 * Can be used to modify the size of the shape by adjusting the second major point
	 */
	public void updateSize(Point p) {
		secondPoint = p;
	}
	
	/**
	 * returns the width of the shape
	 */
	public int getWidth() {
		return Math.abs(secondPoint.x-firstPoint.x);
	}
	
	/**
	 * returns the height of the shape
	 */
	public int getHeight() {
		return Math.abs(secondPoint.y-firstPoint.y);
	}
	
	
}
