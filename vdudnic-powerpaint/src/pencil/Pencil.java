package pencil; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

/**
 * 
 * @author Vladimir
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Pencil extends JFrame 
{
  /**
   * width of the frame.
   */
  protected static final int WIDTH = 400;
  /**
   * height of the frame.
   */
  protected static final int HEIGHT = 300;
  /**
   * 
   */
  protected PencilCanvas my_canvas;
  /**
   * 
   */
  protected JMenuBar my_menu_bar;
  /**
   * 
   */
  protected ActionListener my_exit_action;

  /**
   * 
   * @param the_title is a title.
   */
  public Pencil(final String the_title) 
  {
    super(the_title);
    
    my_canvas = makeCanvas();
    getContentPane().setLayout(new BorderLayout());
    my_menu_bar = createMenuBar();
    getContentPane().add(my_menu_bar, BorderLayout.NORTH);
    getContentPane().add(my_canvas, BorderLayout.CENTER);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  }
  /**
   * 
   * @return menu bar.
   */
  protected JMenuBar createMenuBar() 
  {
    final JMenuBar menu_bar = new JMenuBar();
    JMenu menu;
    JMenuItem mi;
    // File menu
    menu = new JMenu("File");
    menu.setMnemonic(KeyEvent.VK_F);
    menu_bar.add(menu);
    mi = new JMenuItem("Clear");
    mi.setMnemonic(KeyEvent.VK_C); 
    menu.add(mi);
    mi.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event) 
      {
        my_canvas.setBackground(Color.WHITE);  
      }
    });
    menu.add(new JSeparator());

    my_exit_action = new ExitListener();
    mi = new JMenuItem("Quit");
    mi.setMnemonic(KeyEvent.VK_Q);
    menu.add(mi);
    mi.addActionListener(my_exit_action);
        
    // Help menu
    menu = new JMenu("Help");
    menu.setMnemonic(KeyEvent.VK_H);
    menu_bar.add(menu);

    mi = new JMenuItem("About...");
    mi.setMnemonic(KeyEvent.VK_A);
    menu.add(mi);   
    mi.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        JOptionPane.showMessageDialog(null,
            "TCSS 305 PowerPaint, v1.0",
            "About", JOptionPane.INFORMATION_MESSAGE);
      }
    });
  
    return menu_bar;
  }

  /**
   *  factory method.
   * @return new canvas for pencil.
   */
  protected PencilCanvas makeCanvas()
  {
    return new PencilCanvas();
  }
  /**
   * 
   * @author Vladimir Dudnic
   * @version 1.0
   */
  class ExitListener implements ActionListener
  {
    /**
     * @param the_event is the action event.
     */
    public void actionPerformed(final ActionEvent the_event)
    {
      final int result = JOptionPane.showConfirmDialog(null,
          "Do you want to exit PowerPaint?", "Exit PowerPaint?",
          JOptionPane.YES_NO_OPTION);
      if (result == JOptionPane.YES_OPTION)
      {
        System.exit(1);
      }
      else
      {
        repaint();
      }
    }

  }

}
