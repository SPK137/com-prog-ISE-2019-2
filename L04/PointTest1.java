import java.util.Scanner;

public class PointTest1{
	public static void main(String[] args){
		var sc = new Scanner(System.in);
		System.out.println("First Point's x-coordinate:" );
		double x1 = sc.nextDouble();
		System.out.println("First Point's y-coordinate:");
		double y1 = sc.nextDouble();
		var point1 = new Point(x1,y1);
		System.out.println("Second Point's x-coordinate:");
		double x2 = sc.nextDouble();
		System.out.println("Second Point's y-coordinate:");
		double y2 = sc.nextDouble();
		var point2 = new Point(x2,y2);
		System.out.println("Distance between (" + point1.x + "," + point1.y +") and (" + point2.x + "," + point2.y + ") is " + point1.distance(point2)) ;
	}
}