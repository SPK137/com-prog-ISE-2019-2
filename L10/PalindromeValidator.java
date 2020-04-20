import java.util.Scanner;

public class PalindromeValidator{

	static int stringLength;

	public static void main(String[] args){
		var input = new Scanner(System.in);
		String inputString = input.next().toUpperCase();
		inputString = extractAlphabet(inputString);
		stringLength = inputString.length();
		if( isPalindrome(inputString, 0) ){
			if(stringLength == 0)
				System.out.println("No alphabet input");
			else	
				System.out.println(inputString + " is a palindrome");
		}
		else
			System.out.println(inputString + " is not a palindrome");
	}

	private static String extractAlphabet(String inputString){
		
		if( inputString.length() == 0)
			return "";
		if( inputString.charAt(0) < 'A' || inputString.charAt(0) > 'Z' )
			return extractAlphabet(inputString.substring(1));
		return inputString.charAt(0) + extractAlphabet(inputString.substring(1));
	}

	private static boolean isPalindrome(String inputString, int index){

		if(index > stringLength/2 || stringLength == 0) return true;

		char leftSideChar = inputString.charAt(index);
		char rightSideChar = inputString.charAt(stringLength - index - 1); 

		if( leftSideChar == rightSideChar ){
			return isPalindrome(inputString, index+1);
		}
		else{
			return false;
		}
	}
}