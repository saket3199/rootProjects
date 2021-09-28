package com.bank.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.bank.Banking;
import com.bank.ExportData;
import com.bank.Login;
import javax.swing.JOptionPane;

public class Dashboard extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1, l2;  
    JTextField tf1;  
    JButton btn1, btn2, btn3,printPassBook,exportPassBook;  
    JRadioButton jRadioButton1;
    JRadioButton jRadioButton2;
    ButtonGroup G1;
    JLabel L1;
	private Banking banking;
    public Dashboard() {
    	setVisible(true);  
        setSize(600, 400);  
        setLayout(null);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setTitle("DashBoard");  
        l1 = new JLabel("Welcome to XYZ Bank:"+ Login.getBanker().getName());  
        l1.setForeground(Color.blue);  
        l1.setFont(new Font("Serif", Font.BOLD, 20));  
        l2 = new JLabel("Amount");  
        printPassBook = new JButton("Print PassBook");
        exportPassBook = new JButton("Export PassBook");
        tf1 = new JTextField();  
        btn1 = new JButton("Save");  
        btn2 = new JButton("Clear"); 
        btn3 = new JButton("Logout");
        btn1.addActionListener(this);  
        btn2.addActionListener(this); 
        btn3.addActionListener(this);
        printPassBook.addActionListener(this);
        exportPassBook.addActionListener(this);
        l1.setBounds(100, 30, 400, 30);  
        l2.setBounds(100, 100, 200, 30);  
        tf1.setBounds(300, 100, 200, 30);  
        btn1.setBounds(50, 250, 100, 30);  
        btn2.setBounds(170, 250, 100, 30);  
        btn3.setBounds(50,300,80,30);
        printPassBook.setBounds(150,300,150,30);
        exportPassBook.setBounds(330,300,150,30);
        add(l1);  
        add(l2);  
        add(tf1);  
        add(btn1);  
        add(btn2);  
        add(btn3);
        add(printPassBook);
        add(exportPassBook);
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        G1 = new ButtonGroup();
        L1 = new JLabel("Transaction Type");
        jRadioButton1.setText("WithDrawal");
        jRadioButton2.setText("Deposit");
        jRadioButton1.setBounds(200, 150, 120, 50);
        jRadioButton2.setBounds(330, 150, 80, 50);
        L1.setBounds(100, 150, 150, 50);
        this.add(jRadioButton1);
        this.add(jRadioButton2);
        this.add(L1);
        G1.add(jRadioButton1);
        G1.add(jRadioButton2);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==printPassBook) {
			banking = new Banking(Login.getBanker());
			ResultSet rs = banking.printPassBook();
			new DataTable(rs);
		}
		if(e.getSource()==exportPassBook) {
			JOptionPane.showMessageDialog(this, "Please Wait Exporting your PassBook ");  
			banking = new Banking(Login.getBanker());
			ResultSet rs = banking.printPassBook();
			new ExportData(rs);
		}
		if(e.getSource()==btn3) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
		if(e.getSource()==btn2) {
			this.clearAll();
		}
		if(e.getSource()==btn1) {
			int amount;
	        if (jRadioButton1.isSelected()) {
	            amount = (int) Double.parseDouble(tf1.getText().toString().trim());
//	            this.processTransaction(transaction,amount);
	            banking = new Banking(Login.getBanker());
	    		try {
	    			banking.withdraw(amount);
	    		} catch (Exception e1) {
	    			// TODO Auto-generated catch block
	    			JOptionPane.showMessageDialog(btn1, e1);  
	    			
	    		}
	        }
	        else if (jRadioButton2.isSelected()) {
	        	amount = (int) Double.parseDouble(tf1.getText().toString().trim());
//	            this.processTransaction(transaction,amount);
	        	banking = new Banking(Login.getBanker());
	    		banking.deposit(amount);
	        }
	        else {
	        	JOptionPane.showMessageDialog(btn1, "Select Transaction Type");  
	        }
			
		}
		
        

    }

	private void clearAll() {
		// TODO Auto-generated method stub
		tf1.setText("");
		this.jRadioButton1.setSelected(false);
		this.jRadioButton2.setSelected(false);
		
		
	}
}
