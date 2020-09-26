package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatarVigencia {
	
	private static SimpleDateFormat format = new SimpleDateFormat("MM/yyyy");
	
	public static String dateToFormat(Date data) {
		
		return format.format(data);
		
	}
	
	public static Date formatToDate(String data) {
		
		try {
			return format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
