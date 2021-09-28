package com.storage;

public class File implements StorageItem {
	private String name;
	private int size;

	public File(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	@Override
	public void printDetails() {
		for (int i = 0; i < Folder.level; i++)
	        System.out.print(" ");
		System.out.println("" + name);
	}

}
