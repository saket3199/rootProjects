package com.form.test;

import java.awt.Color;

import javax.swing.JButton;

import com.form.CommonListener;
import com.ui.Frame;

public class FormTest {

	public static void main(String[] args) {

		Frame f = new Frame(Color.cyan, "Saket");
		JButton redbutton = new JButton("Red Color!");
		JButton bluebutton = new JButton("Blue Color!");
		f.add(redbutton);
		f.add(bluebutton);
		CommonListener commonL = new CommonListener();
		redbutton.addActionListener(commonL);
		bluebutton.addActionListener(commonL);
	}

}
