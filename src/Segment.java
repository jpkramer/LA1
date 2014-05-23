//Check for in box and distance to line is in tolerance

import java.awt.*;

/**
 * Segment.java
 * Class for a line segment.
 * 
 * Written by THC for CS 10 Lab Assignment 1.
 *
 * @author Tom Cormen
 * @author Jonathan Kramer
 * @see Shape
 */
public class Segment extends Shape {
	private Point firstPoint, secondPoint;
	
	/**
	 * Constructor that sets the color and initial point of the shape
	 * 
	 * @param c
	 * @param p1
	 */
	public Segment(Color c, Point p1) {
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
	 * draws a line based on coordinates of the two end points
	 */
	public void drawShape(Graphics page) {
		page.drawLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
	}		
	
	/**
	 * checks if a point is within a certain tolerance from the line
	 */
	public boolean containsPoint(Point p) {
		double tolerance = 3;
		return (distanceToPoint(p, firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y) < tolerance) && 
				almostContainsPoint(p, getTopLeft().x, getTopLeft().y, getTopLeft().x + getWidth(), getTopLeft().y + getHeight(), tolerance); 
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
	
  // Helper method that returns true if Point p is within a tolerance of a
  // given bounding box. Here, the bounding box is given by the coordinates of
  // its left, top, right, and bottom.
  private static boolean almostContainsPoint(Point p, int left, int top,
      int right, int bottom, double tolerance) {
    return p.x >= left - tolerance && p.y >= top - tolerance
        && p.x <= right + tolerance && p.y <= bottom + tolerance;
  }

  // Helper method that returns the distance from Point p to the line
  // containing a line segment whose endpoints are given.
  private static double distanceToPoint(Point p, int x1, int y1, int x2,
      int y2) {
    if (x1 == x2) // vertical segment?
      return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
    else if (y1 == y2) // horizontal segment?
      return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
    else {
      // Here, we know that the segment is neither vertical nor
      // horizontal.
      // Compute m, the slope of the line containing the segment.
      double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

      // Compute mperp, the slope of the line perpendicular to the
      // segment.
      double mperp = -1.0 / m;

      // Compute the (x, y) intersection of the line containing the
      // segment and the line that is perpendicular to the segment and that
      // contains Point p.
      double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
          / (mperp - m);
      double y = m * (x - x1) + y1;

      // Return the distance between Point p and (x, y).
      return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }
  }
}