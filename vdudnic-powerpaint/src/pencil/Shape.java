package pencil; 

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
/**
 * 
 * @author Vladimir Dudnic
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class Shape implements Serializable
{ 
  
  /**
   * 
   */
  protected Color my_color = Color.black; 
  
  /**
   * 
   */
  public Shape()
  {
     super();
  }
  /**
   * 
   * @param the_color is color for a shape.
   */
  public Shape(final Color the_color) 
  {
    my_color = the_color; 
  } 
  
  /**
   * 
   * @param the_color is color for a shape.
   */
  public void setColor(final Color the_color) 
  {
    my_color = the_color; 
  } 
  
  /**
   * 
   * @return my_color is color for a shape.
   */
  public Color getColor() 
  {
    return my_color; 
  }
  
  /**
   * 
   * @param the_g is graphics parameter.
   */
  public abstract void draw(Graphics the_g); 
}

