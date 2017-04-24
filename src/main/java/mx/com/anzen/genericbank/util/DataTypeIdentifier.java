package mx.com.anzen.genericbank.util;


import java.sql.Date;

public class DataTypeIdentifier {

	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	public static boolean isLong(String str){
		try{
			Long.parseLong(str);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
	public static boolean isFloat(String str) {
		try {
			Float.parseFloat(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static boolean isDate(String str) {
		try {
			Date.valueOf(str);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	public static boolean isBoolean(String str) {
		if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false")) {
			return true;
		}
		return false;
	}

}
