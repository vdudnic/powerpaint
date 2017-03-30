package drawshapes; 

import java.util.ArrayList;
import java.util.List;

import pencil.Tool;

/**
 * 
 * @author Vladimir
 * @version 1.0
 */
public class ToolKit 
{
  /**
   * 
   */
  private static final int TOOL_LIST = 16;
  /**
   * 
   */
  protected List<Tool> my_tools = new ArrayList<Tool>(TOOL_LIST);
  /**
   * 
   */
  protected Tool my_selected_tool; 
  
  /**
   * Add a new tool to the tool kit. 
   * @param the_tool is my tool.
   * @return the index of the new tool. 
   */
  public int addTool(final Tool the_tool) 
  {
    int size = -1;
    if (the_tool != null) 
    {
      my_tools.add(the_tool);
      size = my_tools.size() - 1; 
    }
    return size; 
  }
  /**
   * @return  size of list of tools.
   */
  public int getToolCount()
  {
    return my_tools.size(); 
  }
  /**
   * 
   * @param the_i is number of the tool.
   * @return tool
   */
  public Tool getTool(final int the_i) 
  { 
    Tool tool = null;
    if (the_i >= 0 && the_i < my_tools.size())
    { 
      tool = my_tools.get(the_i); 
    }
    return tool;
  }
  /**
   * 
   * @param the_name of the tool.
   * @return tool
   */
  public Tool findTool(final String the_name) 
  { 
    Tool tool = null;
    if (the_name != null) 
    {
      for (int i = 0; i < my_tools.size(); i++) 
      { 
        tool = my_tools.get(i); 
        if (the_name.equals(tool.getName()))
        {
          return tool;
        }
      }
    }
    return tool;
  }
  /**
   * 
   * @param the_i is number of the tool.
   */
  public void setSelectedTool(final int the_i) 
  { 
    final Tool tool = getTool(the_i); 
    if (tool != null) 
    { 
      my_selected_tool = tool; 
    }
  }
  /**
   * 
   * @param the_name is name of the tool.
   * @return tool
   */
  public Tool setSelectedTool(final String the_name) 
  { 
    final Tool tool = findTool(the_name); 
    if (tool != null) 
    { 
      my_selected_tool = tool; 
    }
    return tool;
  }
  /**
   * sets selected tool.
   * @param the_tool 
   */
  public void setSelectedTool(final Tool the_tool) 
  { 
    my_selected_tool = the_tool; 
  }
  /**
   * 
   * @return selected tool.
   */
  public Tool getSelectedTool() 
  { 
    return my_selected_tool;
  }

}

