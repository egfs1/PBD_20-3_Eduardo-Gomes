package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografar {
	
	public static String criptografar(String senha) {
		String retorno = "";
		MessageDigest md;
		
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
			retorno = hash.toString(16);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
		
	}
	
}
