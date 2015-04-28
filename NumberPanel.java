import javax.swing.JPanel;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Dimension;

/**
Creates a JPanel which holds the JSlider and JLabel for changing the number of points on the graph
*/
public class NumberPanel extends JPanel implements Observer
{
	private JSlider slider;
	private JLabel label;
	private SpatialModel model;
	private JPanel panel;
	private SpatialView view;
	
	/**
	Constructs a JPanel with a JLabel and a JSlider on it and displays it on the JPanel
	@param model The model that is observed
	@param min The minimum value on the slider
	@param max The maximum value on the slider
	@param value The initial value on the sldier
	@param slider The JSlider object
	*/
	public NumberPanel(SpatialModel model, int min, int max, int value, JSlider slider)
	{
		super();
		
		Dimension di = new Dimension(300, 60);
		
		this.slider = slider;
		slider.setPreferredSize(di);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		this.label = new JLabel("Points in the network");
		this.model = model;
		this.panel = new JPanel();
		panel.add(slider);
		add(label);
		add(panel);
	}
	
	/**
	Updates the position of the slider when the number of points on the graph is changed
	*/
	public void update(Observable obs, Object obj)
	{
		slider.setValue(model.getPoints());
	}
}
