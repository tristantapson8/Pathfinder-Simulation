
package robot;

//@brief Map class
//@details Class initializes the map list
public class Map {
	
	public static GenericList<RegionT> Obstacles;
	public static GenericList<RegionT> Destinations;
	public static GenericList<RegionT> SafeZone;
	
	// @brief Map constructor
	// @details initializes the map list
	// @param o obstacles list of type regionT
	// @param d destinations list of type regionT
	// @param sz safezones list of type regionT
	public <T> void init(GenericList<RegionT> o, GenericList<RegionT> d, GenericList<RegionT> sz){
		Map.Obstacles = o;
		Map.Destinations = d;
		Map.SafeZone = sz;
	}
	
	// @brief get_obstacles method
	// @details getter for a generic list of type regionT
	// @return list instance of obstacles
	public static GenericList<RegionT> get_obstacles(){
		return Map.Obstacles;
	}
	
	// @brief get_destinations method
	// @details getter for a generic list of type regionT
	// @return list instance of destinations
	public static GenericList<RegionT> get_destinations(){
		return Map.Destinations;
	}
	
	// @brief get_safeZone method
	// @details getter for a generic list of type regionT
	// @return list instance of safezones
	public static GenericList<RegionT> get_safeZone(){
		return Map.SafeZone;
	}
}
