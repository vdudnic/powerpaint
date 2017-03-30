package pencil;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
/**
 * 
 * @author Vladimir Dudnic
 * @version 1.0
 */
@SuppressWarnings("serial")
public class PencilCanvas extends JPanel 
{
  /**
   * my_mouse_button_down represents mouse button. 
   */
  public boolean my_mouse_button_down;
  /**
   * my_x is my x coord.
   */
  public int my_x;
  /**
   * my_y is my y coord.
   */
  public int my_y;
  /**
   *  The list of shapes of the drawing.
   */  
  protected List<Shape> my_shapes = new ArrayList<Shape>();
  /**
   * 
   */
  protected Color my_current_color = Color.BLACK;
  /**
   * 
   */
  protected EventListener my_listener;

  /**
   * This is a constructor.
   */
  public PencilCanvas() 
  {
    super();
    my_listener = makeCanvasListener();
    addMouseListener((MouseListener) my_listener);
    addMouseMotionListener((MouseMotionListener) my_listener);
  }
  /**
   * 
   * @param the_current_color is my current color.
   */
  public void setCurColor(final Color the_current_color) 
  {
    my_current_color = the_current_color;
  }
  /**
   * 
   * @return my_current_color is current color.
   */
  public Color getCurColor()
  {
    return my_current_color;
  }
  /**
   * 
   * @param the_shape is my shape.
   */
  public void addShape(final Shape the_shape)
  {
    if (the_shape != null) 
    {
      my_shapes.add(the_shape);
    }
  }
  /**
   * @param the_g is graphics parameter.
   */
  @Override
  public void paint(final Graphics the_g) 
  {
    final Graphics2D g2 = (Graphics2D) the_g;
    final Dimension dimension = getSize();
    g2.setColor(Color.WHITE);
    g2.fillRect(0, 0, dimension.width, dimension.height);
    g2.setColor(Color.BLACK);
    g2.setStroke(new BasicStroke(2));
    if (my_shapes != null)
    {
      final Iterator<Shape> iterator = my_shapes.iterator();
      while (iterator.hasNext()) 
      {
        final Shape shape = (Shape) iterator.next();
        if (shape != null) 
        {
          shape.draw(g2);
        }
      }
    } 
  }
  /**
   * 
   * @return current pencil's canvas listener
   */
  protected EventListener makeCanvasListener() 
  {
    return new PencilCanvasListener(this);
  }

}



