package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatarDataLog {
	
	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static String dateToFormat(Date data) {
		
		return format.format(data);
		
	}
	
}
