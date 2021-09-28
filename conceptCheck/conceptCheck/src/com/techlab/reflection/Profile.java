package com.techlab.reflection;

public class Profile {
	private String name;
	public Profile(String name) {
		this.name=name;
	}
	public Profile() {
		
	}
	public String getName() {
		return name;
	}
	public void name()  {
        System.out.println("Your name is " + name);
    }
  
    public void age(int n)  {
        System.out.println("Your age is " + n);
    }
    private void method() {
        System.out.println("Private method invoked");
    }
}
