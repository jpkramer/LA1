import java.awt.*;

/**
 * Ellipse.java
 * Class for an ellipse.
 * 
 * @author Tom Cormen
 * @author Jonathan Kramer
 * @see Shape
 */

public class Ellipse extends Shape {
	private Point firstPoint, secondPoint;
	
	/**
	 * Constructor that sets the color and initial point of the shape
	 * 
	 * @param c
	 * @param p1
	 */
	public Ellipse(Color c, Point p1) {
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
	 * fills in an oval based on shape dimensions
	 */
	public void drawShape(Graphics page) {
		page.fillOval(getTopLeft().x, getTopLeft().y, getWidth(), getHeight());
	}		
	
	/**
	 * uses pointInEllipse method to determine if the shape contains a point
	 */
	public boolean containsPoint(Point p) {
		return pointInEllipse(p,getTopLeft().x,getTopLeft().y,getWidth(),getHeight());
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
	
  // Helper method that returns whether Point p is in an Ellipse with the given
  // top left corner and size.
  private static boolean pointInEllipse(Point p, int left, int top, int width,
      int height) {
    double a = width / 2.0;			// half of the width
    double b = height / 2.0;		// half of the height
    double centerx = left + a;	// x-coord of the center
    double centery = top + b;		// y-coord of the center
    double x = p.x - centerx;		// horizontal distance between p and center
    double y = p.y - centery;		// vertical distance between p and center

    // Now we just apply the standard geometry formula.
    // (See CRC, 29th edition, p. 178.)
    return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
  }
}
