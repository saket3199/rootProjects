package com.techlabs.todo;

import java.io.Serializable;

public class Todo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private String id;
	private boolean isCompleted;

	public Todo(String text, String id, boolean isCompleted) {
		this.text = text;
		this.id = id;
		this.isCompleted = isCompleted;
	}

	public String getText() {
		return text;
	}

	public String getId() {
		return id;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

}
