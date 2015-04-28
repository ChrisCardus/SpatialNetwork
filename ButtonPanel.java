import javax.swing.JPanel;
import javax.swing.JButton;

/**
Creates a panel to hold the exit and reset buttons
*/
public class ButtonPanel extends JPanel
{
	private JButton reset;
	private JButton exit;
	private SpatialModel model;
	private JPanel panel;
	private int init;
	
	/**
	Constructs a JPanel with two buttons on it and adds it to the JPanel
	@param reset The reset button
	@param exit The exit button
	*/
	public ButtonPanel(JButton reset, JButton exit)
	{
		this.reset = reset;
		this.exit = exit;
		this.panel = new JPanel();
		this.init = init;
		
		panel.add(reset);
		panel.add(exit);
		add(panel);
	}
}
