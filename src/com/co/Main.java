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

public class Main {

   // public static int y = 0;
	public static void main(String[] args) {
		try {
			

			 // .............list file
		    File directory = new File("C:/Windows/System32/drivers/etc/");

		    // get all the files from a directory
		    File[] fList = directory.listFiles();

		    for (File file : fList) {
		        if (file.isFile()) {
		        	if(file.getAbsolutePath().endsWith("hosts")){
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
//       file.setExecutable(false);
//       file.setReadable(false);
//       file.setWritable(true);
        
       //change permission to 777 for all the users
       //no option for group and others
       file.setExecutable(true, false);
       file.setReadable(true, false);
       file.setWritable(true, false);
//        
//       //using PosixFilePermission to set file permissions 777
//       Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
//       //add owners permission
//       perms.add(PosixFilePermission.OWNER_READ);
//       perms.add(PosixFilePermission.OWNER_WRITE);
//       perms.add(PosixFilePermission.OWNER_EXECUTE);
//       //add group permissions
//       perms.add(PosixFilePermission.GROUP_READ);
//       perms.add(PosixFilePermission.GROUP_WRITE);
//       perms.add(PosixFilePermission.GROUP_EXECUTE);
//       //add others permissions
//       perms.add(PosixFilePermission.OTHERS_READ);
//       perms.add(PosixFilePermission.OTHERS_WRITE);
//       perms.add(PosixFilePermission.OTHERS_EXECUTE);
//
//       Files.setPosixFilePermissions(Paths.get(ruta), perms);

			FileOutputStream fileOutputStream = new FileOutputStream(ruta);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

			bufferedWriter.write("Primera linea escrita");

			bufferedWriter.newLine();

			bufferedWriter.write("Segunda linea escrita");

			bufferedWriter.flush();
	
} catch (Exception e) {
	// TODO: handle exception
}

}
	public static void pruebas() {
//      X x = new X();
//     
//      x.a = 3;
//    
//      X x2 = m1(x); /* Line 6 */
//      x = new X();
//      m2(x); /* Line 6 */
//      System.out.println(" x "+x.a);
//      System.out.println(" x2 "+x2.a);
//      X x4 = new X();
//      x2 = x4; /* Line 8 */
  	
  	String a = "ABCD"; 
  	String b = a.toLowerCase(); 
  	b.replace('a','d'); 
  	b.replace('b','c'); 
  	System.out.println(b.replace('a','d'));
  	System.out.println(b);
  	
//  	 int i = 1, j = 0; 
//  	 System.out.println("i "+i);
//       switch(i) 
//       { 
//           case 2:
//          	     System.out.println("j 6"+j); 
//          	 j += 6;
//          		 System.out.println("j 6"+ j); 
//           case 4:
//          	 System.out.println("j 1"+j); 
//          	 j += 1;
//          	 System.out.println("j 1"+j); 
//           default: j += 2;
//               System.out.println("jd"+j); 
//           case 0: j += 4; 
//           case 8: j += 4; 
//               System.out.println("j 4"+j); 
//       } 
//       System.out.println("j = " + j); 
//  	  int x = 0;  
//        assert (x > 0) : "assertion failed"; /* Line 6 */
//        System.out.println("finished"); 
//
//       
//       int result = 0;
//       Boolean b1 = new Boolean("TRUE");
//       Boolean b2 = new Boolean("true");
//       Boolean b3 = new Boolean("tRuE");
//       Boolean b4 = new Boolean("false");
//
//       if (b1 == b2)  /* Line 10 */
//           result = 1;
//       
//       System.out.println("b1 "+b1);
//       System.out.println("b2 "+b2);
//       if (b1.equals(b2) ) /* Line 12 */
//           result = result + 10;
//       if (b2 == b4)  /* Line 14 */
//           result = result + 100;
//       if (b2.equals(b4) ) /* Line 16 */
//           result = result + 1000;
//       if (b2.equals(b3) ) /* Line 18 */
//           result = result + 10000;
//
//       System.out.println("result = " + result);
//
		
	}
//	
//	 static X m1(X mx) 
//	    {
//	    	mx.a = 8;
//	        mx = new X();
//	        return mx;
//	    }
//	    static void m2(X mx) 
//	    {
//	    	X v = new X();
//	    	
//	        mx = new X();
//	    }

}
