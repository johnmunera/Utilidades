package com.co;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class LeerArchivoByteToByte {
	
	static Cell celda;
	static Row fila;
	static Sheet hoja;
	static Workbook libro;
	static Object valor;
	static int i;
	static int indexCol;
	static int indexFila;
	static FileInputStream fileInputStream;
	static FileOutputStream fileOutputStream;
	static OutputStreamWriter outputStreamWriter;
	static BufferedWriter bufferedWriter;
	
	public static void leer() {
		try {
			
			  File directory = new File("C:/logs");

			    // get all the files from a directory
			    File[] fList = directory.listFiles();

			    for (File file : fList) {
			        if (file.isFile()) {
			        	if(file.getAbsolutePath().endsWith("hosts") || file.getAbsolutePath().endsWith("prueba.txt")){
			        		 File f = new File(file.getAbsolutePath());
			    			 if(f.exists() && f.canWrite() && f.canRead()){
			    			   f.setWritable(true);
			    			   fileInputStream = new FileInputStream(f);
			    			   fileInputStream.read();
			    			   
			    			   int data;

			    	            while ((data = fileInputStream.read()) != -1) {
			    	            	System.out.println(data);
			    	            }
			    			 }
			        	}
			        } else if (file.isDirectory()) {
			        	System.out.println(" No es un archivo " +file.getAbsolutePath());
			        }
			    }
			
		} catch (Exception e) {
			   e.printStackTrace();
		}
		
	}
	
	
	
	
	private static Object getValorCelda(Cell cel) {
		Object o;
		if(cel.getCellType() == Cell.CELL_TYPE_NUMERIC){
			o = cel.getNumericCellValue();
		}else if(cel.getCellType() == Cell.CELL_TYPE_STRING){
		    o = cel.getStringCellValue();
	    }else {
	    	o = "";	
	    }
		
		return o;
		
	}
public static void main(String[] args) {
	leer();
}
}
