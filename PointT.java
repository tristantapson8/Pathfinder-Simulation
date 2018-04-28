package robot;

public class PointT {
	
	private double x; 
	private double y; 

	// @brief PointT constructor
	// @details initializes a point
	// @param x the x coordinate of the point
	// @param y the y coordinate of the point
	// @exception InvalidPointException throws if the point is not within constants constraints
	public PointT(double x, double y) throws InvalidPointException{
		
		this.x = x;
		this.y = y;
		
		if(!(0 < x | x <= Constants.MAX_X | 0 < y | y <= Constants.MAX_Y)){
			throw new InvalidPointException("A point exists outside of the TOLERANCE range. Invalid Point.");
		}
	}
	
	// @brief xcrd method
	// @details getter for the x coordinate of a point
	// @return the x coordinate of the point
	public double xcrd(){
		return this.x;
	}
	
	// @brief ycrd method
	// @details getter for the y coordinate of a point
	// @return the y coordinate of the point
	public double ycrd(){
		return this.y;
	}
	
	// @brief dist method
	// @details calculates distance between two points
	// @param p an object pointT
	// @return the distance between two points
	public double dist(PointT p){
		double dist = Math.sqrt(Math.pow(this.x - p.x,2) + Math.pow(this.y - p.y,2));
		return dist;
	}
}
