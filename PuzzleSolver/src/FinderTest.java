import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class FinderTest {
	
	Finder finder;
	String[][] puzzle;
	

	@Test
	public void test() {
		
		puzzle = new String[3][3];
		
		puzzle[0][0] = "b";
		puzzle[0][1] = "a";
		puzzle[0][2] = "t";
		puzzle[1][0] = "a";
		puzzle[1][1] = "i";
		puzzle[1][2] = "l";
		puzzle[2][0]= "w";
		puzzle[2][1] = "o";
		puzzle[2][2]= "e";
		System.out.println(puzzle[0][0]+puzzle[0][1]+puzzle[0][2]);
		System.out.println(puzzle[1][0]+puzzle[1][1]+puzzle[1][2]);
		System.out.println(puzzle[2][0]+puzzle[2][1]+puzzle[2][2]);
		
		Finder finder = new Finder(puzzle);
		
		ArrayList<String> thing = finder.findAllWords(3);
		for (int i = 0; i < thing.size(); i++){
			Blue.pl(thing.get(i));
		}
		
		
		
		

		
	}

}
