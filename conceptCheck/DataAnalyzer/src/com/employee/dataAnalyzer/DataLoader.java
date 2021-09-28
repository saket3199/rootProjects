package com.employee.dataAnalyzer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DataLoader {
	Scanner scanner;
	Set<String> set = new HashSet<String>();
	public DataLoader() throws IOException {
		this.fileLoader();
		this.urlLoader();
		new DataAnalyzer();
	}

	public void urlLoader() throws IOException {
		URL url = new URL("https://swabhav-tech.firebaseapp.com/emp.txt");
		scanner = new Scanner(url.openStream());
		while (scanner.hasNext())
			set.add(scanner.nextLine());
		scanner.close();
	}

	public void fileLoader() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("data/dataFile.txt");
		scanner = new Scanner(fis);
		while (scanner.hasNextLine()) {
			if(set.add(scanner.nextLine())){
			}
		}
		scanner.close();
		this.fileWriter();
	}
	public void fileWriter() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("data/output.txt");
		for (String line:set) {
			pw.println(line);
			}
		pw.flush();
		pw.close();
		
	}
}
