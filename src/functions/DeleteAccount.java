package functions;

import java.io.File;
import java.io.FileWriter;

import com.google.gson.Gson;

import database.BankAccount;
import database.BankDatabase;

public class DeleteAccount {
	File file = new File("D:/New folder/Bank/src/accounts.json");
	Gson gson = new Gson();
	public void deleteAccount(int accountNumber, BankDatabase bDatabase) {
		BankAccount bankAccount = null;
		for (BankAccount bAccount : bDatabase.bankAccounts) {
			if (accountNumber == bAccount.accountNumber) {
				bankAccount = bAccount;
				break;
			}
		}
		bDatabase.bankAccounts.remove(bankAccount);
		try (FileWriter fileWriter = new FileWriter(file)){
			fileWriter.write(gson.toJson(bDatabase));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
