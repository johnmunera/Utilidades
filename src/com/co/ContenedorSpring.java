package com.co;

import java.io.FileInputStream;
import java.util.Properties;

import org.codehaus.groovy.runtime.GeneratedClosure;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContenedorSpring {

	public static void main(String[] args) {
		Properties properties = new Properties();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        SpringDTO springDto = (SpringDTO)ctx.getBean("springDto");
        System.out.println("hello word " + springDto.helloWord());  
		   
		try {
			properties.load(new FileInputStream("context.properties"));
			System.out.println("propiedad nombre " + properties.getProperty("nombre"));
			System.out.println("propiedad apellido " + properties.getProperty("apellido"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

        
        
        
	}

}
