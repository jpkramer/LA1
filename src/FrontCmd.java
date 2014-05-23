/**
 * FrontCmd.java
 * 
 * subclass of Command that moves upon a click, moves the front most object 
 * containing the mouse point to the front to the linked list, thus painting it in front of every other object 
 * 
 * @author Jonathan Kramer
 */

import java.awt.Point;

public class FrontCmd extends Command {

	public void executeClick(Point p, Drawing dwg) { 
		 if (dwg.getFrontmostContainer(p) != null) { //check to make sure there is a shape that contains the point
			 dwg.moveToFront(dwg.getFrontmostContainer(p));
		 }
	}
	
}
