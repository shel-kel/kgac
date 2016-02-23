import java.io.IOException;
import java.util.ArrayList;

//Object jobs: 
//Receives a list of strings
//Creates a list of strings that are real words
//using the dictionary
//returns said list
public class Filter {
	Dictionary dictionary;

	public Filter() {

		try {
			dictionary = new Dictionary();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<String> fetchRealWords(ArrayList<String> stringList) {

		ArrayList<String> rtn = new ArrayList<String>();

		for (int i = 0; i < stringList.size(); i++) {

			String s = stringList.get(i);
			boolean isReal;
			if (dictionary.contains(s)) {
				isReal = true;
			} else {
				isReal = false;
			}

			if (isReal) {
				rtn.add(s);
			}

		}

		return rtn;

	}

}
