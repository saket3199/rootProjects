package com.techlabs.todo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TodoStore {
	private ArrayList<Todo> todoList;
	public void addToLocalStorage(ArrayList<Todo> array) {
		 try
	        {
	            FileOutputStream fileOutputStream = new FileOutputStream("Data\\listData");
	            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	            objectOutputStream.writeObject(array);
	            objectOutputStream.close();
	            fileOutputStream.close();
	        } 
	        catch (IOException ex) 
	        {
	            ex.printStackTrace();
	        }
		
	}
	public ArrayList<Todo> getFromLocalStorage() {
		 try
	        {
	            FileInputStream fileInputStream = new FileInputStream("Data\\listData");
	            ObjectInputStream objectOutPutStream = new ObjectInputStream(fileInputStream);
	 
	            todoList = (ArrayList<Todo>) objectOutPutStream.readObject();
	            
	            objectOutPutStream.close();
	            fileInputStream.close();
	            return todoList;
	        } 
	        catch (IOException ex) 
	        {
	            ex.printStackTrace();
	            return null;
	        } 
	        catch (ClassNotFoundException cex) 
	        {
	            System.out.println("Class not found");
	            cex.printStackTrace();
	            return null;
	        }
	}

}
