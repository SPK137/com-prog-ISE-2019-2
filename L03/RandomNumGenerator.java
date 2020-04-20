import java.util.Random;
import java.lang.Math;

public class RandomNumGenerator{
	public static void main(String[] args){
		var random = new Random();
		var sum = 0;
		for(int i=0; i<30 ;i++){
			var rndInt =  Math.max( 1 , Math.min( 10, (int) Math.ceil(random.nextGaussian()*2 ) + 5));
			System.out.println( rndInt + ",");
		}
	}
}