package pencil;
/**
 * 
 * @author Vladimir Dudnic
 * @version 1.0
 */
public abstract class AbstractTool implements Tool
{
  /**
   * 
   */
  protected String my_name;
  /**
   * 
   */
  protected PencilCanvas my_canvas;
  /**
   * 
   * @param the_canvas is canvas for pencil. 
   * @param the_name is name of the tool.
   */
  protected AbstractTool(final PencilCanvas the_canvas, final String the_name) 
  {
    my_canvas = the_canvas;
    my_name = the_name;
  }

  /**
   * @return name of the tool.
   */
  public String getName() 
  {
    return my_name;
  }


}