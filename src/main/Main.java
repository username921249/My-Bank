package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import database.BankDatabase;
import graphics.BankPanel;
import graphics.CheckPanel;
import graphics.CreatePanel;
import graphics.DeletePanel;
import graphics.DepositPanel;
import graphics.WithdrawPanel;

public class Main extends JFrame {
    
    private static final long serialVersionUID = 666;
    public BankPanel bPanel;
    public CreatePanel createPanel;
    public CheckPanel checkPanel;
    public DepositPanel dPanel;
    WithdrawPanel wPanel;
    DeletePanel deletePanel;
    public BankDatabase bDatabase = new BankDatabase();
    java.lang.reflect.Type listType = new TypeToken<BankDatabase>(){}.getType();
    String json = readJsonFromFile("D:/New folder/Bank/src/accounts.json");

    public Main() {
        // Set up the JFrame first
        this.setLayout(null);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Nemuturi Bank");
        bDatabase = new Gson().fromJson(json, listType);

        // Initialize createPanel first
        bPanel = new BankPanel(this, null, null, null, null, null);
        createPanel = new CreatePanel(this, bPanel);
        checkPanel = new CheckPanel(this, bPanel);
        dPanel = new DepositPanel(this, bPanel);
        wPanel = new WithdrawPanel(this, bPanel);
        deletePanel = new DeletePanel(this, bPanel);

        // Now initialize bPanel after createPanel is set
        bPanel.setPanels(createPanel, checkPanel, dPanel, wPanel, deletePanel);

        // Add bPanel to JFrame
        this.add(bPanel);

        // Now make the JFrame visible
        this.setVisible(true);
    }
    
    public static String readJsonFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new Main();
    }
}
