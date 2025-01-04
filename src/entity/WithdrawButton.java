package entity;

import java.awt.Graphics;

import javax.swing.JButton;

public class WithdrawButton extends JButton{
	private static final long serialVersionUID = 699;
	
	public WithdrawButton() {
		this.setText("Withdraw Money");
		this.setBounds(314, 350, 150, 25);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
