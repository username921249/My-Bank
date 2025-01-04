package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import entity.CreateButton;
import entity.EntryBox;
import functions.CreateAccount;
import main.Main;

public class CreatePanel extends JPanel {
    private static final long serialVersionUID = 0;
    
    CreateButton createButton;
    EntryBox eBox;
    EntryBox eBox2;
    CreateAccount createAccount = new CreateAccount();
    BankPanel bPanel;
    Main main;
    
    public CreatePanel(Main main, BankPanel bankPanel) {
        this.setBackground(Color.CYAN);
        createButton = new CreateButton();
        createButton.setBounds(314, 400, 150, 25);
        eBox = new EntryBox();
        eBox2 = new EntryBox();
        eBox2.setBounds(314, 250, 150, 25);
        eBox2.setText("Name");
        bPanel = bankPanel; // Pass BankPanel instance here
        this.main = main;
        this.setBounds(0,0,800,600);
        this.setLayout(null);
        this.add(createButton);
        this.add(eBox);
        this.add(eBox2);
        
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int accountNumber = Integer.parseInt(eBox.getText());
                String name = eBox2.getText();
                
                createAccount.createAccount(accountNumber, name, main.bDatabase);
                redirect();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void redirect() {
        main.remove(this);
        main.add(main.bPanel);
        main.revalidate();
        main.repaint();
    }
}
