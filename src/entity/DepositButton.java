package entity;

import java.awt.Graphics;

import javax.swing.JButton;

public class DepositButton extends JButton{
	private static final long serialVersionUID = 699;
	
	public DepositButton() {
		this.setText("Deposit Money");
		this.setBounds(314, 300, 150, 25);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
