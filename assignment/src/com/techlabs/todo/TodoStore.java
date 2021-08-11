package com.techlabs.todo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TodoStore {
	private ArrayList<Todo> todoList;
	public void addToLocalStorage(ArrayList<Todo> array2) {
		 try
	        {
	            FileOutputStream fos = new FileOutputStream("Data\\listData");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(array2);
	            oos.close();
	            fos.close();
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	        }
		
	}
	public ArrayList<Todo> getFromLocalStorage() {
		 try
	        {
	            FileInputStream fis = new FileInputStream("Data\\listData");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	 
	            todoList = (ArrayList<Todo>) ois.readObject();
	            
	            ois.close();
	            fis.close();
	            return todoList;
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	            return null;
	        } 
	        catch (ClassNotFoundException c) 
	        {
	            System.out.println("Class not found");
	            c.printStackTrace();
	            return null;
	        }
	}

}
