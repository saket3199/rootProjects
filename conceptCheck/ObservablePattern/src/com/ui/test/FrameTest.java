package com.ui.test;

import java.awt.Color;
import javax.swing.JButton;

import com.ui.DevilListner;
import com.ui.Frame;
import com.ui.GodListner;

public class FrameTest {

	public static void main(String[] args) {
		Frame f = new Frame(Color.cyan, "Saket");
		JButton button = new JButton("Click here!");
		f.add(button);

		button.addActionListener(new GodListner());
		button.addActionListener(new DevilListner());
	}

}
