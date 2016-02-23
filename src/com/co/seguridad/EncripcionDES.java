package com.co.seguridad;


import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class EncripcionDES {
	
//	•AES/CBC/NoPadding (128)
//	•AES/CBC/PKCS5Padding (128)
//	•AES/ECB/NoPadding (128)
//	•AES/ECB/PKCS5Padding (128)
//	•DES/CBC/NoPadding (56)
//	•DES/CBC/PKCS5Padding (56)
//	•DES/ECB/NoPadding (56)
//	•DES/ECB/PKCS5Padding (56)
//	•DESede/CBC/NoPadding (168)
//	•DESede/CBC/PKCS5Padding (168)
//	•DESede/ECB/NoPadding (168)
//	•DESede/ECB/PKCS5Padding (168)
//	•RSA/ECB/PKCS1Padding (1024, 2048)
//	•RSA/ECB/OAEPWithSHA-1AndMGF1Padding (1024, 2048)
//	•RSA/ECB/OAEPWithSHA-256AndMGF1Padding (1024, 2048)

	
	
	
	private final byte[] key = "0123456789abcdefghijklmn".getBytes();
	private final String provider ="/ECB/PKCS5Padding";
	private String algorithm ="desede";
	private Cipher cipher;
	private byte[] textoEncriptado;
	private byte[] textoPlano;
	private StringBuffer hexTextoEncriptado;
	
	SecretKeyFactory keyFactory;
    Key desKey = null;
    
	private DESedeKeySpec spec;

	public String encriptarDato(String datoEntrada) {

		try {
			spec = new DESedeKeySpec(key);
			keyFactory = SecretKeyFactory.getInstance(algorithm );
			desKey = keyFactory.generateSecret(spec);
			cipher = Cipher.getInstance(algorithm + provider);
			cipher.init(Cipher.ENCRYPT_MODE, desKey);
			textoEncriptado = cipher.doFinal(datoEntrada.getBytes()); 	
			
		} catch (InvalidKeyException e1) {
			e1.printStackTrace();
		}catch (NoSuchAlgorithmException e2) {
			e2.printStackTrace();
		}catch (NoSuchPaddingException e3) {
			e3.printStackTrace();
		} catch (InvalidKeySpecException e4) {
			e4.printStackTrace();
		} catch (IllegalBlockSizeException e5) {
			e5.printStackTrace();
		} catch (BadPaddingException e6) {
			e6.printStackTrace();
		}
		return vectorHxaToString(textoEncriptado);
	}
	
	
	public String desencriptarDato(byte[] datoEncriptado) {
		try {
			spec = new DESedeKeySpec(key);
			keyFactory = SecretKeyFactory.getInstance(algorithm );
			desKey = keyFactory.generateSecret(spec);
			cipher = Cipher.getInstance(algorithm + provider);
			cipher.init(Cipher.DECRYPT_MODE, desKey);
			textoPlano = cipher.doFinal(datoEncriptado); 
		} catch (InvalidKeyException e1) {
			e1.printStackTrace();
		}catch (NoSuchAlgorithmException e2) {
			e2.printStackTrace();
		}catch (NoSuchPaddingException e3) {
			e3.printStackTrace();
		} catch (InvalidKeySpecException e4) {
			e4.printStackTrace();
		} catch (IllegalBlockSizeException e5) {
			e5.printStackTrace();
		} catch (BadPaddingException e6) {
			e6.printStackTrace();
		}
		return  new String(textoPlano);
	}
	
	public String desencriptarDato(String datoEncriptado) {
		try {
			spec = new DESedeKeySpec(key);
			keyFactory = SecretKeyFactory.getInstance(algorithm );
			desKey = keyFactory.generateSecret(spec);
			cipher = Cipher.getInstance(algorithm + provider);
			cipher.init(Cipher.DECRYPT_MODE, desKey);
			textoPlano = cipher.doFinal(stringToHxa(datoEncriptado)); 
		} catch (InvalidKeyException e1) {
			e1.printStackTrace();
		}catch (NoSuchAlgorithmException e2) {
			e2.printStackTrace();
		}catch (NoSuchPaddingException e3) {
			e3.printStackTrace();
		} catch (InvalidKeySpecException e4) {
			e4.printStackTrace();
		} catch (IllegalBlockSizeException e5) {
			e5.printStackTrace();
		} catch (BadPaddingException e6) {
			e6.printStackTrace();
		}
		return  new String(textoPlano);
	}
	public String vectorHxaToString(byte[] vector) {
		try {
			hexTextoEncriptado = new StringBuffer();
			for (int i = 0; i < vector.length; i++) {
				hexTextoEncriptado.append(Integer.toString((vector[i]&0xff)+0x100,16).substring(1));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hexTextoEncriptado.toString();
	}
	

	public static byte[] stringToHxa(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
}
