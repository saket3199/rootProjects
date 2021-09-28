package com.techlab.frame.test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.techlab.frame.Frame;

public class FrameTest{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Frame f = new Frame(Color.cyan, "Saket");
		 JButton button = new JButton("Click here!");
		 f.add(button);
		 button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(f.getContentPane().getBackground()==Color.red) {
					f.getContentPane().setBackground(Color.green);
					}
					else {
						f.getContentPane().setBackground(Color.red);
					}
				}
	        });
	}
}	
