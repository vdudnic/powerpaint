package drawshapes; 

import java.awt.Color;
import java.awt.Graphics;
/**
 * 
 * @author Vladimir Dudnic
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class GeometricShapes extends pencil.Shape implements Cloneable 
{
  /**
   * 
   */
  protected int my_x1;
  /**
   * 
   */
  protected int my_y1;
  /**
   * 
   */
  protected int my_x2;
  /**
   * 
   */
  protected int my_y2;

  /**
   * 
   */
  public GeometricShapes()
  {
    super();
  } 
  /**
   * 
   * @param the_color is color of the shape.
   */
  public GeometricShapes(final Color the_color) 
  {
    super(the_color); 
  } 
  /**
   * @return super.clone()
   * @throws CloneNotSupportedException 
   */
  @Override
  public Object clone() throws CloneNotSupportedException 
  { 
    return super.clone(); 
  }
  /**
   * 
   * @param the_x1 is x1 coord.
   * @param the_y1 is y1 coord.
   * @param the_x2 is x2 coord.
   * @param the_y2 is y2 coord.
   */
  public void setEnds(final int the_x1, final int the_y1, final int the_x2, final int the_y2)
  { 
    my_x1 = the_x1; 
    my_y1 = the_y1; 
    my_x2 = the_x2; 
    my_y2 = the_y2;
  }
  /**
   * 
   * @param the_x1 is x1 coord.
   * @param the_y1 is y1 coord.
   */
  public void setEnd1(final int the_x1, final int the_y1) 
  { 
    my_x1 = the_x1; 
    my_y1 = the_y1; 
  }
  /**
   * 
   * @param the_x2 is x2 coord.
   * @param the_y2 is y2 coord.
   */
  public void setEnd2(final int the_x2, final int the_y2)
  { 
    this.my_x2 = the_x2; 
    this.my_y2 = the_y2; 
  }
  /**
   * 
   * @return my_x1
   */
  public int getX1() 
  { 
    return my_x1; 
  }
  /**
   * 
   * @return my_y1
   */
  public int getY1() 
  { 
    return my_y1; 
  }
  /**
   * 
   * @return my_x2
   */
  public int getX2() 
  { 
    return my_x2; 
  }
  /**
   * 
   * @return my_y2
   */
  public int getY2() 
  { 
    return my_y2; 
  }
  /**
   * 
   * @param the_g is parameter for graphics.
   * @param the_x1 is x1 coord.
   * @param the_y1 is x2 coord.
   * @param the_x2 is y1 coord.
   * @param the_y2 is y2 coord.
   */
  public abstract void drawOutline(final Graphics the_g,
                                   int the_x1, int the_y1,
                                   int the_x2, int the_y2); 

}

