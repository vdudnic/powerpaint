package pencil; 

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
/**
 * 
 * @author Vladimir
 * @version 1.0
 */
public class PencilCanvasListener implements MouseListener, MouseMotionListener 
{
  /**
   * 
   */
  protected PencilCanvas my_canvas; 
  
  /**
   * 
   */
  protected Tool my_tool; 
  /**
   * 
   * @param the_canvas is canvas
   */
  public PencilCanvasListener(final PencilCanvas the_canvas)
  {
    my_canvas = the_canvas; 
    my_tool = new PencilTool(the_canvas, "Pencil"); 
  }
  
  /**
   * 
   * @param the_canvas is canvas 
   * @param the_tool is my tool
   */
  protected PencilCanvasListener(final PencilCanvas the_canvas, final Tool the_tool) 
  {
    my_canvas = the_canvas; 
    my_tool = the_tool;
  }
  /**
   * @param the_event is the event when mouse is pressed.
   */
  public void mousePressed(final MouseEvent the_event)
  {
    final Point point = the_event.getPoint(); 
    my_tool.startShape(point);    
    my_canvas.my_mouse_button_down = true;
    my_canvas.my_x = point.x; 
    my_canvas.my_y = point.y; 
  } 
  /**
   * @param the_event is the event when mouse is dragged.
   */
  public void mouseDragged(final MouseEvent the_event) 
  {
    final Point point = the_event.getPoint(); 
    if (my_canvas.my_mouse_button_down) 
    {
      my_tool.addPointToShape(point);
      my_canvas.my_x = point.x; 
      my_canvas.my_y = point.y; 
    }       
  }
  /**
   * @param the_event is the event when mouse is released.
   */
  public void mouseReleased(final MouseEvent the_event) 
  {
    final Point point = the_event.getPoint(); 
    my_tool.endShape(point);       
    my_canvas.my_mouse_button_down = false;       
  }    
  /**
   * @param the_event is the event when mouse is clicked.
   */
  public void mouseClicked(final MouseEvent the_event) 
  {
    // do nothing
  }
  /**
   * @param the_event is the event when mouse entered.
   */
  public void mouseEntered(final MouseEvent the_event)
  {
 // do nothing
  } 
  /**
   * @param the_event is the event when mouse exited.
   */
  public void mouseExited(final MouseEvent the_event) 
  {
 // do nothing
  }
  /**
   * @param the_event is the event when mouse is moved.
   */
  public void mouseMoved(final MouseEvent the_event)
  {
 // do nothing
  }     


}


