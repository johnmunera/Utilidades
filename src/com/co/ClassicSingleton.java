package com.co;
public class ClassicSingleton {

   private static ClassicSingleton instance = null;
   private ClassicSingleton() {
      // se declara privado para que no se pueda instancial con el constructor por defecto
   }
   public static ClassicSingleton getInstance() {
      if(instance == null) {
         instance = new ClassicSingleton();
      }
      return instance;
   }
   
   public void prueba() {
	 System.out.println("ejecuto la prueba");  
	
   }
}