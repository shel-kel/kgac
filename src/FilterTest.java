import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class FilterTest {
	
	Filter f = new Filter();

	@Test
	public void test() {
		
		ArrayList<String> testList = new ArrayList<String>();
		
		testList.add("123");
		testList.add("real");
		testList.add("a");
		testList.add("word");
		
		ArrayList<String> newList = f.fetchRealWords(testList);
		
		assertTrue(newList.contains("real"));
		assertTrue(newList.contains("word"));
		assertTrue(!newList.contains("a"));
		assertTrue(!newList.contains("123"));
		
	
		
		
		
		
		
	}

}
