
package robot;

// @brief PathT class
// @details Class initializes the paths generic list
public class PathT {
	
	public static GenericList<PointT> Paths;
	
	// @brief PathT constructor
	// @details initializes the paths generic list
	// @param p the generic list of type pointT
	public <T> void init(GenericList<PointT> p){
		PathT.Paths = p;
	}
	
	// @brief get_paths method
	// @details getter for a generic list of type pointT
	// @return list instance of paths
	public static GenericList<PointT> get_paths(){
		return PathT.Paths;
	}
}
