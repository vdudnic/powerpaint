package drawshapes; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import pencil.ColorDialog;
import pencil.Pencil;
import pencil.PencilCanvas;
import pencil.PencilTool;
import pencil.Tool;
/**
 * 
 * @author Vladimir Dudnic
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DrawingPad extends Pencil 
{ 
  /**
   * 
   */
  protected ToolKit my_toolkit;
  /**
   * 
   */
  protected DrawingCanvas my_drawing_canvas;
  /**
   * 
   */
  private final JButton my_color_button = new JButton("Color...");
  /**
   * 
   * @param the_title is the title of the frame.
   */
  public DrawingPad(final String the_title) 
  {
    super(the_title); 
    initTools();
    final ActionListener tool_listener = new ActionListener()
    { 
      public void actionPerformed(final ActionEvent the_event)
      { 
        final Object source = the_event.getSource();
        if (source instanceof AbstractButton) 
        {
          final AbstractButton button = (AbstractButton) source; 
          final Tool tool = my_toolkit.setSelectedTool(button.getText());
      
          my_drawing_canvas.setTool(tool);
        }
      }
      };
    final JToolBar toolbar = createToolBar(tool_listener);
    getContentPane().add(toolbar, BorderLayout.SOUTH);
    final JMenu menu_1 = createOptionMenu();
    my_menu_bar.add(menu_1, 1);
    final JMenu menu_2 = createToolMenu(tool_listener);
    my_menu_bar.add(menu_2, 2);

  } 
  /**
   * 
   * @return selected tool.
   */
  public Tool getSelectedTool()
  { 
    return my_toolkit.getSelectedTool(); 
  }
  /**
   * initialize tools.
   */
  protected void initTools() 
  {   
    my_toolkit = new ToolKit(); 
    my_toolkit.addTool(new PencilTool(my_canvas, "Pencil")); 
    my_toolkit.addTool(new GeometricTool(my_canvas, "Line", GeometricTool.LINE)); 
    my_toolkit.addTool(new GeometricTool(my_canvas, "Ellipse", GeometricTool.ELLIPSE)); 
    my_toolkit.addTool(new GeometricTool(my_canvas, "Rectangle", GeometricTool.RECTANGLE)); 
    my_drawing_canvas.setTool(my_toolkit.getTool(0));
  }

  /**
   *  factory method.
   *  @return drawing canvas.  
   */
  protected PencilCanvas makeCanvas() 
  {
    my_drawing_canvas = new DrawingCanvas();
    return my_drawing_canvas;  
  }
  /**
   * 
   * @param the_tool_listener listens the tool.
   * @return tool bar
   */
  protected  JToolBar createToolBar(final ActionListener the_tool_listener) 
  { 
  
    final JToolBar tool_bar = new JToolBar();
    my_color_button.setMnemonic(KeyEvent.VK_C);
    my_color_button.setForeground(Color.WHITE);
    my_color_button.setBackground(Color.BLACK);
    my_color_button.addActionListener(new ColorListener());
    tool_bar.add(my_color_button);
    final ButtonGroup group = new ButtonGroup();
    final int n = my_toolkit.getToolCount();
    for (int i = 0; i < n; i++)
    {
      final Tool tool = my_toolkit.getTool(i);
      if (tool != null)
      {

        final JToggleButton button = new JToggleButton(tool.getName());
        final Action bar_action = new MnemonicAction(tool.getName());
        bar_action.putValue(Action.MNEMONIC_KEY, Integer.valueOf(tool.getName().charAt(0)));
        button.setAction(bar_action);
        button.addActionListener(the_tool_listener);
        group.add(button);
        tool_bar.add(button);
      }
    }    
    return tool_bar; 
  }
  
  /**
   * 
   * @param the_tool_listener listens the tool.
   * @return menu
   */
  protected JMenu createToolMenu(final ActionListener the_tool_listener) 
  { 
    final JMenu menu = new JMenu("Tools");
    menu.setMnemonic(KeyEvent.VK_T);
    final JMenuItem color_chooser = new JMenuItem("Color... ");
    color_chooser.setMnemonic(KeyEvent.VK_C);
    color_chooser.addActionListener(new ColorListener());
    menu.add(color_chooser);
    menu.add(new JSeparator());
    final ButtonGroup group = new ButtonGroup();
    final int n = my_toolkit.getToolCount();
    for (int i = 0; i < n; i++)
    {
      final Tool tool = my_toolkit.getTool(i);
      if (tool != null)
      {
        final JRadioButtonMenuItem menuitem = new JRadioButtonMenuItem(tool.getName());
        final Action menu_action = new MnemonicAction(tool.getName());
        menu_action.putValue(Action.MNEMONIC_KEY, Integer.valueOf(tool.getName().charAt(0)));
        menuitem.setAction(menu_action);
        menuitem.addActionListener(the_tool_listener);
        group.add(menuitem);
        menu.add(menuitem);

      }
    }
    return menu; 
  }
  /**
   * 
   * @return menu with options.
   */
  protected JMenu createOptionMenu() 
  {
    final JMenu option_menu = new JMenu("Options");
    option_menu.setMnemonic(KeyEvent.VK_O);

    final JCheckBoxMenuItem options_grid = new JCheckBoxMenuItem("Grid");
    options_grid.setMnemonic(KeyEvent.VK_G);

 /*   options_grid.addActionListener(new ActionListener()
    {
      *//**
       * 
       *//*
      public void actionPerformed(final ActionEvent the_event)
      {
        
        if (options_grid.isSelected())
        {
          //do nothing
        }

      }
    });*/
    options_grid.setState(false);

    final JMenu options_thickness = new JMenu("Thickness");
    options_thickness.setMnemonic(KeyEvent.VK_T);

    final ButtonGroup group = new ButtonGroup();
    final String[] thickness = {"1", "2", "4"};

    for (int i = 0; i < thickness.length; i++) 
    {
      
      final JRadioButtonMenuItem menuitem = new JRadioButtonMenuItem(thickness[i]);
      final Action menu_action = new MnemonicAction(thickness[i]);
      menu_action.putValue(Action.MNEMONIC_KEY, Integer.valueOf(thickness[i].charAt(0)));
      menuitem.setAction(menu_action);
      group.add(menuitem);
      options_thickness.add(menuitem);

    }
    option_menu.add(options_grid);
    option_menu.add(options_thickness);
    return option_menu;
  }
  
  /**
   * 
   * @param the_args are the arguments.
   */
  public static void main(final String[] the_args) 
  {
    final JFrame frame = new DrawingPad("PowerPaint");
    frame.setSize(WIDTH, HEIGHT);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
  /**
   * Sets mnemonics.
   * @author Vladimir Dudnic
   * @version 1.0
   */
  class MnemonicAction extends AbstractAction
  {
    /**
     * 
     * @param the_name 
     */
    public MnemonicAction(final String the_name)
    {
      super(the_name);
    }
    /**
     * @param the_event is an event.
     */
    public void actionPerformed(final ActionEvent the_event)
    {
      
      repaint();
      
    }

  }

  /**
   * 
   * @author Vladimir Dudnic
   * @version 1.0
   */
  class ColorListener implements ActionListener
  {
    /**
     * 
     */
    protected ColorDialog my_dialog = new ColorDialog(DrawingPad.this,
                                                   "Choose color", 
                                                   my_drawing_canvas.getCurColor());
    /**
     * @param the_event is event
     */
    public void actionPerformed(final ActionEvent the_event) 
    {
      final Color result = my_dialog.showDialog();
      if (result != null) 
      {
        my_drawing_canvas.setCurColor(result);
        my_color_button.setBackground(result);
      }
      
    }   

  }
  /**
   *  
   */
/*  public void paintGrid()
  {
      Graphics g = getGraphics();
     //Get current JFrame width  
     int panelWidth = getSize().width;  
      
     //Get current JFrame height  
     int panelHeight = getSize().height;  
      
     int temp = 0;  
      
     //Draw vertical grid line with spacing between each line equal to 10 pixels  
     while(temp < panelWidth || temp < panelHeight)  
     {  
      temp = temp + 10;  
      g.drawLine(temp,0,temp,panelHeight);  
      g.drawLine(0,temp,panelWidth,temp);
     }  
    //repaint(); 
       
  }*/
 

}
