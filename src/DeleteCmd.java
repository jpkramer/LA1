/**
 * DeleteCmd.java
 * 
 * Subclass of Command that upon clicking a shape, deletes that shape
 * 
 * @author Jonathan Kramer
 */

import java.awt.Point;

public class DeleteCmd extends Command{

	 public void executeClick(Point p, Drawing dwg) { 
		 if(dwg.getFrontmostContainer(p) != null) {  //check to make sure there is a shape that contains the point
			 dwg.remove(dwg.getFrontmostContainer(p)); //always deletes front most shape
		 }
	 }
	
}
