package br.com.fti.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import br.com.fti.enumerator.FEnumDate;

@SuppressLint("SimpleDateFormat")
public class FDateUtils {
	
	public static String format(Date date, FEnumDate format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format.getFormat());
		return dateFormat.format(date);
	}
	
	public static Date format(String date, FEnumDate format) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format.getFormat());
		return (Date)(dateFormat.parse(date));
	}
}
