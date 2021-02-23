package Ha_Devera.cs146.project3;
import java.util.*;

public class Point {
	
	int x;
	int y;
	int order;
	boolean northWall;
	boolean eastWall;
	boolean southWall;
	boolean westWall;
	boolean closed;
	ArrayList<Point> neighbors;
	ArrayList<Point> closedNeighbors;
	Point parent;
	
	//@param x the x coordinate of the point
	//@param y the y coordinate of the point
	//point is an object which keeps track of each cell in the maze
	public Point(int x,int y)
	{
		//sets all the variables
		this.x=x;
		this.y=y;
		this.order=-1;
		//sets all the walls as true so the maze starts of boxed
		northWall = true;
		eastWall = true;
		southWall=true;
		westWall = true;
		closed = true;
		this.neighbors = new ArrayList<Point>();	
		this.closedNeighbors = new ArrayList<Point>();
		
		parent = null;
	}
	
	//gets x coordinate
	public int getX()
	{
		return this.x;
	}
	
	//gets y coordinate
	public int getY()
	{
		return this.y;
	}
	
	//gets the ArrayList containing neighbors
	public ArrayList<Point> getNeighbors()
	{
		return this.neighbors;
	}
	
	//adds neighbors
	public void addNeighbor(Point p)
	{
		this.neighbors.add(p);
	}
	
	//sets/adds parent 
	public void addParent(Point p)
	{
		this.parent = p;
	}
	
	//removes north wall
	public void removeNorthWall()
	{
		this.northWall = false;
		this.closed = false;
	}
	
	//removes east wall
	public void removeEastWall()
	{
		this.eastWall=false;
		this.closed=false;	
	}
	
	//removes south wall
	public void removeSouthWall()
	{
		this.southWall = false;
		this.closed=false;
	}
	
	//removes west wall
	public void removeWestWall()
	{
		this.westWall=false;
		this.closed = false;
	}
	
	//returns a point in string format
	@Override
	public String toString()
	{
		System.out.print("(" + this.getX() + "," + this.getY()+") ");
		return "";
	}
	
	//returns the position/direction the neighbor is in to point p
	public Direction neighborPosition(Point p)	
	{
		if(p.getY() < this.getY())
		{
			return Direction.North;
		}
		
		if(p.getX()> this.getX())
		{
			return Direction.East;
		}
		
		if(p.getY() > this.getY())
		{
			return Direction.South;
		}
		
		if(p.getX() < this.getX())
		{
			return Direction.West;
		}
		return Direction.None;
	}
}
