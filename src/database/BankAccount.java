package database;

public class BankAccount {
	public int accountNumber;
	public String accountHolder;
	public double money;
	
	public BankAccount() {
		
	}
	
	public BankAccount(int accountNumber, String accountHolder, double money) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.money = money;
	}
}
