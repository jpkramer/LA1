/**
 * ColorCmd.java
 * 
 * Subclass of Command that takes a reference to a color object
 * Upon clicking a shape, its color changes to that color.
 * 
 * @author Jonathan Kramer
 */

import java.awt.Color;
import java.awt.Point;

public class ColorCmd extends Command {
	private Color myColor;
	
	/**
	 * Constructor that sets the instance variable myColor
	 */
	public ColorCmd(Color c) {
		myColor = c;
	}
	
	 public void executeClick(Point p, Drawing dwg) { 
		 if (dwg.getFrontmostContainer(p) != null) { //check to make sure there is a shape that contains the point
			 dwg.getFrontmostContainer(p).setColor(myColor);
		 }
	 }
}
