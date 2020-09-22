package model;

import org.apache.commons.lang3.RandomStringUtils;

public class GerarSenha {
	
	private static String charactersSenha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	public static String gerarSenha(int tamanho) {
		return RandomStringUtils.random( tamanho, charactersSenha );
	}
	
}
