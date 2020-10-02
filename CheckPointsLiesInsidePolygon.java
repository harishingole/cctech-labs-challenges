class Polygon{ 
	
	static int MAX = 10000; 
	static class Point{ 

		double x; 
		double y; 
		public Point(double x, double y){ 
			
			this.x = x; 
			this.y = y; 
		} 
}; 

	static boolean onSegment(Point p, Point q, Point r){
	 
		if (q.x <= Math.max(p.x, r.x) && 
		q.x >= Math.min(p.x, r.x) && 
		q.y <= Math.max(p.y, r.y) && 
		q.y >= Math.min(p.y, r.y)){ 
				return true; 
		} 
			return false; 
		} 

	static int orientation(Point p, Point q, Point r) {
	 
		double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y); 
		if (val == 0){ 
			return 0; // colinear 
		}
			return (val > 0) ? 1 : 2; // clock or Anticlock wise 
		} 

	static boolean doIntersect(Point p1, Point q1, Point p2, Point q2){ 
	
		int orientation1 = orientation(p1, q1, p2); 
		int orientation2 = orientation(p1, q1, q2); 
		int orientation3 = orientation(p2, q2, p1); 
		int orientation4 = orientation(p2, q2, q1); 

		// General case 
		if (orientation1 != orientation2 && orientation3 != orientation4) { 
			return true; 
		} 

		// Special Cases 
		// p1, q1 and p2 are colinear and 
		// p2 lies on segment p1q1 
		if (orientation1 == 0 && onSegment(p1, p2, q1)) { 
			return true; 
		} 

		// p1, q1 and p2 are colinear and 
		// q2 lies on segment p1q1 
		if (orientation2 == 0 && onSegment(p1, q2, q1)) { 
			return true; 
		} 

		// p2, q2 and p1 are colinear and 
		// p1 lies on segment p2q2 
		if (orientation3 == 0 && onSegment(p2, p1, q2)) { 
			return true; 
		} 

		// p2, q2 and q1 are colinear and 
		// q1 lies on segment p2q2 
		if (orientation4 == 0 && onSegment(p2, q1, q2)) { 
			return true; 
		} 
		// Doesn't fall in any of the above cases 
		return false; 
	} 

	static boolean isInside(Point polygon[], int n, Point p) { 
			if (n < 3){ 
				return false; 
			} 

		Point extreme = new Point(MAX, p.y); 
		int count = 0, i = 0;
		do{ 
			int next = (i + 1) % n; 
			if (doIntersect(polygon[i], polygon[next], p, extreme)) { 
			if (orientation(polygon[i], p, polygon[next]) == 0) { 
				return onSegment(polygon[i], p, 
				polygon[next]); 
			} 
			count++; 
			} 
			i = next; 
		} while (i != 0); 

		return (count % 2 == 1);  
	} 
	static void result(Point ArrayOFpolygon1[],int n,Point p)
	{
		if (isInside(ArrayOFpolygon1, n, p)) {
		 	System.out.println("True"); 
		}
		else{
			System.out.println("False"); 
		}
	}	
	public static void main(String[] args) {

	 
	 	/*--------------------------CASE 1--------------------------*/
	 		
		/*	Input -$ Polygon$ : $ [[1,0], [8,3], [8,8], [1,5]] $
			$ P $: $ [3,5] $
			Output : True*/
		Point ArrayOFpolygon [] = {	new Point(1,0), 
									new Point(8,3), 
									new Point(8,8), 
									new Point(1,5)};

		
		Point p = new Point(3,5); 
		System.out.println("Its Case 1 :: Output");
		result(ArrayOFpolygon,ArrayOFpolygon.length,p);
		
		
		/*---------------------------CASE 1--------------------------*/
			
		/*	$ Polygon $ : $ [[-3,2], [-2,-0.8], [0,1.2], [2.2,0], [2,4.5]]$
			$ P $ : $[0,0]$
			Output : False
			*/
		Point ArrayOFpolygon1 [] = {	new Point(-3, 2), 
						new Point(-2, -0.8), 
						new Point(0, 1.2), 
						new Point(2.2, 0),
						new Point(2,4.5) };

		Point p1 = new Point(0,0);
		System.out.println("Its Case 2 :: Output");
		result(ArrayOFpolygon1,ArrayOFpolygon1.length,p1);
	} 
}
