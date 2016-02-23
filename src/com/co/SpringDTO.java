package com.co;

public class SpringDTO {
    
	private String nombre;
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public  SpringDTO() {
		
	}
	
	
	
	public String  helloWord() {
		
		return this.nombre;
		
	}
}
