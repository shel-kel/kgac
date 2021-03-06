import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Dictionary {
	
	
	private ConcurrentSkipListSet<String> dicList;
	//This list is the current and most up-to-date list of words, which
	//the user accesses when calling contains(). 
	// 
	// 
	//
	public Dictionary() throws IOException{
		
		//The list is initialized on construction, but is filled by one of two functions - 
		//either "update" or "startWithoutUpdate", depending on whether the cache is up to date. 
		
		
		dicList = new ConcurrentSkipListSet<String>();
		
		
		if (!cacheIsMostRecent()){ //If any member of the dict file was editted more recently than the cache
			Blue.pl("cache was not most recent");
			update(); //Changes the cache to match the contents of the dict file, and passes these contents to the dicList
		} else if (cacheIsMostRecent()){ //otherwise...
			Blue.pl("cache was most recent");
			startWithoutUpdate(); //Fills the dicList based on the contents of the current cache
		}
	
		
	}
	
	//Update is called by the constructor if it finds that cacheIsMostRecent returns false. 
	//
	private void update(){
		String emptyString = "";
		//added for git testing reasons
		
		String emptyString2 = "";
		//added again for git testing reasons
		
		//creates handles for the list, the file containing the dictionary files, and an array of said files
		dicList = new ConcurrentSkipListSet<String>();
		File dir = new File("dict");
		File[] dicFiles = dir.listFiles();
		
		for (int k = 0; k < dicFiles.length; k++){ //Iterates over every file in the array 
			BufferedReader br = null;
			try{
				FileReader fr = new FileReader(dicFiles[k]);
				br = new BufferedReader(fr);
				
				String line = br.readLine(); //Reads over each file line by line
				while(line != null){
					String[] words = line.split("\\s"); //Creates a list of words out of the file's contents
					for (int i = 0; i < words.length; i++){
						if(words[i].matches("[a-zA-Z]+") && (words[i].length() > 1)){ 
							//adds the words to our dicList given that they are longer than a character and only contain letters
							dicList.add(words[i].toUpperCase());
						}
					}
					line = br.readLine();
				}
			}	
			catch (IOException ex){
				System.err.println("We encountered a problem when reading the file:" + ex.getMessage());
			}
			finally{
				
				try{
					if (br != null){
						br.close();
					}
				}
				catch (Exception ex){
					ex.printStackTrace();
					System.exit(-1);
				}
			}
		}
		
		
		File cache = new File("cache.txt");
		if (cache.exists() == false){ //if there is not an existing cache file, it generates a new one
			try {
				cache.createNewFile();
			} catch (IOException ex) {
				System.err.println("We incountered a problem when writing the cache:" + ex.getMessage());
				ex.printStackTrace();
			}
		}
		PrintWriter pw = null;
		try{
			FileWriter fw = new FileWriter(cache); //Writes the contents of the dicList to the new cache
			BufferedWriter bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			pw.println(dicList.size());
			Iterator<String> itr = dicList.iterator();
			while(itr.hasNext()){
				pw.println(itr.next());
			}
		}
		catch (IOException ex){
			System.err.println("We incountered a problem when writing the cache:" + ex.getMessage());
		}
		finally{
			try{
				if (pw != null){
					pw.close();
				}
			}
			catch (Exception ex){
				ex.printStackTrace();
				System.exit(-1);
			}
		}
	}
		
	
	
	private void startWithoutUpdate() throws IOException{
		
		
		File cache = new File("cache.txt");
		Date cacheDate = new Date(cache.lastModified() * 1000);
		FileInputStream in = new FileInputStream(cache);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String line = null;
		while ((line = br.readLine()) !=null){
			dicList.add(line);
		}
		
		br.close();
	
		
	}
	
	
	public boolean contains(String word){
		//This is the only method that should be called from the main
		//Our dictionary is full of only uppercase letters
		//so we convert the string passed to uppercase and use our list's 
		//'contains' function. 
		return dicList.contains(word.toUpperCase());
	}
	
	
	//Checks the last modified properties of all of the contents of the folder "dict"
	//and assures that none of them were modified after the cache.txt. 
	//returns true if the cache is up to date, false if otherwise. 
	public boolean cacheIsMostRecent(){
		boolean isMostRecent = true;
		//This method assumes the cache is up to date until it encounters a file that contradicts this. 
		
		File cache = new File("cache.txt");
		Date cacheDate = new Date(cache.lastModified() * 1000); //.lastModified returns a long which can be turned into a Date object
		
		File dir = new File("dict");
		
		File[] fileArray = dir.listFiles();
		
		for (int i =0; i<fileArray.length; i++){ //for every file in the folder
			
			Date checkDate = new Date(fileArray[i].lastModified() * 1000); 
			//create a date object matching the time that each file was last modified
			if (checkDate.after(cacheDate)){ //If checkdate is more recent than cachedate
				isMostRecent = false; //change the value of isMostRecent
				break; //and don't bother with checking the rest of the files. 
			}
			
		}
		return isMostRecent;
		
		
		
	}
	
	

	
	
}
