package com.guitar.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
	private List<Guitar> guitars;

	public Inventory() {
		guitars = new ArrayList<Guitar>();
	}

	public void addGuitar(Guitar guitar) {
		guitars.add(guitar);
	}

	public Guitar getGuitar(String serialNumber) {
		Guitar guitar = null;
		for (Guitar guitar1 : guitars) {
			if (guitar1.getSerialNumber().equals(serialNumber)) {
				guitar = guitar1;
			}
		}
		return guitar;
	}
	
	public List<Guitar> search(GuitarSpec searchSpec){
		List<Guitar> matchingGuitars = new ArrayList<Guitar>();
		for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
			Guitar guitar = (Guitar)i.next();      
			if (guitar.getGuitarSpec().matches(searchSpec))
				matchingGuitars.add(guitar);    
			}    
		return matchingGuitars;  
	}
}
