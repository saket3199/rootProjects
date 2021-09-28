package com.techlab.threading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame implements ActionListener {

	public class RunnableDemo implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String strDate = formatter.format(date);
				System.out.println(strDate);
			}
		}

	}

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	JButton btn1, btn2;

	public Frame() {
		setVisible(true);
		setSize(600, 400);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Threading");
		btn1 = new JButton("Print Hello");
		btn2 = new JButton("Print Time");
		btn1.setBounds(120, 150, 150, 30);
		btn2.setBounds(300, 150, 150, 30);
		add(btn1);
		add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn1) {
			JOptionPane.showMessageDialog(btn1, "Hello User");
		}
		if (e.getSource() == btn2) {
			Thread t1 = new Thread(new RunnableDemo());
	        t1.start();
		
		}
	}

}
