//Write a java program to find all pairs of elements in an integer array whose sum is equal to a given number?Input Array : [4, 6, 5, -10, 8, 5, 20]
//Input Number : 10
//Pairs of elements whose sum is 10 are :
//4 + 6 = 10
//5 + 5 = 10
//-10 + 20 = 10

package com.techlab.assignment;

public class PairsSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myArr[]= {4, 6, 5, -10, 8, 5, 20};
		int sum=10;
		for (int i = 0; i < myArr.length - 1; i++)
        {
            for (int j = i + 1; j < myArr.length; j++)
            {
                
                if (myArr[i] + myArr[j] == sum)
                {
                    System.out.println("Pair found (" + myArr[i] + ", " + myArr[j] + ")");
                }
            }
        }

	}

}
