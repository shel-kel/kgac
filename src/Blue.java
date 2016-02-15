import java.util.Random;

// Blue is a helper class that automates some things I have to write frequently.
// Written by: Anthoni Caravello
// Started: 11/27/15 
// Last edited: 11/27/15


public class Blue {

	public Blue() {
		// TODO Auto-generated constructor stub
	}

	
	public static void printArray(int[] arr, int length){
		//Prints array arr with length length
		for (int i = 0; i < length; i++)
			System.out.println(arr[i]);
	}
	
	public static int randomInt(int n){
		//Returns a random int between 0 inclusive and n inclusive
		Random random = new Random();
		return random.nextInt(n+1);
	}
	
	public static void pl(String s){
		//A more efficient version of println
		System.out.println(s);
	}
	
	public static void p (String s){
		//A more efficient version of print
		System.out.print(s);
	}
	
	public static void pl(int i){
		//A more efficient version of println
		System.out.println(i);
	}
	
	public static void p(int i){
		//A more efficient version of print
		System.out.print(i);
	}
	
	public static void pl(Object o){
		//A more efficient version of println
		System.out.println(o);
	}
	
	public static void p (Object o){
		//A more efficient version of print
		System.out.print(o);
	}
}
