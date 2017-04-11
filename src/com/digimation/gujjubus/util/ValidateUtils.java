package com.digimation.gujjubus.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.mysql.jdbc.TimeUtil;
import com.mysql.jdbc.util.TimezoneDump;

public class ValidateUtils {
	static Pattern pattern;
	static Matcher matcher;
	public static final String DEFAULT_ENCODING="UTF-8"; 
	   static BASE64Encoder enc=new BASE64Encoder();
	   static BASE64Decoder dec=new BASE64Decoder();

	   public static String base64encode(String text){
	      try {
	         String rez = enc.encode( text.getBytes( DEFAULT_ENCODING ) );
	         return rez;         
	      }
	      catch ( UnsupportedEncodingException e ) {
	         return null;
	      }
	   }//base64encode

	   public static String base64decode(String text){

	         try {
	            return new String(dec.decodeBuffer( text ),DEFAULT_ENCODING);
	         }
	         catch ( IOException e ) {
	           return null;
	         }
	   }
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.A-Za-z0-9]+)"
			+ "*(\\.[A-Za-z]{2,})$";
	private static final String BUSNO_PATTERN = "^[A-Z]{2}[0-9]{1,2}(?:[A-Z])?(?:[A-Z]*)?[0-9]{4}$";

	public static boolean validateBusNo(String param) {
		pattern = Pattern.compile(BUSNO_PATTERN);
		matcher = pattern.matcher(param);

		if (matcher.matches())
			return false;
		return true;

	}

	public static boolean validateText(String param) {
		
		if (param.matches("[a-zA-Z]*")  )
			return false;
		return true;

	}

	public static boolean validateNumber(String param) {
		if (!param.matches("[0-9]*"))
			return false;
		return true;

	}

	public static boolean isEmpty(String param) {
		if (param != null)
			if (param == "" || param.trim().isEmpty())
				return true;

		return false;

	}

	public static boolean EmailFormatValidator(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		if (matcher.matches() && email.endsWith(".com"))
			return true;
		return false;
	}

	public static String getDay(int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, day);
		return c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG,
				new Locale("en"));

	}
public static void main(String[] args) {
	System.out.println(base64encode("dip"));
	System.out.println(base64decode(base64encode("dip")));
	
}
}
