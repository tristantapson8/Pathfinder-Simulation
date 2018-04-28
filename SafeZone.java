package robot;

//@brief SafeZone class
//@details Class initializes the safezones generic list
public class SafeZone{
	
public static GenericList<RegionT> Safezones;
	
	//@brief SafeZone constructor
	// @details initializes the safezones generic list
	// @param sz the generic list of type regionT
	public <T> void init(GenericList<RegionT> sz){
		SafeZone.Safezones = sz;
	}
	
	// @brief get_safezones method
	// @details getter for a generic list of type regionT
	// @return list instance of safezones
	public static GenericList<RegionT> get_safezones(){
		return SafeZone.Safezones;
	}
}
