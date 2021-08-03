package com.techlab.iemotionable.test;

import com.techlab.iemotionable.Boy;
import com.techlab.iemotionable.ISocializable;
import com.techlab.iemotionable.Man;

public class IEmotionable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Man m = new Man();
		Boy b = new Boy();
		printInfo(m);
		printInfo(b);
	}

	private static void printInfo(Boy b) {
		// TODO Auto-generated method stub
		
	}

	public static void printInfo(Man m2) {

		try {
			((ISocializable) m2).depart();
		} catch (Exception m) {
			System.err.println(m);
		}
		try {
			((ISocializable) m2).wish();
		} catch (Exception m) {
			System.err.println(m);
		}
		
		((com.techlab.iemotionable.IEmotionable) m2).cry();
		((com.techlab.iemotionable.IEmotionable) m2).laugh();
	}


	}


