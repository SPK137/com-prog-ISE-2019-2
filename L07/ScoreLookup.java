import java.util.Scanner;
import java.io.*;

public class ScoreLookup{
	static Scanner userInput = new Scanner(System.in);
	public static void main(String [] args) throws IOException {
		String lookupString = constructLookUpStringFromFile("score.csv");
		boolean toQuit = false;
		do{
			char choice = showMainMenu();
			switch (choice){
				case 'L':
					commenceLookUpProcedure(lookupString);
					break;
				case 'Q':
					toQuit = true;
					break;
				default:
					System.out.println("Invalid choice. Quitting.");
					toQuit = true;
			}
		}while(!toQuit);
	}

	//Add static methods here.
	private static String constructLookUpStringFromFile(String path) throws IOException{
		var scoreInput = new Scanner( new File(path) ).useDelimiter("\\r\\n|,");
		scoreInput.nextLine();
		String inputString = "";
		while(scoreInput.hasNext()){
			int totalScore = 0;
			inputString += scoreInput.next() + "  ";
			for(int i = 0; i < 5 ; i++ ){
				int questionScore = Integer.parseInt(scoreInput.next());
				totalScore += questionScore; 
				inputString += questionScore + "  ";
			}
			inputString += totalScore + "  ";
			
		}
		return inputString;
	}

	private static char showMainMenu(){
		System.out.println("----------------------------------------");
		System.out.println("Main Menu");
		System.out.println("----------------------------------------");
		System.out.println("L ) Look up score");
		System.out.println("Q ) Quit");
		System.out.println("----------------------------------------");
		System.out.print(">>");
		return userInput.next().charAt(0);
	}
	private static void commenceLookUpProcedure(String lookupString){
		System.out.print("Enter student ID:");
		String inquiredID = userInput.next();
		
		if( lookupString.contains(inquiredID) ){
			printScore(lookupString, inquiredID);
		}
		else{
			System.out.println("Scores not found");
		}
	}
	private static void printScore(String lookupString, String inquiredID){
		System.out.println("            Q1 Q2 Q3 Q4 Q5 Total");
		int index = lookupString.indexOf(inquiredID);
		for(int whitespaceCounter = 0 ; whitespaceCounter <= 6*2 ; index++){
			whitespaceCounter += ( lookupString.charAt(index) == ' ' )? 1:0;
			System.out.print(lookupString.charAt(index));
		}
		System.out.println();
} 
}