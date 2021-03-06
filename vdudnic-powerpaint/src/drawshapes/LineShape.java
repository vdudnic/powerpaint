package drawshapes; 

import java.awt.Graphics;
/**
 * 
 * @author Vladimir
 * @version 1.0
 */
@SuppressWarnings("serial")
public class LineShape extends GeometricShapes 
{
  /**
   * @param the_g is parameter for graphics.
   */
  public void draw(final Graphics the_g) 
  {
    if (my_color != null) 
    {
      the_g.setColor(my_color);
    }
    the_g.drawLine(my_x1, my_y1, my_x2, my_y2); 
  }
  /**
   *  @param the_g is parameter for graphics.
   *  @param the_x1 is x1 coord.
   *  @param the_x2 is x2 coord.
   *  @param the_y1 is y1 coord.
   *  @param the_y2 is y2 coord.
   */
  public void drawOutline(final Graphics the_g, 
                          final int the_x1, final int the_y1,
                          final int the_x2, final int the_y2) 
  {
    the_g.drawLine(the_x1, the_y1, the_x2, the_y2); 
  }

}

