
package robot;

//@brief Obstacles class
//@details Class initializes the obstacles generic list
public class Obstacles {

	public static GenericList<RegionT> Obstacle;
	
	// @brief Obstacles constructor
	// @details initializes the obstacles generic list
	// @param o the generic list of type regionT
	public <T> void init(GenericList<RegionT> o){
		Obstacles.Obstacle = o;
	}
	
	// @brief get_obstacles method
	// @details getter for a generic list of type regionT
	// @return list instance of obstacles
	public static GenericList<RegionT> get_obstacles(){
		return Obstacles.Obstacle;
	}
}
