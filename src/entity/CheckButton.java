package entity;

import java.awt.Graphics;

import javax.swing.JButton;

public class CheckButton extends JButton{
	private static final long serialVersionUID = 699;
	
	public CheckButton() {
		this.setText("Check Balance");
		this.setBounds(314, 250, 150, 25);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
