import java.util.HashMap;

public class Database {
	// use HashMap cause 2DArrayList is less suitable in the data structure of this program
	public HashMap<Integer, Integer> credentials = new HashMap<Integer, Integer>();
	
	public boolean checkAccountAddedOrNot = false;

	public void addDatabase () {
		// The if else statement is to not "Loop" the creation of addDatabase()
		if(checkAccountAddedOrNot == false) {
			// add accounts into the database (credentials HashMap)
			credentials.put(9876543,9876);
			credentials.put(8989898,1890);
		} else {}
		
	}
	
}
