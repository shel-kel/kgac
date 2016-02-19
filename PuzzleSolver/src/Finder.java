import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class Finder {
	
	String[][] puzzle;
	
	public Finder(String[][] puzzle){
		
		this.puzzle = puzzle;
		
	}
	
	public ArrayList<String> findwords(int m, int r, int c, ArrayList<Point> usedSet){
		
		Point tCheck = new Point(r, c);
		
		if ((m<=0)||(r<0)||(c<0)||usedSet.contains(tCheck)){
			
			//return empty list
			
		}
		
		String letter = puzzle[r][c];
		usedSet.add(new Point(r, c));
		
		if (m==1){
			
			//return usedSet?
		}
		
		ArrayList<String> results = new ArrayList<String>();
		
		for (int rowMod = -1; rowMod<1; rowMod++){
			for (int colMod = -1; colMod<=1; colMod++){
				int nr = r+rowMod;
				int nc = c+colMod;
				
				ArrayList<Point> copy = new ArrayList<Point>(usedSet);
				
				
				ArrayList<String> subwords = findwords(m-1, nr, nc, copy);
				for (int i = 0; i<subwords.size(); i++){
					
					subwords.set(i, letter+subwords.get(i));
					results.add(subwords.get(i));
					
					
				}
			}
		}
		
		return results;
		
		
	}
	
	
	
}