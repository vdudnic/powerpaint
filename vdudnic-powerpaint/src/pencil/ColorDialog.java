
package pencil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * @author Vladimir Dudnic
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ColorDialog extends JDialog implements ActionListener
{
  /**
   * width of the color cells.
   */
  private static final int WIDTH = 20;
  /**
   * height of the color cells.
   */
  private static final int HEIGHT = 20;
  /**
   * x distance between color cells.
   */
  private static final int X_PAD = 10;
  /**
   * y distance between color cells.
   */
  private static final int Y_PAD = 10;
  /**
   * 
   */
  protected JButton my_ok_button;
  /**
   * 
   */
  protected JButton my_cancel_button;
  /**
   * 
   */
  protected JButton my_more_color_button;
  /**
   * 
   */
  protected ColorPanel my_color_panel;
  /**
   * 
   */
  protected JColorChooser my_chooser = new JColorChooser();
  /**
   * 
   */
  protected Color my_color;
  /**
   * 
   */
  protected Color my_result;
  
  /**
   * 
   */
  protected Dimension my_dimension;
  /**
   *  
   * @param the_frame is my frame.
   * @param the_title is the title of the frame.
   */
  public ColorDialog(final JFrame the_frame, final String the_title)
  {
    this(the_frame, the_title, Color.black);
  }
  /**
   * @param the_frame is my frame.
   * @param the_title is the title of the frame.
   * @param the_color is color to draw.
   */
  public ColorDialog(final JFrame the_frame, 
                     final String the_title,
                     final Color the_color)
  {
    super(the_frame, the_title, true);
    this.my_color = the_color;

    getContentPane().setLayout(new BorderLayout());

    final JPanel top_panel = new JPanel();
    top_panel.setLayout(new BorderLayout());
    my_color_panel = new ColorPanel(WIDTH, HEIGHT , X_PAD, Y_PAD);
    top_panel.add(my_color_panel, BorderLayout.CENTER);
    my_more_color_button = new JButton("More colors");
    my_more_color_button.addActionListener(this);
    top_panel.add(my_more_color_button, BorderLayout.SOUTH);
    getContentPane().add(top_panel, BorderLayout.CENTER);

    final JPanel bottom_panel = new JPanel();
    bottom_panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    my_ok_button = new JButton("Ok");
    my_ok_button.addActionListener(this);
    bottom_panel.add(my_ok_button);
    my_cancel_button = new JButton("Cancel");
    my_cancel_button.addActionListener(this);
    bottom_panel.add(my_cancel_button);
    getContentPane().add(bottom_panel, BorderLayout.SOUTH);

    pack();
  }
  /**
   * 
   * @return my_result which is color I set.
   */
  public Color showDialog()
  {
    my_color_panel.setColor(my_color);
    final Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
    final Dimension dialog_size = getSize();
    setLocation(screen_size.width / 2 - dialog_size.width / 2, screen_size.height / 2 -
                                                             dialog_size.height / 2);
    setVisible(true);
    if (my_result != null)
    {
      my_color = my_result;
    }
    return my_result;
  }
  /**
   * @param the_event is an action event. 
   */
  public void actionPerformed(final ActionEvent the_event)
  {
    final Object source = the_event.getSource();
    if (source.equals(my_ok_button))
    {
      my_result = my_color_panel.getColor();
    }
    else if (source.equals(my_more_color_button))
    {
      final Color selected_color = JColorChooser.showDialog(ColorDialog.this,
                                                           "Choose color", my_color);
      if (selected_color != null)
      {
        my_color_panel.setColor(selected_color);
        my_color_panel.repaint();
      }
      return;
    }
    setVisible(false);
  }
  /**
   * 
   * @author Vladimir Dudnic
   * @version 1.0
   */
  class ColorPanel extends JPanel
  {
    /**
     * 
     */
    private static final int CELL_WIDTH = 5;
    /**
     * 
     */
    private static final int CELL_HEIGHT = 5;
    /**
     * 
     */
    protected Color my_color;
    /**
     * 
     */
    protected int my_cell_width;
    /**
     * 
     */
    protected int my_cell_height;
    /**
     * 
     */
    protected int my_row_count;
    /**
     * 
     */
    protected int my_column_count;
    /**
     * 
     */
    protected int my_x_pad;
    /**
     * 
     */
    protected int my_y_pad;
    /**
     * 
     */
    protected Color[][] my_color_grid = {
      {Color.white, Color.lightGray, Color.darkGray, Color.black},
      {Color.gray, Color.blue, Color.cyan, Color.green},
      {Color.yellow, Color.orange, Color.pink, Color.red},
      {Color.magenta, Color.cyan.darker().darker(), 
        Color.green.brighter().brighter().brighter(),
        Color.yellow.darker().darker()}};
    /**
     * 
     * @param the_cell_width is width of the color cell
     * @param the_cell_height is height of the color cell
     * @param the_x_pad is x coord. 
     * @param the_y_pad is y coord.
     */
    ColorPanel(int the_cell_width, int the_cell_height,
               int the_x_pad, int the_y_pad)
    {
      super();
      if (the_cell_width < CELL_WIDTH)
      {
        the_cell_width = CELL_WIDTH;
      }
      if (the_cell_height < CELL_HEIGHT)
      {
        the_cell_height = CELL_HEIGHT;
      }
      if (the_x_pad < 2)
      {
        the_x_pad = 2;
      }
      if (the_y_pad < 2)
      {
        the_y_pad = 2;
      }
      my_cell_width = the_cell_width;
      my_cell_height = the_cell_height;
      my_x_pad = the_x_pad;
      my_y_pad = the_y_pad;
      my_row_count = my_color_grid.length;
      my_column_count = my_color_grid[0].length;
      my_dimension =
          new Dimension((the_cell_width + the_x_pad) * my_column_count + 
                        the_x_pad, (the_cell_height + the_y_pad) *
                        (my_row_count + 1) + the_y_pad);
      addMouseListener(new MouseAdapter()
      {
        /**
         * @param the_event is the event when mouse is pressed.
         */
        public void mousePressed(final MouseEvent the_event)
        {
          final Point point = the_event.getPoint();
          final int i = point.y / (ColorPanel.this.my_cell_height + ColorPanel.this.my_y_pad);
          final int j = point.x / (ColorPanel.this.my_cell_width + ColorPanel.this.my_x_pad);
          if (i < my_row_count && j < my_column_count)
          {
            my_color = my_color_grid[i][j];
            repaint();
          }
        }
      });
    }
    /**
     * 
     * @param the_color sets color.
     */
    public void setColor(final Color the_color)
    {
      my_color = the_color;
    }
    /**
     * 
     * @return color. 
     */
    public Color getColor()
    {
      return my_color;
    }
    /**
     * @return dimension.
     */
    public Dimension getMinimumSize()
    {
      return my_dimension;
    }
    /**
     * @return dimension.
     */
    public Dimension getPreferredSize()
    {
      return my_dimension;
    }
    /**
     * @param the_g is parameter for graphics.
     */
    @Override
    public void paint(final Graphics the_g)
    {
      final Dimension dimension = getSize();
      the_g.setColor(Color.lightGray);
      the_g.fillRect(0, 0, dimension.width, dimension.height);
      int x;
      int y;
      for (int i = 0; i < my_row_count; i++)
      {
        for (int j = 0; j < my_column_count; j++)
        {
          x = (my_cell_width + my_x_pad) * j + my_x_pad;
          y = (my_cell_height + my_y_pad) * i + my_y_pad;
          the_g.setColor(my_color_grid[i][j]);
          the_g.fillRect(x, y, my_cell_width, my_cell_height);
          the_g.setColor(Color.black);
          the_g.drawRect(x, y, my_cell_width, my_cell_height);
        }
      }
      x = my_x_pad;
      y = (my_cell_height + my_y_pad) * my_row_count + my_y_pad;
      final int width = (my_cell_width + my_x_pad) * my_column_count - my_x_pad;
      the_g.setColor(my_color);
      the_g.fillRect(x, y, width, my_cell_height);
      the_g.setColor(Color.black);
      the_g.drawRect(x, y, width, my_cell_height);
    }


  }

}


