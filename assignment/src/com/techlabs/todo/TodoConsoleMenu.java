package com.techlabs.todo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TodoConsoleMenu {
	private ArrayList<Todo> array;
	private Scanner input; 
	private Todo todo;
	private TodoStore store;
	private SimpleDateFormat formatter;  
	private Date date;
	public TodoConsoleMenu() {
		input = new Scanner(System.in);
		
	}
	public void launch() {
		int i = 0;
		System.out.println("Welcome to ToDo Manager:");
		do {
			
			System.out.println("Enter 1 to stop console and 0 to continue :");
			i = input.nextInt();
			System.out.println("Enter a Todo");
			String p1 = input.next().trim();
			System.out.print(todo.getText());
			todo = new Todo(p1,formatter.format(date),false);
			System.out.printf(todo.getId(),todo.getText(),todo.isCompleted());
			array.add(todo);
			store.addToLocalStorage(array);
			this.showTodo();
			
		}while(i!=1);
	}
	
	public void showTodo() {
		ArrayList<Todo> array2 = (ArrayList<Todo>) store.getFromLocalStorage();
		System.out.println("The todos are :");
		for(Todo task : array2) {
            System.out.println(task.getText());
        }
	}

}
