package com.framework.automation.cucumber.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ParseException;
import org.springframework.util.MethodInvoker;

import com.opencsv.CSVReader;


public class TestDataCsvReader {
	public final static Logger log= LogManager.getLogger(TestDataCsvReader.class);
	public static String dataFormat = "yyyyMMdd HH:mm:ss";
	
	public static String getDataFormat() {
		return dataFormat;
	}
	public static void setDataFormat(String dataFormat) {
		TestDataCsvReader.dataFormat = dataFormat;
	}
	
	public static HashMap<String, Object> loadBusinessObjectFromCsv(final String inputFilePath, final String businessObject, final String matchKeyList) throws Exception  {
		ApplicationContext context = new ClassPathXmlApplicationContext("cucumber_spring_config.xml");
		HashMap<String, Object> testData = new HashMap<String, Object>();
		MethodInvoker invoker = new MethodInvoker();
		String matchKey = null;
		
		try {
			InputStream is = CSVParser.class.getClassLoader().getResourceAsStream(inputFilePath);
			CSVReader reader = new CSVReader(new InputStreamReader(is));
			
			String[] headers = reader.readNext();
			String[] nextLine;
			
			newLine: while ((nextLine = reader.readNext()) != null) {
				Object bean = context.getBean(businessObject);
			    PropertyAccessor myAccessor = PropertyAccessorFactory.forBeanPropertyAccess(bean);
			    matchKey = "";
			    
			    for (int i =0; i < headers.length; i++) {
			    	Class<?> propertyType = myAccessor.getPropertyType(headers[i]);
			    	
			    	if (propertyType != null) {
			    		switch (propertyType.getName()) {
			    		case "java.util.Date":
			    			SimpleDateFormat ft= new SimpleDateFormat(TestDataCsvReader.dataFormat);
			    			try{
			    				if (nextLine[i].isEmpty()){
			    					break;
			    				}
			    				myAccessor.setPropertyValue(headers[i], ft.parse(nextLine[i]));
			    			} catch (BeansException e) {
			    				TestDataCsvReader.log.error(e.getMessage());
			    			} catch(ParseException e) {
			    				TestDataCsvReader.log.error(e.getMessage());
			    				continue newLine;
			    			}
			    			break;
			    			default:
			    				myAccessor.setPropertyValue(headers[i],nextLine[i]);
			    		}
			    	}
			    }
			    if (matchKeyList != null) {
			    	for (String s: matchKeyList.split(",")) {
			    		for (int i = 0; i < headers.length; i++) {
			    			if (s.equals(headers[i])) {
			    				matchKey += nextLine[i];
			    				matchKey += "~";
			    			}
			    		}
			    	}
			    }
			    
			    if (matchKey.length() > 0) {
			    	matchKey = matchKey.substring(0, matchKey.length()-1);
			    	testData.put(matchKey, bean);
			    } else {
			    	invoker.setTargetMethod("getBusinessKey");
			    	
			    	try {
			    		invoker.setTargetObject(bean);
			    		invoker.prepare();
			    		testData.put(invoker.invoke().toString(), bean);
			    		
			    	} catch (InvocationTargetException e){
			    		TestDataCsvReader.log.error(e.getMessage());
			    	} catch (IllegalAccessException e) {
			    		TestDataCsvReader.log.error(e.getMessage());
			    	} catch (ClassNotFoundException e) {
			    		TestDataCsvReader.log.error(e.getMessage());
			    	} catch (NoSuchMethodException e) {
			    		TestDataCsvReader.log.error(e.getMessage());
			    	}
			    }
			}
			reader.close();
			is.close();
		}  catch (FileNotFoundException e) {
			TestDataCsvReader.log.error(e.getMessage());
		}  catch (IOException e) {
			TestDataCsvReader.log.error(e.getMessage());
		}
		
		((ConfigurableApplicationContext) context).close();
		return testData;
		
	}
	
	public static String constructMatchingKey(final String matchingKey, final Object businessObject) {
		ReflectorUtil util = new ReflectorUtil();
		String matchKey = null;
		for (String s: matchingKey.split(",")) {
			String value = (String) util.getProperties(businessObject, s);
			matchKey += value;
			matchKey += "~"; 
		}
		return matchKey;
	}
	
	public static void main(final String[] args) throws Exception {
		TestDataCsvReader.log.info(TestDataCsvReader.loadBusinessObjectFromCsv("testdata/example/hopperTest.csv", "hopper", "hopperId"));
	}

}
