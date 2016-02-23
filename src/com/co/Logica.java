package com.co;


public class Logica {
	private static String fecha = "2015-09-19";
	private static int ano = Integer.valueOf(fecha.substring(0, 4));
	private static int mes = Integer.valueOf(fecha.substring(5, 7));
	private static int dia = Integer.valueOf(fecha.substring(8, 10));
	
public static void main(String[] args) {
	System.out.println("año "+ano+" mes "+mes+" dia "+dia);
	
	if(ano%4==0){
		System.out.println("El año  es bisiesto");
	}else{
		System.out.println("El año no es bisiesto");
	}
	String[] areglo1 = fecha.split(fecha);

	
	char[] areglo = fecha.toCharArray();
	for (int i = 0; i < areglo.length; i++) {
		switch (i) {
		case 0:
			System.out.println("El arreglo 0 es " +areglo[i]);
			break;
		case 1:
			System.out.println("El arreglo 1 es " +areglo[i]);
			break;
		case 2:
			System.out.println("El arreglo 2 es " +areglo[i]);
			break;
		default:
			break;
		}
		
	}
}


}
