/**
 * MoveCmd.java
 * 
 * Subclass of Command that allows a shape to be moved around the canvas
 * 
 * @author Jonathan Kramer
 */

import java.awt.Point;

public class MoveCmd extends Command{
	private Shape myShape;
	private Point myCenter = new Point();
	private int difX;
	private int difY;
	
	/**
	 * relocates the center of the shape in proportion to the movement of the mouse
	 * calculates the distance between mouse and center
	 */
	 public void executePress(Point p, Drawing dwg) { 
		 
		 myShape = dwg.getFrontmostContainer(p); //always moves the front most shape
		 if (myShape != null) { //check to make sure there is a shape that contains the point 
			 myCenter.x = myShape.getCenter().x;
			 myCenter.y = myShape.getCenter().y;
			 difX = myCenter.x - p.x;
			 difY = myCenter.y - p.y;
		 }
	 }
	 
	 /**
	  * uses difX and difY to formulate what the new center of the shape should be set to
	  * this allows movement of the shape even if the shape is not being dragged by its geometric center
	  */
	 public void executeDrag(Point p, Drawing dwg) {	
		
		 if (myShape != null) { //check to make sure there is a shape that contains the point 
			 myCenter.x = p.x + difX;
			 myCenter.y = p.y + difY;
			 myShape.setCenter(myCenter); 
		 }
	 }
	 
	 
	 
}

