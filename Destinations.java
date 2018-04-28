// Tristan Tapson
// 001319964
// NOTE!: package was used for all classes, called robot

package robot;

// @brief Destinations class
// @details Class initializes the destinations generic list
public class Destinations {

public static GenericList<RegionT> Destination;
	
	// @brief Destinations constructor
	// @details initializes the destinations generic list
	// @param d the generic list of type regionT
	public <T> void init(GenericList<RegionT> d){
		Destinations.Destination = d;
	}
	
	// @brief get_destinations method
	// @details getter for a generic list of type regionT
	// @return list instance of destinations
	public static GenericList<RegionT> get_destinations(){
		return Destinations.Destination;
	}
		
}
