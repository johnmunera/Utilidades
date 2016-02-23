package com.co;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class EscribirEnArchivo {
	

	static FileOutputStream fileOutputStream;
	static OutputStreamWriter outputStreamWriter;
	static BufferedWriter bufferedWriter;

	
	
	public static void leer() {
		try {
		
			   fileOutputStream = new FileOutputStream("C:\\Users\\John\\Downloads\\log.txt");
			   outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			   bufferedWriter = new BufferedWriter(outputStreamWriter);
			
		
			   bufferedWriter.write("Primera linea escrita");
			  
			   bufferedWriter.newLine();
			   
			   bufferedWriter.write("Segunda linea escrita");	
			
			
	
	
		bufferedWriter.flush();
		} catch (Exception e) {
			   e.printStackTrace();
		}
		
	}
	
	
	
public static void main(String[] args) {
	leer();
}
}
