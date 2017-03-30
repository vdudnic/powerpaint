package drawshapes; 

import pencil.PencilCanvasListener;
import pencil.Tool;
/**
 * 
 * @author Vladimir Dudnic
 * @version 1.0
 */
public class DrawingCanvasListener extends PencilCanvasListener
{ 
  /**
   * 
   * @param the_canvas is drawing canvas.
   */
  public DrawingCanvasListener(final DrawingCanvas the_canvas) 
  { 
    super(the_canvas, null); 
  }
  /**
   * 
   * @return my tool.
   */
  public Tool getTool() 
  { 
    return my_tool; 
  }
  /**
   * 
   * @param the_tool is my tool.
   */
  public void setTool(final Tool the_tool) 
  { 
    my_tool = the_tool;
  }

}