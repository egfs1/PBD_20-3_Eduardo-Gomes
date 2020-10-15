package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class GerarBackup {
	
	public static void fazBackup(){
		String arquivo = "C:\\Users\\Pichau\\eclipse-workspace\\PBD_20-3_Eduardo-Gomes\\backup\\backup.sql";
		String diretorio = "C:\\Arquivos de Programas\\PostgreSQL\\12\\bin\\";
		
		File arq = new File(arquivo);
		if (arq.exists()){
			if (arq.length() > 0)
				arq.delete();
		}
		try {
			Process p = null;
			String linha = "";
			ProcessBuilder pb = new ProcessBuilder(diretorio+"pg_dump.exe", "-Ft", "-h", "localhost", "-U", "postgres", "-p" , "5433" , "-F", "c", "-b", "-v", "-f", arquivo, "SistemaEniatus");
			pb.environment().put("PGPASSWORD", "postgres");
			pb.redirectErrorStream(true);
			p = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((linha = reader.readLine()) != null){
				System.out.println(linha);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não foi possível efetuar o backup");
		}
	}
	
}
