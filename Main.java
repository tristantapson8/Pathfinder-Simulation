package robot;

public class Main {
	
	// map and function testing purposes
	public static void main(String[] args) throws FullSequenceException, InvalidPositionException, InvalidRegionException, InvalidPointException {
		
		// ------ SAFE ZONE A ------
		PointT safe_ll = new PointT(20.0, 20.0);
		// test print
		System.out.println("Safezone_A lower_left: (" + safe_ll.xcrd() + "," + safe_ll.ycrd() + ")");
		
		RegionT safe_r = new RegionT(safe_ll, 15.0, 15.0);
		// test print
		System.out.println("Safezone_A: "  + safe_r + ", width " + safe_r.width + ", height " + safe_r.height);
		System.out.println("");
		
		// ------ OBSTACLE 1 ------
		PointT o1_ll = new PointT(30.0, 50.0);
		// test print
		System.out.println("Obstacle_1 lower_left: (" + o1_ll.xcrd() + "," + o1_ll.ycrd() + ")");
		
		RegionT o1_r = new RegionT(o1_ll, 70.0, 20.0);
		// test print
		System.out.println("Obstacle_1: "  + o1_r + ", width: " + o1_r.width + ", height: " + o1_r.height);
		System.out.println("");
		
		// ------ OBSTACLE 2 ------
		PointT o2_ll = new PointT(55.0, 100.0);
		// test print
		System.out.println("Obstacle_2 lower_left: (" + o2_ll.xcrd() + "," + o2_ll.ycrd() + ")");
				
		RegionT o2_r = new RegionT(o2_ll, 70.0, 30.0);
		// test print
		System.out.println("Obstacle_2: "  + o2_r + ", width: " + o2_r.width + ", height: " + o2_r.height);
		System.out.println("");
		
		// ------ OBSTACLE 3 ------
		PointT o3_ll = new PointT(140.0, 40.0);
		// test print
		System.out.println("Obstacle_3 lower_left: (" + o3_ll.xcrd() + "," + o3_ll.ycrd() + ")");
						
		RegionT o3_r = new RegionT(o2_ll, 30.0, 20.0);
		// test print
		System.out.println("Obstacle_3: "  + o3_r + ", width: " + o3_r.width + ", height: " + o3_r.height);
		System.out.println("");
		
		// ------ DESTINATION 1 ------
		PointT d1_ll = new PointT(145.0, 145.0);
		// test print
		System.out.println("Destination_1 lower_left: (" + d1_ll.xcrd() + "," + d1_ll.ycrd() + ")");
								
		RegionT d1_r = new RegionT(d1_ll, 10.0, 10.0);
		// test print
		System.out.println("Destination_1: "  + d1_r + ", width: " + d1_r.width + ", height: " + d1_r.height);
		System.out.println("");
		
		// ------ DESTINATION 1 ------
		PointT d2_ll = new PointT(30.0, 145.0);
		// test print
		System.out.println("Destination_2 lower_left: (" + d2_ll.xcrd() + "," + d2_ll.ycrd() + ")");
										
		RegionT d2_r = new RegionT(d2_ll, 10.0, 10.0);
		// test print
		System.out.println("Destination_2: "  + d2_r + ", width: " + d2_r.width + ", height: " + d2_r.height);
		System.out.println("");
		
		// ------ TRAVEL PATH POINTS ------
		PointT p1 = new PointT(120.0, 20.0);
		PointT p2 = new PointT(120.0, 85.0);
		PointT p3 = new PointT(145.0, 85.0);
		PointT p4 = new PointT(20.0, 145.0);
		
		// ------ PATH LIST ------
		GenericList<PointT> Path1 = new GenericList<PointT>();
		Path1.GenericList();
		Path1.add(0, safe_ll);
		Path1.add(1, p1);
		Path1.add(2, p2);
		Path1.add(3, p3);
		Path1.add(4, d1_ll);
		Path1.add(5, d2_ll);
		Path1.add(6, p4);
		
		// test path
		GenericList<PointT> Path2 = new GenericList<PointT>();
		Path2.GenericList();
		Path2.add(0, safe_ll);
		Path2.add(1, d1_ll);
		Path2.add(2, d2_ll);
		
		for(int i = 0; i < Path1.size(); i++){
			if (i == 0){
				System.out.print("Points in genList: [" + Path1.getval(i) + ", ");
			}
			else if(i == Path1.size()-1){
				System.out.print(Path1.getval(i) + "]");
			}
			
			else{
				System.out.print(Path1.getval(i) + ", ");
			}
		}
		System.out.println("");
		
		// ------ OBSTACLES LIST ------
		GenericList<RegionT> Obstacles = new GenericList<RegionT>();
		Obstacles.GenericList();
		Obstacles.add(0, o1_r);
		Obstacles.add(1, o2_r);
		Obstacles.add(2, o3_r);
		
		//System.out.println("LLLLLLL" + o2_r.lower_left);
		//System.out.println(" THIS: " + Obstacles.getval(1).lower_left);
		
		for(int i = 0; i < Obstacles.size(); i++){
			if (i == 0){
				System.out.print("Obstacle(s) in genList: [" + Obstacles.getval(i) + ", ");
			}
			else if(i == Obstacles.size()-1){
				System.out.print(Obstacles.getval(i) + "]");
			}
			
			else{
				System.out.print(Obstacles.getval(i) + ", ");
			}
		}
		System.out.println("");
		
		// ------ DESTINATIONS LIST ------
		GenericList<RegionT> Destinations = new GenericList<RegionT>();
		Destinations.GenericList();
		Destinations.add(0, d1_r);
		Destinations.add(1, d2_r);
		
		for(int i = 0; i < Destinations.size(); i++){
			if (i == 0){
				System.out.print("Destination(s) in genList: [" + Destinations.getval(i) + ", ");
			}
			else if(i == Destinations.size()-1){
				System.out.print(Destinations.getval(i) + "]");
			}
			
			else{
				System.out.print(Destinations.getval(i) + ", ");
			}
		}
		System.out.println("");
		
		// ------ SAFEZONES LIST ------
		
 		GenericList<RegionT> Safezones = new GenericList<RegionT>();
		Safezones.GenericList();
		Safezones.add(0, safe_r);
	
		if(Safezones.size() > 1){
			for(int i = 0; i < Destinations.size(); i++){
				if (i == 0){
					System.out.print("Safezone(s) in genList: [" + Safezones.getval(i) + ", ");
				}
				else if(i == Safezones.size()-1){
					System.out.print(Safezones.getval(i) + "]");
				}
					
				else{
					System.out.print(Safezones.getval(i) + ", ");
				}
			}
		}
		else{
			System.out.println("Safezone(s) in genList: [" + Safezones.getval(0) + "]");
		}
		
		System.out.println("");
		
		
		// ------ MAP INITIALIZING ------
		Map m = new Map();
		m.init(Obstacles, Destinations, Safezones);
		System.out.println("Map instance of obstacles(s): " + Map.get_obstacles());
		System.out.println("Map instance of destination(s): " + Map.get_destinations());
		System.out.println("Map instance of safezone(s): " + Map.get_safeZone());
		System.out.println("");
		
	
		
		PointT p5 = new PointT(29.0, 50.0);
		PointT p6 = new PointT(30.0, 50.0);
		//System.out.println(p5.dist(p6));
		
		GenericList<PointT> Path3 = new GenericList<PointT>();
		Path3.GenericList();
		Path3.add(0, safe_ll);
		Path3.add(1, d1_ll);
		Path3.add(2, d2_ll);
		Path3.add(3, p5);
		
		// ------ PATH INITIALIZING ------
		PathT p = new PathT();
		p.init(Path1);
		p.init(Path2);
		p.init(Path3);
		
		// ------ PATH CALCULATIONS ------
		PathCalculation c = new PathCalculation();
		System.out.println(" --------- PATH CALCULATIONS ---------");
		System.out.println("Valid Segement?: " + c.is_validSegment(p1, p2));
		//System.out.println("Valid Segement?: " + c.is_validSegment(p1, p5));
		System.out.println("Valid Path?: " + c.is_validPath(Path1));
		//System.out.println("Valid Path?: " + c.is_validPath(Path3));
		System.out.println("Shortest Path?: " + c.is_shortestPath(Path1));
		//System.out.println("Shortest Path?: " + c.is_shortestPath(Path3));
		System.out.println("Total Distance: " + c.totalDistance(Path1) + " units");
		//System.out.println("Total Distance: " + c.totalDistance(Path3));
		System.out.println("Total Turns: " + c.totalTurns(Path1));
		//System.out.println("Total Turns: " + c.totalTurns(Path3));
		System.out.println("Estimated Time: " + c.estimatedTime(Path1) + " s");
		//System.out.println("Estimated Time: " + c.estimatedTime(Path3));
		
	}
}
