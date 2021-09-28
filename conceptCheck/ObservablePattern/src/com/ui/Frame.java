package com.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame {
	private Color color = Color.green;
	private String name = "Saket";
	JButton button = new JButton("Click here!");
	private List<ActionListener> listeners = new ArrayList<ActionListener>();

	public Frame(Color color, String name) {
		super("Welcome " + name);
		this.setSize(250, 200);
		this.setLayout(new FlowLayout());
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
