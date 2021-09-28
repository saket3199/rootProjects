package com.form;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Form extends JFrame{
	private Color color = Color.green;
	private String name = "Saket";
	
	public Form(Color color, String name) {
		super("Welcome"+ name);
		this.setSize(450, 300);
		this.setLayout(new FlowLayout());
		this.getContentPane().setBackground(color);
		this.setVisible(true);

	}
	public Form() {
		
	}
	public void changeColor() {
		
	}

	public Color getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

}
