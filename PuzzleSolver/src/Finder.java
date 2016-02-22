import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class Finder {
	
	String[][] puzzle;
	
	
	
	public Finder(String[][] puzzle){
		
		this.puzzle = puzzle;
		
		
	}
	
	public ArrayList<String> findAllWords(int m){
		ArrayList<String> rtn = new ArrayList<String>();
		
		for (int r = 0; r<puzzle.length; r++){
			for (int c = 0; c<puzzle.length; c++){
				ArrayList<String> um = findwords(m, r, c, new ArrayList<Point>());
				rtn.addAll(um);
			}
		}
		
		return rtn;
		
	}
	
	public ArrayList<String> findwords(int m, int r, int c, ArrayList<Point> usedSet){
		
		Point tCheck = new Point(r, c);
		
	
		
		if ((m<=0)||(r<0)||(c<0)||(r>=puzzle.length)|| (c>=puzzle.length) ||usedSet.contains(tCheck)){
			
			ArrayList<String> rtn = new ArrayList<String>();
			usedSet.add(tCheck);
			return rtn;
			
		}
		
		String letter = puzzle[r][c];
		;
		
		if (m==1){
						
			ArrayList<String> rtn = new ArrayList<String>();
			rtn.add(puzzle[r][c]);
			return rtn;
		}
		
		ArrayList<String> results = new ArrayList<String>();
		
		for (int rowMod = -1; rowMod<=1; rowMod++){
			for (int colMod = -1; colMod<=1; colMod++){
				int nr = r+rowMod;
				int nc = c+colMod;
				if (!(rowMod==0 && colMod==0)){
					ArrayList<Point> copy = new ArrayList<Point>(usedSet);
					
					
					ArrayList<String> subwords = findwords(m-1, nr, nc, copy);
					for (int i = 0; i<subwords.size(); i++){
						
						subwords.set(i, letter+subwords.get(i));
					
						results.add(subwords.get(i));
				}
				
				
					
					
				}
			}
		}
		
		return results;
		
		
	}
	
	
	
}
