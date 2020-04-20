import java.util.Scanner;
import java.math.BigInteger;

public class L10{

	static double[] dataArray;
	static int methodCallCount = 0;

	public static void main(String[] args){
		var input = new Scanner(System.in);
		int n = input.nextInt();
		dataArray = new double[n+1];
		System.out.println( computeF(n) );
		System.out.println(methodCallCount);
	}

	private static double computeF(int n){

		methodCallCount++;

		if( dataArray[n] != 0f ){
			return dataArray[n];
		}
		else if (n <= 2){
			return dataArray[n] = 1;
		}
		else{
			return dataArray[n] = computeF(n-1) + computeF(n-2) + computeF(n-3); 
		}
	}

}