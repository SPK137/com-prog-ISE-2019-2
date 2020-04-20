import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PointTest2{
	public static void main(String[] args) throws IOException{
		var reader = new BufferedReader( new FileReader("location.txt"));
		int x = Integer.parseInt(reader.readLine());
		int y = Integer.parseInt(reader.readLine());
		var point1 = new Point( x, y );
		System.out.println(point1.x + "," + point1.y  );
	}
}