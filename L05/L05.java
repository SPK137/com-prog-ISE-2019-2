import java.util.Scanner;

public class L05{

	public static void main(String[] args){
		var sc = new Scanner(System.in);
		System.out.print("Set your username :");
		String username = sc.nextLine();
		boolean correctUsername = false,correctPassword = false;
		//for username
		if(username.length() >= 4 && username.length() <= 255)
			if( (username.charAt(0) >= 'A' && username.charAt(0) <= 'Z') || (username.charAt(0) >= 'a' && username.charAt(0) <= 'z') ){
				correctUsername= true;
				for(int i = 1 ; i < username.length() & correctUsername ; i++){
					if( username.charAt(i) == ' ' || username.charAt(i) == '\\' || (username.charAt(i) == '.' && username.charAt(i-1) == '.' ) )
						correctUsername = false;
				}
			}
		//for password
		if(correctUsername){
			System.out.print("Set your password :");
			String password = sc.nextLine();
			if(password.length() >= 4 && password.length() <= 255)
				if( !password.toUpperCase().matches(username.toUpperCase()) ){
					correctPassword = true;
					int numberCounter = 0, symbolCounter = 0;
					for(int i = 0 ; i < password.length() & correctPassword ; i++){
						if( i+username.length() <= password.length())
							if(password.substring(i,i+username.length()).toUpperCase().matches(username.toUpperCase()))
								correctPassword = false;
						if( password.charAt(i) == ' ' || password.charAt(i) == '\\' || password.charAt(i) == '*' )
							correctPassword = false;
						if( password.charAt(i) >= '0' && password.charAt(i) <= '9')
							numberCounter++;
						if( password.charAt(i) == '!' || password.charAt(i) == '@' || password.charAt(i) == '#' || password.charAt(i) == '$' || password.charAt(i) == '%' )
							symbolCounter++;
					}
					if(password.length() < 8)
						if(numberCounter < 2 || symbolCounter < 1)
							correctPassword = false;
				}
			System.out.print("Confirm your password :");
			String confirmPassword = sc.nextLine();
			if(!password.matches( confirmPassword ))
				correctPassword = false; 
		}
		if( correctPassword && correctUsername)
			System.out.println("The account has been successfully created.");	
	} 
}