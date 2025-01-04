package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import entity.Cash;
import entity.CheckButton;
import entity.CreateButton;
import entity.Delete;
import entity.DepositButton;
import entity.WithdrawButton;
import main.Main;

public class BankPanel extends JPanel {
    private static final long serialVersionUID = 69;
    public Cash cash;
    CreateButton cButton;
    CheckButton cButton2;
    DepositButton deposit;
    WithdrawButton withdraw;
    Delete delete;
    public CreatePanel cPanel;
    public CheckPanel checkPanel;
    public DepositPanel dPanel;
    WithdrawPanel wPanel;
    DeletePanel deletePanel;
    public Main main;
    
    public BankPanel(Main main, CreatePanel createPanel, CheckPanel checkPanel, DepositPanel dPanel, WithdrawPanel wPanel, DeletePanel deletePanel) {
    	cash = new Cash();
        cButton = new CreateButton();
        cButton2 = new CheckButton();
        deposit = new DepositButton();
        withdraw = new WithdrawButton();
        delete = new Delete();
        this.main = main;
        this.cPanel = createPanel; // Pass CreatePanel instance here
        this.checkPanel = checkPanel;
        this.dPanel = dPanel;
        this.wPanel = wPanel;
        this.deletePanel = deletePanel;
        this.setBounds(0, 0, 800, 600);
        this.setBackground(Color.CYAN);
        this.setLayout(null);
        this.add(cButton);
        this.add(cButton2);
        this.add(deposit);
        this.add(delete);
        this.add(withdraw);
        setupListeners();
    }

    private void setupListeners() {
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cButton();
            }
        });
        cButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cButton2();
            }
        });
        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });
        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });
    }
    
    private void cButton() {
        main.remove(this);
        main.add(cPanel);
        main.revalidate();
        main.repaint();
    }

    private void cButton2() {
        main.remove(this);
        main.add(checkPanel);
        main.revalidate();
        main.repaint();
    }

    private void deposit() {
        main.remove(this);
        main.add(dPanel);
        main.revalidate();
        main.repaint();
    }

    private void delete() {
        main.remove(this);
        main.add(deletePanel);
        main.revalidate();
        main.repaint();
    }

    private void withdraw() {
        main.remove(this);
        main.add(wPanel);
        main.revalidate();
        main.repaint();
    }
    
    public void setPanels(CreatePanel createPanel, CheckPanel checkPanel, DepositPanel dPanel, WithdrawPanel wPanel, DeletePanel deletePanel) {
        this.cPanel = createPanel;
        this.checkPanel = checkPanel;
        this.dPanel = dPanel;
        this.wPanel = wPanel;
        this.deletePanel = deletePanel;
    }    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        g2.drawImage(cash.IMAGE, null, 100, 100);
    }
}
