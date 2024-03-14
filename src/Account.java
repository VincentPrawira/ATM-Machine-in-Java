
public class Account extends Database {

	private int username,password;
	public int checkBalance = 0;
	public int savingBalance = 0;
	public boolean credentialsMatch,checkingAccountSelected,savingAccountSelected = false;
	
//	public Account(int username, int password) {
//		this.setUsername(username);
//		this.setPassword(password);
//	}
//	
	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
	public int getCheckBalance() {
		return checkBalance;
	}
	public void setCheckBalance(int checkBalance) {
		this.checkBalance = checkBalance;
	}
	public int getSavingBalance() {
		return savingBalance;
	}
	public void setSavingBalance(int savingBalance) {
		this.savingBalance = savingBalance;
	}
	
	public void withdrawFundsCalc(int withdrawBalance) {
		if(checkingAccountSelected) {
			setCheckBalance(getCheckBalance()-withdrawBalance);
			System.out.println("Your Checking Balance :" +getCheckBalance());
		}else if (savingAccountSelected) {
			setSavingBalance(getSavingBalance()-withdrawBalance);
			System.out.println("Your Checking Balance :" +getSavingBalance());
		}
	}
	
	public void depositFundsCalc(int depositBalance) {
		if(checkingAccountSelected) {
			setCheckBalance(getCheckBalance()+depositBalance);
			System.out.println("Your Checking Balance :" +getCheckBalance());
		}else if (savingAccountSelected) {
			setSavingBalance(getSavingBalance()+depositBalance);
			System.out.println("Your Checking Balance :" +getSavingBalance());
		}
	}
	
	public int checkWithdrawInput(int withdrawBalance) {
		if((getCheckBalance()-withdrawBalance) < 0) {
			System.out.println("You can't withdraw that amount, please deposit first");
			return 0;
		} else if(withdrawBalance < 0) {
			System.out.println("You can't input negative values");
			return 0;
		}
		return withdrawBalance;
	}
	
	public int checkDepositInput(int depositBalance) {
		
		if(depositBalance < 0) {
			System.out.println("You can't input negative values");
			return 0;
		}
		return depositBalance;

	}
	
}
