package robot;

public class RegionT {
	
	public PointT lower_left;
	public double width; 
	public double height; 
	
	// @brief RegionT constructor
	// @details initializes a region
	// @param p the lower left point in a region
	// @param w the width of the region 
	// @param h the height of the region
	// @exception InvalidRegionException throws if the region is not within constants constraints
	public RegionT(PointT p, double w, double h) throws InvalidRegionException{
		
		this.lower_left = p;
		this.width = w;
		this.height = h;
		
		if(!( w > 0 | h > 0 | (p.xcrd() + w) < Constants.MAX_X | (p.ycrd() + h) < Constants.MAX_Y )){
			throw new InvalidRegionException("A region extends outside of the TOLERANCE range. Invalid Region.");
		}
	}
	
	// @brief pointInRegion method
	// @details checks if a point p is in a region
	// @param p any pointT
	public boolean pointInRegion(PointT p) throws InvalidPositionException{
		
		boolean inRegion = false;
		
		for(int q = 0; q < Map.get_obstacles().size(); q ++){
			if(p.dist(Map.get_obstacles().getval(q).lower_left) <= Constants.TOLERANCE){
				inRegion = true;
			}
			else{
				inRegion = false;
				break;
			}
		}
		return inRegion;
	}
	
	public void Region(){
		
	}
}
