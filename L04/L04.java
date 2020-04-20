public class L04{
	public static void main (String[] args){
		var point1 = new Point(2,3);
		var dist = point1.distance( Point.origin);
		System.out.println( dist );
		point1.clear();
		System.out.println( point1.distance(Point.origin) );
	}		
}