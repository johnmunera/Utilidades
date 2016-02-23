package com.co.seguridad;

public class EncriptarDES {
   
	public static void main(String[] args) {
		EncripcionDES encripcionDES = new EncripcionDES();
		String dato = "John Jairo Munera Cardenas";
		String datoEncriptado = encripcionDES.encriptarDato(dato);
		System.out.println("String encriptado y convertido a exadecimal"+datoEncriptado);
		System.out.println("hexadecimal desencriptado y convertido a String"+ encripcionDES.desencriptarDato(datoEncriptado));

	}
	
	
	
}
