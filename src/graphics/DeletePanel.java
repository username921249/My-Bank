package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import entity.Delete;
import entity.EntryBox;
import functions.DeleteAccount;
import main.Main;

public class DeletePanel extends JPanel {
	private static final long serialVersionUID = 9L;
	Main main;
	BankPanel bPanel;
	EntryBox accountNumberBox;
	Delete delete;
	DeletePanel deletePanel;
	DeleteAccount deleteAccount;
	
	public DeletePanel(Main main, BankPanel bPanel) {
		this.deletePanel = this;
		this.main = main;
		this.bPanel = bPanel;
		this.accountNumberBox = new EntryBox();
		this.delete = new Delete();
		this.deleteAccount = new DeleteAccount();
		this.setBackground(Color.CYAN);
		this.setBounds(0, 0, 800, 600);
		this.setLayout(null);
		delete.setBounds(314, 150, 150, 25);
		accountNumberBox.setBounds(314, 350, 150, 25);
		accountNumberBox.setText("Account Number");
		this.add(delete);
		this.add(accountNumberBox);
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String accountNumberString = accountNumberBox.getText();
				int accountNumber = Integer.parseInt(accountNumberString);
				deleteAccount.deleteAccount(accountNumber, main.bDatabase);
				main.remove(deletePanel);
				main.add(bPanel);
				main.revalidate();
				main.repaint();
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
