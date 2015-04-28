import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.BorderLayout;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
Holds the JPanel which on which all of the elements of the program are placed before being passed to the JFrame
*/
public class SpatialComponent extends JPanel
{
	/**
	Constructs a JPanel with all the elements of the program
	@param network The Spatial Network
	@param min The minimum value of the sliders
	@param max The maximum value of the sliders
	@param value The initial value of both threshold and points
	*/
	public SpatialComponent(SpatialNetwork network, int min, int max, final int value)
	{
		super();
		
		final SpatialModel model = new SpatialModel(network);
		
		final SpatialView view = new SpatialView(model);
		
		final JSlider tSlider = new JSlider(min, max, value);
		final JSlider nSlider = new JSlider(min, max, value);
		final JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);	
				}
			}
		);
		
		final JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					model.setPoints(value);
					model.setThreshold(value / 100);
					tSlider.setValue(value);
					nSlider.setValue(value);
				}
			}
		);
		
		ButtonPanel button = new ButtonPanel(reset, exit);
		
		final NumberPanel points = new NumberPanel(model, min, max, value, nSlider);
		nSlider.addChangeListener(new ChangeListener()
			{
				public void stateChanged(ChangeEvent e)
				{
					int v = nSlider.getValue();
					model.setPoints(v);
				}
			}
		);
		
		final ThresholdPanel threshold = new ThresholdPanel(model, min, max, value, tSlider);
		tSlider.addChangeListener(new ChangeListener()
			{
				public void stateChanged(ChangeEvent e)
				{
					int v = tSlider.getValue();
					model.setThreshold(v / 100.0);
				}
			}
		);
		
		model.addObserver(view);
		model.addObserver(threshold);
		
		setLayout(new BorderLayout());
		add(threshold, BorderLayout.SOUTH);
		add(points, BorderLayout.NORTH);
		add(button, BorderLayout.EAST);
		add(view);
	}
}
