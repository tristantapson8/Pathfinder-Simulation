
package robot;

//@brief PathCalculations class
//@details Class does calculations to compute the robot's journey
public class PathCalculation extends Map{
	
	// @brief is_validSegment method
	// @details checks to see if segment between two points p1 & p2 doesn't come closer than TOLERANCE to any obstacle
	// @param p1 the tail point of a line segment
	// @param p2 the head point of a line segment
	// @return the boolean result of the valid segment check
	public boolean is_validSegment(PointT p1, PointT p2) throws InvalidPositionException, InvalidPointException{
		
		boolean is_valid = false;
		
		for(int i = 0; i < Obstacles.size(); i++){
			
			PointT upper_right = new PointT(Obstacles.getval(i).lower_left.xcrd() + Obstacles.getval(i).width, Obstacles.getval(i).lower_left.ycrd() + Obstacles.getval(i).height);
			
			// checks both p1 & p2 to the 4 corner points of a region and does distance calculation; distance < 5 ? invalid
			if(p1.dist(Map.get_obstacles().getval(i).lower_left) >= Constants.TOLERANCE &&
			   p1.dist(Obstacles.getval(i).lower_left) + Obstacles.getval(1).width >= Constants.TOLERANCE &&
			   p1.dist(Obstacles.getval(i).lower_left) + Obstacles.getval(1).height >= Constants.TOLERANCE &&
			   p1.dist(upper_right) >= Constants.TOLERANCE && 
			   p2.dist(Obstacles.getval(i).lower_left) >= Constants.TOLERANCE &&
			   p2.dist(Obstacles.getval(i).lower_left) + Obstacles.getval(1).width >= Constants.TOLERANCE &&
			   p2.dist(Obstacles.getval(i).lower_left) + Obstacles.getval(1).height >= Constants.TOLERANCE &&
			   p2.dist(upper_right) >= Constants.TOLERANCE){

				   is_valid = true;
			   }
			
			else{
				is_valid = false;
				break;
			}
		}
		
		return is_valid;
	}
	
	// @brief is_validPath method
	// @details checks to see if path p is valid
	// @param p the list path with points of type pointT
	// @return the boolean result of the valid path check
	public boolean is_validPath(GenericList<PointT> p) throws InvalidPositionException, InvalidPointException{
		
		boolean is_valid = false;
		
		for(int i = 0; i < Destinations.size(); i++){
			
			for(int j = 0; j < p.size()-1; j++){
				if(is_validSegment(p.getval(j),p.getval(j+1)) == true){
					is_valid = true;
					if (j == 0 | j == p.size()-1){
						if(Destinations.getval(i).pointInRegion(p.getval(j)) == true){
							is_valid = true;
						}
					}
				}
					
				else{
					is_valid = false;
					break;
				}
			}
		}
		
		return is_valid;
	}
	
	// @brief totalDistance method
	// @details calculates the total distance of path p
	// @param p the list path with points of type pointT
	// @return value of type double that is the total distance between all points on a path
	public double totalDistance(GenericList<PointT> p) throws InvalidPositionException{
		double sum = 0;
		for(int i =0; i < p.size()-1; i++){
			sum += p.getval(i).dist(p.getval(i+1));
		}
		return sum;
	}
	
	// @brief is_shortestPath method
	// @details checks to see if path p is the shortest path
	// @param p the list path with points of type pointT
	// @return the boolean result of the shortest path check
	public boolean is_shortestPath(GenericList<PointT> p) throws InvalidPositionException, InvalidPointException{
			
		boolean is_shortest = false;
			
		for(int q = 0; q < PathT.get_paths().size(); q++){
			if(is_validPath(p) == true  && (totalDistance(p) < totalDistance(PathT.get_paths()))){ // need to fix this && this.totalDistance 
				is_shortest = true;
			}
			else{
				is_shortest = false;
				break;
			}
		}
		
		
		
		return is_shortest;
	}
	
	// @brief totalTurns method
	// @details calculates the total turns in path p
	// @param p the list path with points of type pointT
	// @return value of type int that is the total turns on a path
	public int totalTurns(GenericList<PointT> p) throws InvalidPositionException{
		
		int count = 0;
	
		for(int i = 0; i < p.size()-2; i++){
			if( Math.acos( p.getval(i+1).dist(p.getval(i)) * p.getval(i+2).dist(p.getval(i+1))  / p.getval(i).dist(p.getval(i+1)) * p.getval(i+1).dist(p.getval(i+2))) != 0){
				count++;
			}
		}
		return count;
	}
	
	// @brief estimatedTime method
	// @details calculates the total time it takes to travel along path p
	// @param p the list path with points of type pointT
	// @return value of type double that is the total time it takes to traverse the path
	public double estimatedTime(GenericList<PointT> p) throws InvalidPositionException{
		
		double estTime = 0.0;
		
		for(int i = 0; i < p.size()-2; i++){
			if(i < p.size()-2){
				estTime += (p.getval(i).dist(p.getval(i+1)) / Constants.VELOCITY_LINEAR + ( Math.acos( p.getval(i+1).dist(p.getval(i)) * p.getval(i+2).dist(p.getval(i+2))  / p.getval(i).dist(p.getval(i+1)) * p.getval(i+1).dist(p.getval(i+2))) / Constants.VELOCITY_ANGULAR));
			}
			else{
				estTime += (p.getval(i).dist(p.getval(i+1)) / Constants.VELOCITY_LINEAR);
			}
		}
		
		return estTime;
	}
}
