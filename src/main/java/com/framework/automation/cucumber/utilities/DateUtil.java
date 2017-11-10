package com.framework.automation.cucumber.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";
	
	
	/**
     * convert String date to Date date  
     * @param dateStr
     * @return
     */
    public static Date convert2Date(String dateStr) {  
        SimpleDateFormat simple = new SimpleDateFormat(DATE_DEFAULT_FORMAT); 
        try {  
            simple.setLenient(false);  
            return simple.parse(dateStr);  
        } catch (Exception e) {  
            return  null;  
        }  
     }  
    
    /**
     * convert Date date to String date
     * @param date
     * @param format
     * @return
     */
    public static String convert2String(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
        try {
            return formater.format(date);
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Obtain current date
     * @param format
     * @return
     */
    public static String getCurrentDate(String DATE_DEFAULT_FORMAT) {
        return new SimpleDateFormat(DATE_DEFAULT_FORMAT).format(new Date());
    }
    
    /**
    * obtain future date
    * @param format
    * @param n day after
    */
    public static String getFutureDate(String  DATE_DEFAULT_FORMAT, int n) {
    	Calendar c = Calendar.getInstance(); 
    	c.set(Calendar.DATE, c.get(Calendar.DATE) + n);
    	return new SimpleDateFormat(DATE_DEFAULT_FORMAT).format(c.getTime());	
    }
    
}
