package com.product.test;

import java.util.ArrayList;

import com.product.Product;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		list.add(new Product(1,"abc",500,.50));
		list.add(new Product(2,"pqrc",400,.20));
		list.add("name");
		
		for(Object item : list) {
			((Product) item).getpID();
		}

	}

}
