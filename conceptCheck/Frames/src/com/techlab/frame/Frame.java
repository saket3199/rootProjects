package com.techlab.frame;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
	private Color color=Color.green;
	private String name="Saket";
	public Frame(Color color,String name) {
		super("Welcome "+name);                   
	    this.setSize( 250, 200 );
	    this.setLayout( new FlowLayout() ); 
	    this.getContentPane().setBackground(color);
	    this.setVisible(true);
	    
	    
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getColor() {
		return color;
	}

}
