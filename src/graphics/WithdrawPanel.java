package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import entity.EntryBox;
import entity.WithdrawButton;
import functions.Withdraw;
import main.Main;

public class WithdrawPanel extends JPanel {
	private static final long serialVersionUID = 889L;
	BankPanel bPanel;
	Main main;
	EntryBox accountNumberBox;
	EntryBox moneyBox;
	WithdrawButton wButton;
	WithdrawPanel wPanel;
	Withdraw withdraw;
	
	public WithdrawPanel(Main main, BankPanel bPanel) {
		this.wPanel = this;
		this.main = main;
		this.bPanel = bPanel;
		this.accountNumberBox = new EntryBox();
		this.moneyBox = new EntryBox();
		this.wButton = new WithdrawButton();
		this.withdraw = new Withdraw();
		this.setLayout(null);
		this.setBounds(0, 0, 800, 600);
		this.setBackground(Color.CYAN);
		wButton.setBounds(314, 350, 150, 25);
		accountNumberBox.setBounds(314, 150, 150, 25);
		moneyBox.setBounds(314, 250, 150, 25);
		moneyBox.setText("Amount");
		this.add(accountNumberBox);
		this.add(moneyBox);
		this.add(wButton);
		
		wButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String accountNumberString = accountNumberBox.getText();
				String moneyString = moneyBox.getText();
				int accountNumber = Integer.parseInt(accountNumberString);
				double money = Double.parseDouble(moneyString);
				withdraw.withdraw(accountNumber, money, main.bDatabase);
				main.remove(wPanel);
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
