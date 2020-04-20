import java.util.Scanner;
import java.io.*;

public class TextProcessor{
	public static void main(String[] args) throws IOException{
		var input = new Scanner(new File("score.csv")).useDelimiter("\\r\\n|,");
		input.nextLine();	
		int dataAmount = 0;

		int[] score = {0, 0, 0, 0, 0};
		int[] maxScore = {-1, -1, -1, -1, -1,};
		int[] minScore = {0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF};
		double[] sum = {0,0,0,0,0};
		double[] squareSum = {0,0,0,0,0};

		int totalScore = 0;
		double maxTotal = -1, minTotal = 0xFFFFFF, sumTotal = 0, squareSumTotal = 0;
		while(input.hasNext()){
			dataAmount++;
			totalScore = 0;
			System.out.println(input.next());
			for(int j =0; j < 5 ;j++){
				score[j] = input.nextInt();
				maxScore[j] = Math.max(maxScore[j], score[j]);
				minScore[j] = Math.min(minScore[j], score[j]);
				sum[j] += score[j];
				totalScore += score[j];
				squareSum[j] += Math.pow(score[j],2);
			}
			sumTotal += totalScore;
			squareSumTotal += Math.pow(totalScore, 2);
			maxTotal = Math.max(maxTotal, totalScore);
			minTotal = Math.min(minTotal, totalScore);
		}
		double mean, sd;
		for(int i =0 ; i< 5; i++){
			mean = sum[i]/dataAmount;
			sd = Math.sqrt( squareSum[i]/dataAmount - Math.pow(mean,2) );
			System.out.println("For Question " + (i+1));
			System.out.println("Average=" + mean);
			System.out.println("SD=" + sd);
			System.out.println("Max=" + maxScore[i]);
			System.out.println("Min=" + minScore[i]);
		}
		mean = sumTotal/dataAmount;
		sd = Math.sqrt( squareSumTotal/dataAmount - Math.pow(mean,2) );
		System.out.println("For all ");
		System.out.println("Average=" + mean);
		System.out.println("SD=" + sd);
		System.out.println("Max=" + maxTotal);
		System.out.println("Min=" + minTotal);
	}
}