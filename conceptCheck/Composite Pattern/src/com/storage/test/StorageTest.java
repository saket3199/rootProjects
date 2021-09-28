package com.storage.test;

import com.storage.File;
import com.storage.Folder;

public class StorageTest {

	public static void main(String[] args) {

		Folder movies = new Folder("movies");
		File f1 = new File("abc.avi",400);
		File f2 = new File("pqr.avi",300);
		Folder comedy = new Folder("comedy");
		movies.addChild(f1);
		movies.addChild(f2);
		movies.addChild(comedy);
		File f3 = new File("lmno.avi",200);
		Folder comedyEng = new Folder("comedy English");
		Folder comedyHindi = new Folder("comedy Hindi");
		comedy.addChild(f3);
		comedy.addChild(comedyEng);
		comedy.addChild(comedyHindi);
		File f4 = new File("123.avi",200);
		Folder _2021 = new Folder("2021");
		comedyEng.addChild(f4);
		comedyEng.addChild(_2021);
		File hungama = new File("Hungama.avi",200);
		comedyHindi.addChild(hungama);
		_2021.addChild(new File("567.avi",700));
		movies.printDetails();
		
	}

}
