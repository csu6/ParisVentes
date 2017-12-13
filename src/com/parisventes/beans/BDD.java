package com.parisventes.beans;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BDD {
	private String filename;
	private List<String> allLines;

	public BDD(String filename){
		this.filename = filename;
	}

	public List<String> readFile() {
		
		try {
			allLines = Files.readAllLines(Paths.get(this.filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allLines;

	}
}
