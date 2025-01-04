package functions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import database.BankAccount;
import database.BankDatabase;

public class CreateAccount {
	File file = new File("D:/New folder/Bank/src/accounts.json");
	Gson gson = new Gson();
	public void createAccount(int accountNumber, String name, BankDatabase bDatabase) {
		bDatabase.bankAccounts.add(new BankAccount(accountNumber, name, 0));
		try(FileWriter fileWriter = new FileWriter(file)){
			fileWriter.write(gson.toJson(bDatabase));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
