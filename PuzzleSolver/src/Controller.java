//Holds an instance of Filter, Finder, and View
//Receives information from Filter and Finder to pass to View

public class Controller
{
	public static void main(String[] args)
	{
		Filter fil = new Filter();
		View v = new View();
		String[][] puzzle = v.getMatrix();//placeholder until we can get the method to get the puzzle from the user.
		Finder fin = new Finder(puzzle);
	}
}