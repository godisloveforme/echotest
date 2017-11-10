package com.framework.automation.cucumber.env;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;




public class EnvironmentPreparer {
	
	private boolean isReady;
	private Properties envInfo;
	private static EnvironmentPreparer instance;
	private final static Logger log = LogManager.getLogger(EnvironmentPreparer.class);
	
	private EnvironmentPreparer(){
		
	}

	public static EnvironmentPreparer getInstance(){
		if(EnvironmentPreparer.instance==null) {
			EnvironmentPreparer.instance = new EnvironmentPreparer();
		}
		return EnvironmentPreparer.instance;
	}
	
	public boolean isReady() {
		return this.isReady;
	}
	
	private  void setReady(final boolean isReady) {
	this.isReady = isReady;	
	}
	
	public void prepare(final String envId) {
		String fileURL = "env/properties/"+envId+".properties";
		
		Resource resource = new ClassPathResource(fileURL);
		this.envInfo = new Properties();
		
		try {
			InputStream is = resource.getInputStream();
			this.envInfo.load(is);
			this.envInfo.put(EnvConstant.TEST_SESSION_NAME, this.constructSessionName(envId));
			
			setReady(true);
			EnvironmentPreparer.log.info("Complete preparation for test environment: " + envId);
		} catch (IOException e) {
			setReady(false);
			EnvironmentPreparer.log.info("Incomplete preparation for test environment: " + envId);
		}
	}
	
	public String getEnvInfo(final String key) {
		return this.envInfo.getProperty(key,"");
	}
	
	private String constructSessionName (final String envId) {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
		Date date = new Date();
		return envId + "_" + dateFormat.format(date);
	}
	
}
