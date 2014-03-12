package br.com.fti.utils;

public class FUtils {
	
	public static Integer boolToInt(boolean bool) {
		return (bool ? 1 : 0);
	}
	
	public static boolean intToBool(Integer bool) {
		return (bool == 1 ? true : false);
	}
	
}
