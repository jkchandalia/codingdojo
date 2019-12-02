
public class BankAccount {
	private String account_number;
	private double checking_balance;
	private double savings_balance;
	private static int num_accounts = 0;
	private static double all_money = 0;
	
	public BankAccount() {
		account_number = returnAcctNum();
		num_accounts++;
	}
	private String returnAcctNum() {
		String acct_num = "";
		for (int i =0;i<10;i++) {
			acct_num = acct_num + (int)(Math.random()*(10));
		}
	    return acct_num;
	}
	public double getChecking_balance() {
		return checking_balance;
	}
	public void deposit(double balance, String acct) {
		if (acct == "checking"){
		this.checking_balance += balance;}
		if (acct == "savings") {
			this.savings_balance += balance;}
		BankAccount.all_money += balance;
		}
	
	public void withdraw(double balance, String acct) {
		if (acct == "checking" & checking_balance>balance){
			this.checking_balance -= balance;
			BankAccount.all_money += balance;}
		else if (acct == "savings" & savings_balance>balance) {
			this.savings_balance -= balance;
			BankAccount.all_money += balance;}
		else System.out.println("Insufficient funds.");
		}

	public double getSavings_balance() {
		return savings_balance;
	}
	public double getBalance() {
		return savings_balance + checking_balance;
	}
	public static double getAllMoney() {
		return BankAccount.all_money;
	}
	public static double getNumAccts() {
		return BankAccount.num_accounts;
	}
}
