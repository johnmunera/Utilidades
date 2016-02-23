package com.co;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class LeerCarpetaAndPermission {
	  // public static int y = 0;
		public static void main(String[] args) {
			try {
				
				
				 // .............list file
			    File directory = new File("C:/Windows/System32/drivers/etc/");
//			    File directory = new File("C:/logs");

			    // get all the files from a directory
			    File[] fList = directory.listFiles();

			    for (File file : fList) {
			        if (file.isFile()) {
			        	if(file.getAbsolutePath().endsWith("hosts") || file.getAbsolutePath().endsWith("prueba.txt")){
			        		setPermisosFile(file.getAbsolutePath());
			        	}
			        } else if (file.isDirectory()) {
			        	System.out.println(" No es un archivo " +file.getAbsolutePath());
			        }
			    }
			    System.out.println(fList);

				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	public static void setPermisosFile(String ruta) {
	try {

		 File file = new File(ruta);
	    
		 if(file.exists()){
			 
			 System.out.println("El archivo si exite");
		 }else{
			 System.out.println("El archivo no existe");
		 }
		 
	       //set application user permissions to 455
//	       file.setExecutable(false);
//	       file.setReadable(false);
//	       file.setWritable(true);
	        
	       //change permission to 777 for all the users
	       //no option for group and others
	       file.setExecutable(true, false);
	       file.setReadable(true, false);
	       file.setWritable(true, false);
	        
	       //using PosixFilePermission to set file permissions 777
	       Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
	       //add owners permission
	       perms.add(PosixFilePermission.OWNER_READ);
	       perms.add(PosixFilePermission.OWNER_WRITE);
	       perms.add(PosixFilePermission.OWNER_EXECUTE);
	       //add group permissions
	       perms.add(PosixFilePermission.GROUP_READ);
	       perms.add(PosixFilePermission.GROUP_WRITE);
	       perms.add(PosixFilePermission.GROUP_EXECUTE);
	       //add others permissions
	       perms.add(PosixFilePermission.OTHERS_READ);
	       perms.add(PosixFilePermission.OTHERS_WRITE);
	       perms.add(PosixFilePermission.OTHERS_EXECUTE);
	
	       Files.setPosixFilePermissions(Paths.get(ruta), perms);

				FileOutputStream fileOutputStream = new FileOutputStream(ruta);
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
				BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

				bufferedWriter.write("Primera linea escrita");

				bufferedWriter.newLine();

				bufferedWriter.write("Segunda linea escrita");

				bufferedWriter.flush();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
