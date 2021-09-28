package com.guitar.app.test;

import java.util.Iterator;
import java.util.List;

import com.guitar.app.Builder;
import com.guitar.app.Guitar;
import com.guitar.app.GuitarSpec;
import com.guitar.app.Inventory;
import com.guitar.app.Type;
import com.guitar.app.Wood;

public class GuitarTest {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		// TODO Auto-generated method stub
		 GuitarSpec whatErinLikes = new GuitarSpec(Type.ACOUSTIC, Builder.OLSON, Wood.ADIRONDACK, "Abc", 6, Wood.ADIRONDACK, Wood.ADIRONDACK);
		List<Guitar> matchingGuitars = inventory.search(whatErinLikes );    
		 if (!matchingGuitars.isEmpty()) { 
			 System.out.println("Erin, you might like these guitars:");
			 for (Iterator<Guitar> i = matchingGuitars.iterator(); i.hasNext(); ) { 
				 Guitar guitar = i.next();       
				 System.out.println("We have a " + guitar.getGuitarSpec().getBuilder()
				 + " " + guitar.getGuitarSpec().getModel() + " " +          guitar.getGuitarSpec().getType() +
				 " guitar:\n   " + guitar.getGuitarSpec().getBackWood() + 
				 " back and sides,\n   " + guitar.getGuitarSpec().getTopWood() +
				 " top.\n  You can have it for only $" + guitar.getPrice() + "!\n  ----");
						 } 
			 }
		 else {
			 System.out.println("Sorry, Erin, we have nothing for you.");  
					 } 
	}

}
