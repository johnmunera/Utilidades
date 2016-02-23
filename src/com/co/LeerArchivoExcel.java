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

public class LeerArchivoExcel {
	
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
			 File f = new File("C:\\Users\\John\\Downloads\\excelPrueba.xls");
			 if(f.exists() && f.canWrite() && f.canRead()){
			   f.setWritable(true);
			   fileInputStream = new FileInputStream(f);
			   
			   fileOutputStream = new FileOutputStream("C:\\Users\\John\\Downloads\\log.txt");
			   outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			   bufferedWriter = new BufferedWriter(outputStreamWriter);

			   
			   libro = new HSSFWorkbook(fileInputStream);

		
		
		hoja = libro.getSheetAt(0);
			 }else{
				 System.out.println("No existe");
			 }
		Iterator filasIterator = hoja.rowIterator();
		while (filasIterator.hasNext()) {
			fila = (Row)filasIterator.next();
			if(fila.getRowNum() >= 0){
				i ++;
				Iterator celdasIterator = fila.cellIterator();
				while (celdasIterator.hasNext()) {
					celda = (Cell)celdasIterator.next();
					indexCol = celda.getColumnIndex();
					indexFila = celda.getRowIndex();
					valor = getValorCelda(celda);
					
					switch (indexCol) {
					case 0:
						System.out.println("Valor columna "+ indexCol +" con fila "+indexFila +" es "+String.valueOf(valor));
						bufferedWriter.write("Valor columna "+ indexCol +" con fila "+indexFila +" es "+String.valueOf(valor));
						break;
						
					case 1:
						System.out.println("Valor columna "+ indexCol +" con fila "+indexFila +" es "+String.valueOf(valor));	
						bufferedWriter.write("Valor columna "+ indexCol +" con fila "+indexFila +" es "+String.valueOf(valor));
						break;
					case 2:
						System.out.println("Valor columna "+ indexCol +" con fila "+indexFila +" es "+String.valueOf(valor));	
						bufferedWriter.write("Valor columna "+ indexCol +" con fila "+indexFila +" es "+String.valueOf(valor));
						
						break;

					default:
						break;
					}
					
				}
				
			}
			bufferedWriter.newLine();
			
		}
		bufferedWriter.flush();
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
