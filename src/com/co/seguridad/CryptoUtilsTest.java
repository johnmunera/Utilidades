package com.co.seguridad;
import java.io.File;
 
/**
 * A tester for the CryptoUtils class.
 * @author www.codejava.net
 *
 */
public class CryptoUtilsTest {
    public static void main(String[] args) {
        String key = "Mary has one cat";
        File inputFile = new File("C:/logs/prueba.txt");
        File encryptedFile = new File("C:/logs/prueba.encrypted");
        File decryptedFile = new File("C:/logs/prueba.decrypted");
         
        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
