package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import entity.CheckButton;
import main.Main;

public class CheckDisplay extends JPanel{
	
	private static final long serialVersionUID = 8;
	private String toRender = "";
	Main main;
	BankPanel bankPanel;
	CheckButton redirectButton;
	CheckDisplay cDisplay;
	
	public void setToRender(String toRender) {
		this.toRender = toRender;
	}	
	
	public CheckDisplay(Main main, BankPanel bankPanel) {
		if (main == null || bankPanel == null) {
	        throw new IllegalArgumentException("Main and BankPanel must not be null.");
	    }
		cDisplay = this;
		this.main = main;
		this.bankPanel = bankPanel;
		this.redirectButton = new CheckButton(); 
		this.setLayout(null);
		this.setBounds(0, 0, 800, 600);
		this.setBackground(Color.cyan);
		redirectButton.setLayout(null);
		redirectButton.setBounds(314, 400, 150, 25);
		this.add(redirectButton);
		
		redirectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        main.remove(CheckDisplay.this);
		        main.add(bankPanel);
		        main.repaint();
		        main.revalidate();
		    }
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(toRender, (800/2) - 16, (600/2) - 16);
	}
}
