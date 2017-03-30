package pencil; 

import java.awt.Point;
/**
 * 
 * @author Vladimir Dudnic
 * @version 1.0
 */
public interface Tool
{ 
  /**
   * 
   * @return name of the tool.
   */
  String getName(); 
  
  /**
   * 
   * @param the_point is a point.
   */
  void startShape(Point the_point); 
  
  /**
   * 
   * @param the_point is a point.
   */
  void addPointToShape(Point the_point);
  
  /**
   * 
   * @param the_point is a point.
   */
  void endShape(Point the_point); 

}
