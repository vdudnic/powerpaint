package drawshapes; 

import java.util.EventListener;

import pencil.PencilCanvas;
import pencil.Tool;

/**
 * 
 * @author Vladimir Dudnic
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DrawingCanvas extends PencilCanvas 
{
  /**
   * tool listener for drawing canvas.
   */
  protected DrawingCanvasListener my_drawing_canvas_listener; 
  /**
   * 
   * @param the_tool is a tool for drawing.
   */
  public void setTool(final Tool the_tool) 
  { 
    my_drawing_canvas_listener.setTool(the_tool);
  }
  /**
   * 
   * @return tool which listened drawing canvas
   */
  public Tool getTool() 
  { 
    return my_drawing_canvas_listener.getTool(); 
  }

  /**
   *  @return listener for drawing canvas.
   */
  protected EventListener makeCanvasListener()
  {
    my_drawing_canvas_listener = new DrawingCanvasListener(this);
    return my_drawing_canvas_listener; 
  }



}