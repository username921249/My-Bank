package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import entity.CheckButton;
import entity.EntryBox;
import functions.CheckBalance;
import main.Main;

public class CheckPanel extends JPanel {
	private static final long serialVersionUID = 9999;
	
	EntryBox entryBox;
	CheckButton cButton;
	CheckPanel checkPanel;
	CheckBalance checkBalance;
	BankPanel bPanel;
	CheckDisplay checkDisplay;
	
	public CheckPanel(Main main, BankPanel bankPanel) {
		checkPanel = this;
		entryBox = new EntryBox();
		cButton = new CheckButton();
		checkBalance = new CheckBalance();
		checkDisplay = new CheckDisplay(main, bankPanel);
		this.bPanel = bankPanel;
		this.setBackground(Color.CYAN);
		this.setLayout(null);
		this.setBounds(0, 0, 800, 600);
		cButton.setBounds(314, 350, 150, 25);
		this.add(cButton);
		this.add(entryBox);
		
		cButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				checkPanel.remove(entryBox);
				checkPanel.remove(entryBox);
				int accountNumber = Integer.parseInt(entryBox.getText());
				double balance = checkBalance.getMoney(accountNumber, main.bDatabase);
				String balance2 = Double.toString(balance);
				checkDisplay.setToRender(balance2);
				main.remove(checkPanel);
				main.add(checkDisplay);
				main.repaint();
				main.revalidate();
			}
			
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
