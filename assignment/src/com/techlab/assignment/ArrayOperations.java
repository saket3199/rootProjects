package com.techlab.assignment;

public class ArrayOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int myArray[] = { 10, 56, 78, 100, 34, 57 };
		int length = myArray.length;
		for (int j = 0; j < length - 1; j++) {
			if (myArray[j] < myArray[j + 1]) {

				int temp = myArray[j];
				myArray[j] = myArray[j + 1];
				myArray[j + 1] = temp;
				j = -1;
			}
		}
		System.out.println(myArray[0]);
		System.out.println(myArray[1]);
	}

}
