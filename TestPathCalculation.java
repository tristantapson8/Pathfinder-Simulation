package robot;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

// @brief TestPathCalculation class
// @details A class used to test PathCalculation.java
public class TestPathCalculation {

	private PointT safe_ll;
	private RegionT safe_r;
	
	private PointT o1_ll;
	private RegionT o1_r;
	
	private PointT o2_ll;
	private RegionT o2_r;
	
	private PointT o3_ll;
	private RegionT o3_r;
	
	private PointT d1_ll;
	private RegionT d1_r;
	
	private PointT d2_ll;
	private RegionT d2_r;
	
	private PointT p1;
	private PointT p2;
	private PointT p3;
	private PointT p4;
	private PointT p5;
	
	private GenericList<PointT> Path1;
	private GenericList<PointT> Path2;
	private GenericList<PointT> Path3;
	
	private GenericList<RegionT> Obstacles;
	private GenericList<RegionT> Destinations;
	private GenericList<RegionT> Safezones;
	
	private Object map;
	private Object path;
	private Object calc;
	
	
	// @brief setUp method
	// @details inputs added and initialized before every test
	@Before
	public void setUp() throws Exception{
		
		// ------ SAFEZONE ------
		safe_ll = new PointT(20.0, 20.0);
		safe_r = new RegionT(safe_ll, 15.0, 15.0);

		// ------ OBSTACLES ------
		o1_ll = new PointT(30.0, 50.0);
		o1_r =  new RegionT(o1_ll, 70.0, 20.0);
				
		o2_ll = new PointT(55.0, 100.0);		
		o2_r = new RegionT(o2_ll, 70.0, 30.0);
				
	    o3_ll = new PointT(140.0, 40.0);
	    o3_r = new RegionT(o3_ll, 30.0, 20.0);
				
		// ------ DESTINATIONS ------
		d1_ll = new PointT(145.0, 145.0);					
		d1_r = new RegionT(d1_ll, 10.0, 10.0);
				
		d2_ll = new PointT(30.0, 145.0);
		d2_r = new RegionT(d2_ll, 10.0, 10.0);
				
		// ------ TRAVEL PATH POINTS ------
		p1 = new PointT(120.0, 20.0);
		p2 = new PointT(120.0, 85.0);
		p3 = new PointT(145.0, 85.0);
		p4 = new PointT(20.0, 145.0);
		p5 = new PointT(29.0, 50.0);
				
		// ------ PATHS ------
		Path1 = new GenericList<PointT>();
		Path1.GenericList();
		Path1.add(0, safe_ll);
		Path1.add(1, p1);
		Path1.add(2, p2);
		Path1.add(3, p3);
		Path1.add(4, d1_ll);
		Path1.add(5, d2_ll);
		Path1.add(6, p4);
		
		Path2 = new GenericList<PointT>();
		Path2.GenericList();
		Path2.add(0, safe_ll);
		Path2.add(1, d1_ll);
		Path2.add(2, d2_ll);
		
		Path3 = new GenericList<PointT>();
		Path3.GenericList();
		Path3.add(0, safe_ll);
		Path3.add(1, d1_ll);
		Path3.add(2, d2_ll);
		Path3.add(3, p5);

		// ------ OBSTACLES ------
		Obstacles = new GenericList<RegionT>();
		Obstacles.GenericList();
		Obstacles.add(0, o1_r);
		Obstacles.add(1, o2_r);
		Obstacles.add(2, o3_r);
				
		// ------ DESTINATIONS ------
		Destinations = new GenericList<RegionT>();
		Destinations.GenericList();
		Destinations.add(0, d1_r);
		Destinations.add(1, d2_r);
					
		// ------ SAFEZONES ------
		Safezones = new GenericList<RegionT>();
		Safezones.GenericList();
		Safezones.add(0, safe_r);
		
		// ------ MAP ------
		map = new Map();
		((robot.Map) map).init(Obstacles, Destinations, Safezones);

		// ------ PATH ------
		path = new PathT();
		((PathT) path).init(Path1);
		((PathT) path).init(Path2);
		((PathT) path).init(Path3);
		
		// ------ PATH CALCULATION ------
		calc = new PathCalculation();
		
	}
	
	// @brief test_is_validSegment_1 method
	// @details checks to see if segment between two points is valid
	@Test
	public void test_is_validSegment_1() throws InvalidPositionException, InvalidPointException, FullSequenceException, InvalidRegionException {
		boolean result = ((PathCalculation) calc).is_validSegment(p1, p2);
		boolean expected = true;
		assertEquals(expected,result);
	}
	
