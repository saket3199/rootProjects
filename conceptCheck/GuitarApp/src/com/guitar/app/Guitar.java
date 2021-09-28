package com.guitar.app;

public class Guitar {
	private GuitarSpec guitarSpec;
	private float price;
	private String serialNumber;
	public Guitar(GuitarSpec guitarSpec, float price, String serialNumber) {
		super();
		this.guitarSpec = guitarSpec;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	public GuitarSpec getGuitarSpec() {
		return guitarSpec;
	}
	public float getPrice() {
		return price;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	

}
