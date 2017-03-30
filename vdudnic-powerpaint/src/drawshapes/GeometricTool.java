package drawshapes; 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import pencil.AbstractTool;
import pencil.PencilCanvas;

/**
 * 
 * @author Vladimir Dudnic
 * @version 1.0
 */
public class GeometricTool extends AbstractTool 
{
  /**
   * 
   */
  public static final int LINE = 0;
  /**
   * 
   */
  public static final int ELLIPSE = 1;
  /**
   * 
   */
  public static final int RECTANGLE = 2; 
  /**
   * 
   */
  protected int my_shape = LINE; 
  /**
   * 
   */
  protected int my_x_start; 
  /**
   * 
   */
  protected int my_y_start; 

  /**
   * 
   * @param the_canvas is the canvas for drawing.
   * @param the_name is name 
   * @param the_shape is the shape
   */
  public GeometricTool(final PencilCanvas the_canvas, 
                     final String the_name, final int the_shape) 
  {
    super(the_canvas, the_name);
    my_shape = the_shape; 
  }
  /**
   * @param the_point is the start point.
   */
  public void startShape(final Point the_point) 
  {
    my_canvas.my_mouse_button_down = true;
    my_x_start = my_canvas.my_x = the_point.x; 
    my_y_start = my_canvas.my_y = the_point.y; 
    final Graphics g = my_canvas.getGraphics();
    g.setXORMode(Color.darkGray); 
    g.setColor(Color.lightGray); 
    switch (my_shape)
    {
      case LINE:
        drawLine(g, my_x_start, my_y_start, my_x_start, my_y_start);
        break;
      case ELLIPSE:
        drawOval(g, my_x_start, my_y_start, 1, 1);
        break;
      case RECTANGLE:
        drawRect(g, my_x_start, my_y_start, 1, 1);
        break;
      default:
        break;
    }
  }
  /**
   * @param the_point is the point of the shape.
   */
  public void addPointToShape(final Point the_point) 
  {
    if (my_canvas.my_mouse_button_down) 
    {
      final Graphics g = my_canvas.getGraphics();
      g.setXORMode(Color.darkGray); 
      g.setColor(Color.lightGray); 
      switch (my_shape)
      {
        case LINE:
          drawLine(g, my_x_start, my_y_start, my_canvas.my_x, my_canvas.my_y);
          drawLine(g, my_x_start, my_y_start, the_point.x, the_point.y);
          break;
        case ELLIPSE:
          drawOval(g, my_x_start, my_y_start, 
                   my_canvas.my_x - my_x_start + 1, 
                   my_canvas.my_y - my_y_start + 1);
          drawOval(g, my_x_start, my_y_start, 
                   the_point.x - my_x_start + 1, 
                   the_point.y - my_y_start + 1);
          break;
        case RECTANGLE:
          drawRect(g, my_x_start, my_y_start,
                   my_canvas.my_x - my_x_start + 1, 
                   my_canvas.my_y - my_y_start + 1);
          drawRect(g, my_x_start, my_y_start, 
                   the_point.x - my_x_start + 1,
                   the_point.y - my_y_start + 1);
          break;
        default:
          break;
      }
      my_canvas.my_x = the_point.x; 
      my_canvas.my_y = the_point.y; 
    } 
  }
  /**
   * @param the_point is the end point.
   */
  public void endShape(final Point the_point) 
  {
    my_canvas.my_mouse_button_down = false; 
    GeometricShapes new_shape = null; 
    switch (my_shape)
    {
      case LINE:
        new_shape = new LineShape();
        break;
      case ELLIPSE:
        new_shape = new EllipseShape();
        break;
      case RECTANGLE:
        new_shape = new RectangleShape();
        break;
      default:
        break;
    }
    if (new_shape != null) 
    { 
      new_shape.setColor(my_canvas.getCurColor());
      new_shape.setEnds(my_x_start, my_y_start, the_point.x, the_point.y); 
      my_canvas.addShape(new_shape);
    } 
    final Graphics g = my_canvas.getGraphics();
    g.setPaintMode();
    my_canvas.repaint();
  }

  // helper methods 
  /**
   * 
   * @param the_g is parameter for graphics.
   * @param the_x1 is x1 coord.
   * @param the_y1 is x2 coord.
   * @param the_x2 is y1 coord.
   * @param the_y2 is y2 coord.
   */
  public static void drawLine(final Graphics the_g, 
                              final int the_x1, final int the_y1, 
                              final int the_x2, final int the_y2) 
  {
    the_g.drawLine(the_x1, the_y1, the_x2, the_y2); 
  } 
  /**
   * 
   * @param the_g is parameter for graphics.
   * @param the_x is x coord.
   * @param the_y is y coord.
   * @param the_width is width.
   * @param the_height is height.
   */
  public static void drawRect(final Graphics the_g, 
                              int the_x, int the_y, 
                              int the_width, int the_height) 
  {
    if (the_width < 0) 
    {
      the_x = the_x + the_width; 
      the_width = -the_width; 
    }
    if (the_height < 0) 
    {
      the_y = the_y + the_height;
      the_height = -the_height;
    }
    the_g.drawRect(the_x, the_y, the_width, the_height); 
  }
  /**
   * 
   * @param the_g is parameter for graphics.
   * @param the_x is x coord.
   * @param the_y is y coord.
   * @param the_width is width.
   * @param the_height is height.
   */
  public static void drawOval(final Graphics the_g,
                              int the_x, int the_y, 
                              int the_width, int the_height) 
  {
    if (the_width < 0) 
    {
      the_x = the_x + the_width; 
      the_width = -the_width; 
    }
    if (the_height < 0) 
    {
      the_y = the_y + the_height;
      the_height = -the_height;
    }
    the_g.drawOval(the_x, the_y, the_width, the_height); 
  } 

}

