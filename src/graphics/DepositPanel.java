package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import entity.DepositButton;
import entity.EntryBox;
import functions.Deposit;
import main.Main;

public class DepositPanel extends JPanel {
	private static final long serialVersionUID = 2090L;
	EntryBox accountNumberFieldBox;
	EntryBox moneyFieldBox;
	DepositButton dButton;
	Deposit deposit;
	DepositPanel depositPanel;
	
	public DepositPanel(Main main, BankPanel bankPanel) {
		this.depositPanel = this;
		this.accountNumberFieldBox = new EntryBox();
		this.moneyFieldBox = new EntryBox();
		this.dButton = new DepositButton();
		this.deposit = new Deposit();
		this.setLayout(null);
		this.setBounds(0, 0, 800, 600);
		this.setBackground(Color.CYAN);
		accountNumberFieldBox.setBounds(314, 150, 150, 25);
		moneyFieldBox.setBounds(314, 250, 150, 25);
		dButton.setBounds(314, 350, 150, 25);
		moneyFieldBox.setText("Amount");
		this.add(accountNumberFieldBox);
		this.add(moneyFieldBox);
		this.add(dButton);
		
		dButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String accountNumberString = accountNumberFieldBox.getText();
				String moneyString = moneyFieldBox.getText();
				int accountNumber = Integer.parseInt(accountNumberString);
				double money = Double.parseDouble(moneyString);
				deposit.deposit(accountNumber, money, main.bDatabase);
				main.remove(depositPanel);
				main.add(bankPanel);
				main.revalidate();
				main.repaint();
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
