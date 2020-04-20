import java.util.Scanner;
import java.io.*;

public class ScoreSort{
	// Do not change main().
	public static void main(String [] args) throws IOException{
		StudentScore[] scores = readScoreFile();	//Read score data from "score.csv" and store the data in an array of StudentScore
		sortByTotal(scores);
		listTop(scores, 20);
	}

	// List neccessary methods here.
	// Do not change method headers.
	public static StudentScore[] readScoreFile() throws IOException{
		var scoreInput = new Scanner( new File("score.csv") ).useDelimiter("\\r\\n");
		scoreInput.nextLine();
		StudentScore[] scores = new StudentScore[1000];
		for(int i = 0 ; i < 1000 ; i++){
			scores[i] = new StudentScore(scoreInput.nextLine());
		}
		return scores;
	}

	public static int findMaxIndex(StudentScore[] data, int lastIndex){
		int maxIndex = 0;
		for(int currentIndex = 0 ; currentIndex <= lastIndex ; currentIndex++){
			if(data[maxIndex].getTotalScore() < data[currentIndex].getTotalScore()){
				maxIndex = currentIndex;
			}
		}
		return maxIndex;
	}

	public static void swapData(StudentScore[] data, int firstIndex, int secondIndex){
		StudentScore temp;
		temp = data[firstIndex];
		data[firstIndex] = data[secondIndex];
		data[secondIndex] = temp;
	}

	public static void sortByTotal(StudentScore[] data){
		int maxIndex;
		for(int lastIndex = data.length-1 ; lastIndex > 0 ; lastIndex--){
			maxIndex = findMaxIndex(data, lastIndex);
			swapData(data, maxIndex,lastIndex);
		}
	}

	public static void listTop(StudentScore[] sortedScores, int n){
		for(int i = sortedScores.length-1 ; i >= sortedScores.length-n ; i--){
			if( i == sortedScores.length-1)
				sortedScores[i].printScore(true);
			else
				sortedScores[i].printScore(false);
		}
	}

}