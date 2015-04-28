import javax.swing.JFrame;

public class SpatialGUI extends JFrame
{
	public static void main(String[] args)
	{
		int points = 40;
		double threshold = 0.4;
		
		SpatialNetwork network = new SpatialNetwork(points, threshold);
		SpatialComponent spatComp = new SpatialComponent(network, 0, 100, (int)(threshold * 100));
		
		JFrame frame = new JFrame();
		
		int frameSize = 600;
		
		frame.setSize(frameSize, frameSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Spatial Network");
		frame.add(spatComp);
		frame.setVisible(true);
	}
}
