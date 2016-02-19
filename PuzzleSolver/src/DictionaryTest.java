import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class DictionaryTest {

	@Test
	public void testInit() {
		
		//Tests to assure that the dictionary creates a cache if one does not already exist. 
		File cache = new File("cache.txt");
		if (cache.exists() == true){
			cache.delete();
		}
		
		
		try{
			Dictionary dic = new Dictionary();
		}
		catch (IOException ex){
			Blue.pl(ex.getMessage());
			fail();
		}
		assertTrue(cache.exists());
	}
	
	@Test
	public void testContains(){
		
		//Tests the contains method
		boolean pass = false;
		try{
			Dictionary dic = new Dictionary();
			pass = dic.contains("java");
		}
		catch (IOException ex){
			Blue.pl(ex.getMessage());
			fail();
		}
		assertTrue(pass);
	}

}