	// @brief test_is_validSegment_2 method
	// @details checks to see if segment between two points is invalid
	@Test
	public void test_is_validSegment_2() throws InvalidPositionException, InvalidPointException, FullSequenceException, InvalidRegionException {
		boolean result = ((PathCalculation) calc).is_validSegment(p1, p5);
		boolean expected = false;
		assertEquals(expected,result);
	}
	
	// @brief test_is_PathSegment_1 method
	// @details checks to see if a path is valid
	@Test
	public void test_is_validPath_1() throws InvalidPositionException, InvalidPointException, FullSequenceException, InvalidRegionException {
		boolean result = ((PathCalculation) calc).is_validPath(Path1);
		boolean expected = true;
		assertEquals(expected,result);
	}
	
	// @brief test_is_PathSegment_2 method
	// @details checks to see if a path is invalid
	@Test
	public void test_is_validPath_2() throws InvalidPositionException, InvalidPointException, FullSequenceException, InvalidRegionException {
		boolean result = ((PathCalculation) calc).is_validPath(Path3);
		boolean expected = false;
		assertEquals(expected,result);
	}
	
	// @brief test_is_shortestPath_1 method
	// @details checks to see if a path is the shortest path
	@Test
	public void test_is_shortestPath_1() throws InvalidPositionException, InvalidPointException, FullSequenceException, InvalidRegionException {
		boolean result = ((PathCalculation) calc).is_shortestPath(Path1);
		boolean expected = true;
		assertEquals(expected,result);
	}
	

	// @brief test_is_shortestPath_2 method
	// @details checks to see if a path is not the shortest path
	@Test
	public void test_is_shortestPath_2() throws InvalidPositionException, InvalidPointException, FullSequenceException, InvalidRegionException {
		boolean result = ((PathCalculation) calc).is_shortestPath(Path3);
		boolean expected = false;
		assertEquals(expected,result);
	}
	
	// @brief test_totalDistance_1 method
	// @details checks to see if total distance calculation is correct
	@Test
	public void test_totalDistance_1() throws InvalidPositionException, InvalidPointException, FullSequenceException, InvalidRegionException {
		double expected = 375.0;
		double result = ((PathCalculation) calc).totalDistance(Path1);
		double delta = 0.001; // margin of error
		assertEquals(expected,result,delta);
	}
	
	// @brief test_totalDistance_2 method
	// @details checks to see if total distance calculation is correct
	@Test
	public void test_totalDistance_2() throws InvalidPositionException, InvalidPointException, FullSequenceException, InvalidRegionException {
		double expected = 386.781;
		double result = ((PathCalculation) calc).totalDistance(Path3);
		double delta = 0.001; // margin of error
		assertEquals(expected,result,delta);
	}
	
	// @brief test_totalTurns_1 method
	// @details checks to see if total turns calculation is correct
	@Test
	public void test_totalTurns_1() throws InvalidPositionException, InvalidPointException, FullSequenceException, InvalidRegionException {
		int expected = 5;
		int result = ((PathCalculation) calc).totalTurns(Path1);
		assertEquals(expected,result);
	}
	
	// @brief test_totalTurns_2 method
	// @details checks to see if total turns calculation is correct
	@Test
	public void test_totalTurns_2() throws InvalidPositionException, InvalidPointException, FullSequenceException, InvalidRegionException {
		int expected = 2;
		int result = ((PathCalculation) calc).totalTurns(Path3);
		assertEquals(expected,result);
	}
	
	// @brief test_estimatedTime_1 method
	// @details checks to see if estimated time calculation is correct
	@Test
	public void test_estimatedTime_1() throws InvalidPositionException, InvalidPointException, FullSequenceException, InvalidRegionException {
		double expected = 24.595;
		double result = ((PathCalculation) calc).estimatedTime(Path1);
		double delta = 0.001; // margin of error
		assertEquals(expected,result,delta);
	}
	
	// @brief test_estimatedTime_2 method
	// @details checks to see if estimated time calculation is correct
	@Test
	public void test_estimatedTime_2() throws InvalidPositionException, InvalidPointException, FullSequenceException, InvalidRegionException {
		double expected = 19.556;
		double result = ((PathCalculation) calc).estimatedTime(Path3);
		double delta = 0.001; // margin of error
		assertEquals(expected,result,delta);
	}
}
