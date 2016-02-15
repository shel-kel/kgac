import java.io.Console;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	/*
	 * Dictionary by Shel Keller and Anthoni Caravello
	 * 
	 * The main currently creates an instance of a Dictionary object, prompts the user for a word,
	 * and uses the dictionary object to check and report the word's validity. 
	 * The program will continue to accept input until the user inputs 0. 
	 */
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		
		
		String whatever = "Add more changes and commit";
		Dictionary dictionary = new Dictionary();
		
		Blue.pl("Enter a word (or type 0 to exit)"); //It should be noted that Blue.pl is a shorthand for printline. 
		
		boolean looper = true;
		while (looper){
		
		String s = in.nextLine();
		
		if (s.equals("0")){
			
			looper = false;
			
		} else {
		
			if (dictionary.contains(s)){
			//contains is a method which takes a string and returns a boolean. 
			Blue.pl(s+" is a word.");
			
			} else {
			Blue.pl(s+" is not a word.");
			
			}
		
		}
		}
		
		
		
	}

}
