package com.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommonListener implements ActionListener{
	Form form = new Form();

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().toString()=="Blue Color!") {
			form.getContentPane().setBackground(Color.blue);
		}
		if(e.getActionCommand().toString()=="Red Color!") {
			form.getContentPane().setBackground(Color.red);
		}
	}

}
