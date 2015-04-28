import java.util.Random;
import java.util.ArrayList;
import java.awt.geom.Point2D;

/**
Holds a network with the coordinates of each point
*/
public class SpatialNetwork
{
	private ArrayList<Point2D.Double> net;
	private int points;
	private double threshold;
	
	/**
	Initialises the network array and fills it with random Doubles between 0.0 and 1.0 to be used to calculate coordinates later
	@param points The number of points in the network
	@param threshold The distance below which points will be connected
	*/
	public SpatialNetwork(int points, double threshold)
	{
		this.net = new ArrayList<Point2D.Double>();
		this.points = points;
		this.threshold = threshold;
		
		addPoints(points);
	}
	
	/**
	The method for adding or removing points from the graph
	@param points The new points value
	*/
	public void addPoints(int points)
	{
		Random random = new Random();
		
		for(int i = 0; i < points; i++)
		{
			if(points > net.size())
			{
				Point2D.Double location = new Point2D.Double(random.nextDouble(), random.nextDouble());
				net.add(location);
			}
			else if(points < net.size())
			{
				net.remove((net.size() - 1));
			}
		}
	}
	
	/**
	Get the coordinates of each point
	@return The coordinates of each Point2D.Double in the array
	*/
	public ArrayList<Point2D.Double> getCoords()
	{
		return net;
	}
	
	/**
	Get the number of points in the network
	@return The number of points in the network
	*/
	public int getPoints()
	{
		return points;
	}
	
	/**
	Get the threshold
	@return The threshold
	*/
	public double getThreshold()
	{
		return threshold;
	}
	
	/**
	Checks whether or not two points are connected
	@param pointA The first point
	@param pointB The second point
	@return If two given points are connected
	*/
	public boolean isConnected(int pointA, int pointB)
	{
		double pointAx = net.get(pointA).getX();
		double pointAy = net.get(pointA).getY();
		double pointBx = net.get(pointB).getX();
		double pointBy = net.get(pointB).getY();
		
		if(Math.max(pointAx, pointBx) - Math.min(pointAx, pointBx) <= threshold
		   && Math.max(pointAy, pointBy) - Math.min(pointAy, pointBy) <= threshold)
		   {
		   	return true;
		   }
		   else
		   {
		   	return false;
		   }
	}
	
	/**
	Sets a new value for threshold
	@param threshold The new value for threshold
	*/
	public void setThreshold(double threshold)
	{
		this.threshold = threshold;
	}
	
	/**
	Sets a new value for the number of points in the network
	@param points The new number of points in the network
	*/
	public void setPoints(int points)
	{
		this.points = points;
		addPoints(points);
	}
}
