package pencil; 

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * @author Vladimir Dudnic
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Stroke extends Shape 
{ 
  /**
   *  The list of points on the stroke.
   */   
  protected List<Point> my_points = new ArrayList<Point>();
  
  /**
   * A constructor.
   */
  public Stroke() 
  {
    super();
    
  } 
  
  /**
   * 
   * @param the_color is a color of the stroke.
   */
  public Stroke(final Color the_color) 
  {
    super(the_color); 
  } 
  
  /**
   * @param the_point is a point.
   */
  public void addPoint(final Point the_point) 
  {
    if (the_point != null)
    { 
      my_points.add(the_point); 
    }
  }
  
  /**
   * 
   * @return points. 
   */
  public List<Point> getPoints()
  { 
    return my_points; 
  }
  
  /**
   * @param the_g  is graphics parameter.
   */
  public void draw(final Graphics the_g) 
  {
    final Graphics2D g2 = (Graphics2D) the_g;
    g2.setStroke(new BasicStroke(2));
    if (my_color != null)
    {
      g2.setColor(my_color);
    }
    Point prev = null; 
    final Iterator<Point> iter = my_points.iterator(); 
    while (iter.hasNext()) 
    { 
      final Point cur = (Point) iter.next(); 
      if (prev != null) 
      {
        g2.drawLine(prev.x, prev.y, cur.x, cur.y); 
      }
      prev = cur; 
    }
    
  }

 
  
}
