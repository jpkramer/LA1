/**
 * AddSegment.java
 * 
 * subclass of Command that creates a Segment shape object upon the press and drag of a mouse
 * 
 * @author Jonathan Kramer
 */

import java.awt.Point;

public class AddSegment extends Command {
	private Segment mySegment; 

  public void executePress(Point p, Drawing dwg) { 
  	mySegment = new Segment(dwg.getColor(),p);
  	dwg.add(mySegment);
  	
  }
  public void executeDrag(Point p, Drawing dwg) {
  	mySegment.updateSize(p); //creates a new Segment based on new mouse location
  	
  }
}
