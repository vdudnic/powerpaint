package pencil; 

import java.awt.Graphics;
import java.awt.Point;
/**
 * 
 * @author Vladimir Dudnic
 * @version 1.0
 */
public class PencilTool extends AbstractTool 
{ 
  /**
   * 
   */
  protected Stroke my_current_stroke; 
  /**
   * 
   * @param the_canvas is canvas for pencil. 
   * @param the_name is name of the tool.
   */
  public PencilTool(final PencilCanvas the_canvas, final String the_name) 
  {
    super(the_canvas, the_name);
  }
  
  /**
   * @param the_point is start point.
   */
  public void startShape(final Point the_point)
  {
    my_current_stroke = new Stroke(my_canvas.getCurColor()); 
    my_current_stroke.addPoint(the_point); 
  }
  /**
   * @param the_point is point of the shape.
   */
  public void addPointToShape(final Point the_point) 
  {
    if (my_current_stroke != null) 
    { 
      my_current_stroke.addPoint(the_point); 
      final Graphics g = my_canvas.getGraphics();
      g.setColor(my_canvas.getCurColor());
      g.drawLine(my_canvas.my_x, my_canvas.my_y, the_point.x, the_point.y); 
    }
  }
  /**
   * @param the_point is end point.
   */
  public void endShape(final Point the_point) 
  {
    if (my_current_stroke != null) 
    { 
      my_current_stroke.addPoint(the_point); 
      my_canvas.addShape(my_current_stroke); 
    }
  }

 

}
