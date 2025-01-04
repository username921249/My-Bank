package functions;

import java.io.File;
import java.io.FileWriter;

import com.google.gson.Gson;

import database.BankAccount;
import database.BankDatabase;

public class Withdraw {
	File file = new File("D:/New folder/Bank/src/accounts.json");
	Gson gson = new Gson();
	public void withdraw(int accountNumber, double money, BankDatabase bankDatabase) {
		int index = 0;
		for (BankAccount bAccount : bankDatabase.bankAccounts) {
			if (accountNumber == bAccount.accountNumber) {
				index = bankDatabase.bankAccounts.indexOf(bAccount);
			}
		}
		bankDatabase.bankAccounts.get(index).money -= money;
		try(FileWriter fileWriter = new FileWriter(file)) {
			fileWriter.write(gson.toJson(bankDatabase));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}