package com.framework.automation.cucumber.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVParser {

	public CSVParser() {
		
	}
	
	public static List<String[]> parseCSVFile(final String filePath) throws Exception {
		if("".equals(filePath) || filePath == null) {
			Exception exception = new Exception("file path is null");
			throw exception;
		}
		InputStream is = CSVParser.class.getClassLoader().getResourceAsStream(filePath);
		CSVReader csvReader = new CSVReader(new InputStreamReader(is));
		List<String[]> entries = new ArrayList<String[]> ();
		try {
			entries = csvReader.readAll();
		} catch (IOException e) {
			throw e;
		} finally {
			csvReader.close();
			is.close();
		}
		if (entries.size() < 2 ) {
			throw new Exception("No data entry in the csv file");
		}
		return entries;
	}

	public static Boolean validateColumns(final String[] expectedColumns, final String[] actualColumns) throws Exception{
		String[] cloneExpectedColumns = Arrays.copyOf(expectedColumns, expectedColumns.length);
		String[] cloneactualColumns = Arrays.copyOf(actualColumns, actualColumns.length);
		
		// remove the whitespace from the expected columns
		for (int i=0; i<=cloneExpectedColumns.length; i++) {
			cloneExpectedColumns[i] = cloneExpectedColumns[i].trim().replaceAll("\\s", "").toLowerCase();
		}
		
		// remove the whitespace from the actual columns
				for (int i=0; i<=cloneactualColumns.length; i++) {
					cloneactualColumns[i] = cloneactualColumns[i].trim().replaceAll("\\s", "").toLowerCase();
				}
				
		return Arrays.equals(cloneExpectedColumns, cloneactualColumns);
	}
}
