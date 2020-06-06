package com.banepali.dataBase.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static Date dateFromString(String dateInString) {
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 Date date=null;
	        try {
	             date = formatter.parse(dateInString);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return date;
	}




public static Time timeFromString(String timeInString) {
	 SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
	 Date date=null;
       try {
            date = formatter.parse(timeInString);
       } catch (ParseException e) {
           e.printStackTrace();
       }
       return new java.sql.Time(date.getTime());
}

}