package com.bank.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bank.Login;

public class LoginForm extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b1;
	JPanel newPanel;
	JLabel userLabel, passLabel;
	final JTextField textField1, textField2;

	public LoginForm() {

		userLabel = new JLabel();
		userLabel.setText("Username"); 
		textField1 = new JTextField(5); 

		passLabel = new JLabel();
		passLabel.setText("Password"); 

		textField2 = new JPasswordField(15); 

		b1 = new JButton("SUBMIT");
		b1.setBounds(50, 250, 100, 30);
		newPanel = new JPanel(new GridLayout(3, 1));
		newPanel.add(userLabel); 
		newPanel.add(textField1); 
		newPanel.add(passLabel); 
		newPanel.add(textField2);
		newPanel.add(b1); 

		add(newPanel, BorderLayout.CENTER);

		b1.addActionListener(this); 
		setTitle("LOGIN FORM"); 
	}

	public void actionPerformed(ActionEvent ae) 
	{
		String userValue = textField1.getText().trim(); 
		String passValue = textField2.getText(); 
		new Login(userValue, passValue);
		if (Login.isLoggedIn()!=false) {
			Dashboard page = new Dashboard();
			page.setVisible(true);
			this.setVisible(false);
//			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
		else {
			JOptionPane.showMessageDialog(this, "Invalid Creditienals");  
		}
	}
}


