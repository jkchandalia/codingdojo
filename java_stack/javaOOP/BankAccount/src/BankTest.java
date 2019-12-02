
public class BankTest {
	public static void main(String[] args) {
		BankAccount b = new BankAccount();
		System.out.println(BankAccount.getAllMoney());
		b.deposit(100, "checking");
		System.out.println(BankAccount.getAllMoney());
		System.out.println(BankAccount.getNumAccts());
	}
}
