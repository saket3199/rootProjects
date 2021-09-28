package com.dog.door.test;

import com.dog.door.DogDoor;
import com.dog.door.Remote;

public class DogDoorSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DogDoor door = new DogDoor(); 
		 Remote remote = new Remote(door);
		 System.out.println("Fido barks to go outside...");
		 remote.pressButton();
		 System.out.println("\nFido has gone outside...");
		 System.out.println("\nFido’s all done...");
		 System.out.println("\nFido’s back inside...");
		 }

}


