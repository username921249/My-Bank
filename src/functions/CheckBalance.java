package functions;

import java.util.ArrayList;

import database.BankAccount;
import database.BankDatabase;

public class CheckBalance {
	int accountNumber;
	BankDatabase bDatabase;
	
	public double getMoney(int accountNumber, BankDatabase bDatabase) {
		ArrayList<BankAccount> bankAccounts = bDatabase.bankAccounts;
		double money = 0;
		for (BankAccount bAccount : bankAccounts) {
			if (accountNumber == bAccount.accountNumber) {
				money = bAccount.money;
				break;
			}
		}
		return money;
	}
	
}
