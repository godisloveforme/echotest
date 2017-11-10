package com.framework.automation.cucumber.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;

public class ReflectorUtil {
	private final static Logger log = LogManager.getLogger(ReflectorUtil.class);
	
	public Object getProperties(final Object objectBean, final String propertyName) {
		PropertyAccessor actualAccessor = PropertyAccessorFactory.forBeanPropertyAccess(objectBean);
		if (actualAccessor.isReadableProperty(propertyName)) {
			Object value = actualAccessor.getPropertyValue(propertyName);
			return value;
		} else {
			return null;
		}
	}

	
	public static String compareAttributeValues(final Object actualObj, final Object expectedObj, final String attributeList) {
		PropertyAccessor actualAccessor = PropertyAccessorFactory.forBeanPropertyAccess(actualObj);
		PropertyAccessor expectedAccessor = PropertyAccessorFactory.forBeanPropertyAccess(expectedObj);
		String errorMsg = null;
		
		for (String attr : attributeList.split(",")) {
			if ((expectedAccessor.getPropertyValue(attr)==null && actualAccessor.getPropertyValue(attr)!=null)) {
				errorMsg = "Matching attribute" + attr + " for " + expectedObj.toString() + ", expected: " + expectedAccessor.getPropertyValue(attr) + ", while actual is: " + actualAccessor.getPropertyValue(attr);
			} else if (!expectedAccessor.getPropertyValue(attr).equals(actualAccessor.getPropertyValue(attr))){
				errorMsg = "Matching attribute" + attr + " for " + expectedObj.toString() + ", expected: " + expectedAccessor.getPropertyValue(attr) + ", while actual is: " + actualAccessor.getPropertyValue(attr);
			}
		}
		return errorMsg;
	}
}
