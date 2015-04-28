import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.ArrayList;

/**
A model for the Spacial Network class
*/
public class SpatialModel extends Observable
{
	private SpatialNetwork net;
	
	/**
	Initialises a model for the Spatial Network class
	*/
	public SpatialModel(SpatialNetwork net)
	{
		super();
		this.net = net;
	}
	
	/**
	Get the coordinates of each point
	@return The coordinates of each Point2D.Double in the array
	*/
	public ArrayList<Point2D.Double> getCoords()
	{
		return net.getCoords();
	}
	
	/**
	Get the number of points in the network
	@return The number of points in the network
	*/
	public int getPoints()
	{
		return net.getPoints();
	}
	
	/**
	Get the threshold
	@return The threshold
	*/
	public double getThreshold()
	{
		return net.getThreshold();
	}
	
	/**
	Checks whether or not two points are connected
	@param pointA The first point
	@param pointB The second point
	@return If two given points are connected
	*/
	public boolean isConnected(int pointA, int pointB)
	{
		return net.isConnected(pointA, pointB);
	}
	
	/**
	Sets a new value for threshold
	@param threshold The new value for threshold
	*/
	public void setThreshold(double threshold)
	{
		net.setThreshold(threshold);
		setChanged();
		notifyObservers();
	}
	
	/**
	Sets a new value for the number of points in the network
	@param points The new number of points in the network
	*/
	public void setPoints(int points)
	{
		net.setPoints(points);
		setChanged();
		notifyObservers();
	}
}
