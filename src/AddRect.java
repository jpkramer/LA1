/**
 * AddRect.java
 * 
 * subclass of Command that creates a Rect shape object upon the press and drag of a mouse
 * 
 * @author Jonathan Kramer
 */

import java.awt.Point;

public class AddRect extends Command {
	private Rect myRect; 

  public void executePress(Point p, Drawing dwg) { 
  	myRect = new Rect(dwg.getColor(),p);
  	dwg.add(myRect);
  	
  }
  public void executeDrag(Point p, Drawing dwg) {
  	myRect.updateSize(p); //creates a new Rect based on new mouse location
  	
  }
  
}
