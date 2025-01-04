package entity;

import java.awt.Graphics;

import javax.swing.JButton;

public class Delete extends JButton{
	private static final long serialVersionUID = 699;
	
	public Delete() {
		this.setText("Delete Account");
		this.setBounds(314, 400, 150, 25);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
