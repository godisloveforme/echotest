package com.framework.automation.cucumber.run;

import java.util.Locale;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.BeforeClass;

@RunWith(Cucumber.class)
@CucumberOptions( 
		plugin = { "pretty", "html:target/cucumber", "json:target/cucumber-report.json" }, 
		features = {"src/main/resources/features/LoginTest.feature" },
		glue = {"com.framework.automation.cucumber.steps"},
		monochrome = true
		)

public class RunTest {
	@BeforeClass
	public static void setup() {
		System.out.println("Run the before");
		Locale.setDefault(Locale.UK);
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
				"com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
		System.setProperty("javax.xml.parsers.SAXParserFactory",
				"com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");
		System.setProperty("javax.xml.transform.TransformerFactory",
				"com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
		
	}

	
}
