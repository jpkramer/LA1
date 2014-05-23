/**
 * AddEllipse.java
 * 
 * subclass of Command that creates an Ellipse shape object upon the press and drag of a mouse
 * 
 * @author Jonathan Kramer
 */

import java.awt.Point;

public class AddEllipse extends Command {
	private Ellipse myEllipse;

  public void executePress(Point p, Drawing dwg) { 
  	myEllipse = new Ellipse(dwg.getColor(),p);
  	dwg.add(myEllipse);
  	
  }
  public void executeDrag(Point p, Drawing dwg) {
  	myEllipse.updateSize(p); //creates a new Ellipse based on new mouse location
  	
  }
  
}
