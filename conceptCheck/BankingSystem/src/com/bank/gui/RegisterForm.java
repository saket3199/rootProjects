package com.bank.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bank.Register;

public class RegisterForm extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1, l2, l4, l5, l6,l3;  
    JTextField tf1,amount;  
    JButton btn1, btn2, btn3;  
    JPasswordField p1, p2;  
    public RegisterForm()  
    {  
        setVisible(true);  
        setSize(600, 400);  
        setLayout(null);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setTitle("Registration Form");  
        l1 = new JLabel("Registration Form for XYZ Bank:");  
        l1.setForeground(Color.blue);  
        l1.setFont(new Font("Serif", Font.BOLD, 20));  
        l2 = new JLabel("Name:");  
        l4 = new JLabel("Create Passowrd:");  
        l5 = new JLabel("Confirm Password:"); 
        l6 = new JLabel("Already have a account?");
        l3= new JLabel("Enter the Deposit Amount");
        tf1 = new JTextField();  
        p1 = new JPasswordField();  
        p2 = new JPasswordField(); 
        amount = new JTextField();
        btn1 = new JButton("Submit");  
        btn2 = new JButton("Clear"); 
        btn3 = new JButton("Login");
        btn1.addActionListener(this);  
        btn2.addActionListener(this); 
        btn3.addActionListener(this);
        l1.setBounds(100, 30, 400, 30);  
        l2.setBounds(80, 70, 200, 30); 
        l3.setBounds(80,120,200,30);
        l4.setBounds(80, 170, 200, 30);  
        l5.setBounds(80, 220, 200, 30);  
        l6.setBounds(30,320,400,30);
        tf1.setBounds(300, 70, 200, 30);
        amount.setBounds(300,120,200,30);
        p1.setBounds(300, 170, 200, 30);  
        p2.setBounds(300, 220, 200, 30);  
        btn1.setBounds(50, 270, 100, 30);  
        btn2.setBounds(170, 270, 100, 30);  
        btn3.setBounds(200,320,100,30);
        add(l1);  
        add(l2);  
        add(tf1);  
        add(l4);  
        add(p1);  
        add(l5);  
        add(p2);  
        add(btn1);  
        add(btn2);  
        add(l6);
        add(btn3);
        add(l3);
        add(amount);
        JOptionPane.showMessageDialog(this, "Welcome to XYZ Bank");
    }  
    public void actionPerformed(ActionEvent e)   {
    	LoginForm login =new LoginForm();
    	if(e.getSource()== btn3) {
    		login.setVisible(true);
    		login.setSize(600,400);
    		this.setVisible(false);
//    		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    	}
        if (e.getSource() == btn1)  
         {  
            int x = 0;  
            String s1 = tf1.getText().trim();
            double amt = Double.parseDouble(amount.getText().trim());
            char[] s3 = p1.getPassword();  
            char[] s4 = p2.getPassword();   
            String s8 = new String(s3);  
            String s9 = new String(s4);  
            if (s8.equals(s9))  
            {  
                try  
                {  
                	new Register(s1, s8, s9, amt);
                    x++;  
                    if (x > 0)   
                    {  
                        JOptionPane.showMessageDialog(btn1, "Registred Successfully"); 
                        JOptionPane.showMessageDialog(btn1, "Re-login Again");
                        login.setVisible(true);
                		login.setSize(600,400);
                		this.setVisible(false);
//                		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                        
                    }  
                }  
                catch (Exception ex)   
                {  
                	JOptionPane.showMessageDialog(btn1, ex); 
                }  
            }  
            else  
            {  
                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");  
            }   
          }   
          else  
          {  
            tf1.setText("");  
            p1.setText("");  
            p2.setText("");  
          }  
    }   
   
	  
}  


