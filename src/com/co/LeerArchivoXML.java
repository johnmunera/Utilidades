package com.co;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class LeerArchivoXML {
	

	public static void leer() {

			 
			   try {

					File fXmlFile = new File("C:\\Users\\John\\Downloads\\archivo.xml");
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(fXmlFile);

					doc.getDocumentElement().normalize();

					System.out.println("Elemento Raiz :" + doc.getDocumentElement().getNodeName());
							
					NodeList nList = doc.getElementsByTagName("usuario");
							
					System.out.println("========================Contenido===========================");

					for (int temp = 0; temp < nList.getLength(); temp++) {

						Node nNode = nList.item(temp);
								
						System.out.println("\nElemento " +temp+" :" + nNode.getNodeName());
								
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {

							Element eElement = (Element) nNode;

							System.out.println("Cedula : " + eElement.getAttribute("cedula"));
							System.out.println("Nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
							System.out.println("Apellido : " + eElement.getElementsByTagName("apellido").item(0).getTextContent());

							NodeList roles = doc.getElementsByTagName("rol");
							
							System.out.println("========================Roles===========================");

							for (int i = 0; i < roles.getLength(); i++) {

								Node rol = roles.item(i);
										
								System.out.println("\nRol " +i+" :" + rol.getNodeName());
										
								if (rol.getNodeType() == Node.ELEMENT_NODE) {

									Element rolActual = (Element) rol;
									System.out.println("Código Rol : " + rolActual.getAttribute("codigo"));
									System.out.println("Nombre Rol : " + rolActual.getAttribute("nombre"));
								}
							}
							
						}
					}
				    } catch (Exception e) {
					e.printStackTrace();
				    }

		
	}
	
	
	
	
public static void main(String[] args) {
	leer();
}
}
