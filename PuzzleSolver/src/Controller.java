//Holds an instance of Filter, Finder, and View
//Receives information from Filter and Finder to pass to View

public class Controller {
	public static void main(String[] args) {
		View v = new View();
		v.setVisible(true);
		Filter fil = new Filter();
		String[][] puzzle = null;// placeholder until we can get the method to
									// get the puzzle from the user.
		Finder fin = new Finder(puzzle);
	}
}