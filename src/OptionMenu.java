import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

// A good explanation of java variable vs field, property,etc
// https://stackoverflow.com/questions/10115588/what-is-the-difference-between-field-variable-attribute-and-property-in-java

// Also Learn more about Data Structures to dive deep on array, linked list,stack,queue,binary tree,etc.
// https://www.geeksforgeeks.org/data-structures/?ref=lbp

// This project is to make an automated teller machine
// with user's account and password, bank account, with that user are
// able to withdraw, deposit, and view their account balance

public class OptionMenu extends Account{
	
//	public OptionMenu(int username, int password) {
//		super(username, password);
//		// TODO Auto-generated constructor stub
//	}

	public Scanner scanner = new Scanner(System.in);
	
	public void login() {
		int x = 1;
		do {
			try {
				
				addDatabase(); // add the credentials/database(HashMap)
				
				System.out.println("Welcome to the ATM Project!");
				System.out.print("Enter Your Customer Number : ");
				setUsername(checkInput(scanner.nextInt()));
					
				System.out.print("Enter Your Pin Number :");
				setPassword(checkInput(scanner.nextInt()));
					
				// Check if username & password the same as the HashMap credentials
				checkCredential(getUsername(),getPassword());
					
			} catch (InputMismatchException e) {
				System.out.println("Please enter with numbers only not characters");
				x = 2;
			}
		} while(x == 1);
		
	}
	
	// Function for checking negative values,stop them and close the program
	public int checkInput(int input) {
		String stringInput = Integer.toString(input);
		checkAccountAddedOrNot = true; // stop the HashMap credentials from adding the same values from being called MainMenu()
		// For negative value input
		if(input < 0) {
			System.out.println("Please enter the username/password without negative values");
			login();
		}
		// For blank input /***********DOESN'T WORK FIX IT ARGHHHHH**********/
		else if(stringInput.isEmpty()) {
			System.out.println("Please enter the number of username/password");
			login();
		}

		return input;
	}
	

	// Function checking credentials
	public void checkCredential(int username, int password) {
		
		// This solution is hard for us to get the Keys, so user the other solution

		// Explanation from a discord user about this solution : 
		
		// You don't have to check if the password is in the hashmap (it shouldnt!) 
		// You have only to get the entry of the username. 
		// If the user is there: you get the password and you should check the retrieved password if its correct. 
		// Or if the username isnt in the map you get null
		
		// credentials.get(username) ngambil password bukan username wkwkwkkw
		// username itu "key" nya. "value"nya itu password.
		
		
//		try {
//	        if (credentials.get(username) == password) {
//	            System.out.println("Welcome user : " + getUsername());
//	            credentialsMatch = true;
//	            MainMenu();
//	        } else {
//	        	System.out.println("Incorrect username or password. Please try again.");
//	            login();
//	        }
//		} catch(NullPointerException e) {
//        	System.out.println("Incorrect username or password. Please try again.");
//            login();
//		}
		
        // The solution below also works but too complicated, but you can only get values of the solution above
		// This is... idk man learn more about data structures/ java collection
		// learn set & hashset, hashmap interface entryset() idk bruh
		// The source of this solution : https://www.programiz.com/java-programming/examples/get-key-from-hashmap-using-value
		
		for (Map.Entry<Integer, Integer> entry : credentials.entrySet()) {
			if(entry.getKey() == username && entry.getValue() == password) {
				credentialsMatch = true;
				break;
			}
		}
	    if (credentialsMatch) {
	    	System.out.println("Welcome user : " + getUsername());
	        MainMenu();
	    } else {
	        System.out.println("Incorrect username or password. Please try again.");
	        login();
	    }
		
	}
	
	// reset the username,password & etc when they exit back to login menu
	public void resetCredentials() {
		credentialsMatch = false;
		checkingAccountSelected = false;
		savingAccountSelected = false;
		System.out.println("Logging out");
		setUsername(0);
		setPassword(0);
	}
	
	public void MainMenu() {
		System.out.println("Select the Account you want to access: ");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");
		System.out.print("Choice: ");
		switch(scanner.nextInt()) {
			case 1:
				checkingAccountSelected = true;
				CheckingAccountMenu();
				break;
			case 2:
				savingAccountSelected = true;
				SavingAccountMenu();
				break;
			case 3:
				resetCredentials();
				login();
				break;
			default : 
				System.out.println("Please enter your choice");
				MainMenu();
		}
	}
	
	public void CheckingAccountMenu() {
		System.out.println("Checking Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice: ");
		switch(scanner.nextInt()) {
			case 1: 
				System.out.println("Checking Account Balance: " + getCheckBalance());
				CheckingAccountMenu();
				break;
			case 2: 
				// finish this function
				System.out.print("How much would you like to widthdraw :");
				int withdrawBalance = scanner.nextInt();
				withdrawFundsCalc(checkWithdrawInput(withdrawBalance));
				CheckingAccountMenu();
				break;
			case 3: 
				System.out.print("How much would you like to deposit :");
				int depositBalance = scanner.nextInt();
				depositFundsCalc(checkDepositInput(depositBalance));
				CheckingAccountMenu();
				break;
			case 4: 
				resetCredentials();
				login();
				break;
			default : 
				System.out.println("Please enter the number of choice");
				CheckingAccountMenu();
				
		}
	}
	
	public void SavingAccountMenu() {
		System.out.println("Saving Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice: ");
		switch(scanner.nextInt()) {
		case 1: 
			System.out.println("Checking Account Balance: " + getSavingBalance());
			SavingAccountMenu();
			break;
		case 2: 
			// finish this function
			System.out.print("How much would you like to widthdraw :");
			int withdrawBalance = scanner.nextInt();
			withdrawFundsCalc(withdrawBalance);
			SavingAccountMenu();
			break;
		case 3: 
			System.out.print("How much would you like to deposit :");
			int depositBalance = scanner.nextInt();
			depositFundsCalc(depositBalance);
			SavingAccountMenu();
			break;
		case 4: 
			resetCredentials();
			login();
			break;
		default : 
			System.out.println("Please enter the number of choice");
			SavingAccountMenu();
		}
		
	}
	

}
