package com.product;

public class Product {
	private int pID;
	private String name;
	private double price;
	private double discount;
	public int getpID() {
		return pID;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public Product(int pID, String name, double price, double discount) {
		super();
		this.pID = pID;
		this.name = name;
		this.price = price;
		this.discount = discount;
	}
	
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
