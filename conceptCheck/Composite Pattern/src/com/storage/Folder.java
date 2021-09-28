package com.storage;

import java.util.ArrayList;
import java.util.List;

public class Folder implements StorageItem{
	private String name;
	static int level=0;
	private List<StorageItem> children;
	
	public Folder(String name){
		this.name=name;
		children = new ArrayList<StorageItem>();
	}
	
	public void addChild(StorageItem child) {
		children.add(child);
	}
	@Override
	public void printDetails() {
		for (int i = 0; i < level; i++)
	        System.out.print(" ");
		level++;
		System.out.println("Folder : "+name);
		for(StorageItem item: children) {
			item.printDetails();
		}
		level--;
	}
	public String getName() {
		return name;
	}

}
