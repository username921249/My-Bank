package entity;

import java.awt.Graphics;

import javax.swing.JButton;

public class CreateButton extends JButton{
	private static final long serialVersionUID = 699;
	
	public CreateButton() {
		this.setText("Create An Account");
		this.setBounds(314, 200, 150, 25);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
