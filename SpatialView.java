import javax.swing.JPanel;
import java.util.Observer;
import java.util.Observable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;

/**
Holds a view object for the Spatial Network class
*/
public class SpatialView extends JPanel implements Observer
{
	private SpatialModel model;
	
	/**
	Initialises a view object
	@param model The model to be observed
	*/
	public SpatialView(SpatialModel model)
	{
		super();
		this.model = model;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		int height = getHeight();
		int width = getWidth();
		
		int diameter = Math.min(height, width);
		g2.clearRect(0, 0, diameter, diameter);
		
		g2.setColor(Color.BLACK);
		
		ArrayList<Point2D.Double> points = model.getCoords();
		
		Line2D.Double line = new Line2D.Double();
		
		for(int i = 0; i < points.size(); i++)
		{
			double x = diameter * points.get(i).getX();
			double y = diameter * points.get(i).getY();
			
			Spot p = new Spot(x, y, 2);
						
			g2.fill(p);
			
			for(int s = 0; s < points.size(); s++)
			{
				if(model.isConnected(i, s))
				{
					line.setLine(x, y, points.get(s).getX() * diameter, points.get(s).getY() * diameter);
					g2.draw(line);
				}
			}
		}	
	}
	
	public void update(Observable obs, Object obj)
	{
		repaint();
	}
}
