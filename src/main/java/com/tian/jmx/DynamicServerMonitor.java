package com.tian.jmx;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.ReflectionException;

/**
 * DynamicMBean
 * @author tian
 *
 */

public class DynamicServerMonitor implements DynamicMBean {

	@Override
	public Object getAttribute(String attribute)
			throws AttributeNotFoundException, MBeanException, ReflectionException {
		if (attribute == null) 
			return null;
		return null;
	}

	@Override
	public void setAttribute(Attribute attribute)
			throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
		
	}

	@Override
	public AttributeList getAttributes(String[] attributes) {
		if (attributes == null)
			return null;
		AttributeList attrList = new AttributeList();
		for (int i = 0; i < attributes.length; i++) {
			try {
				Object value = getAttribute(attributes[i]);
				attrList.add(new Attribute(attributes[i], value));
			} catch (AttributeNotFoundException | MBeanException | ReflectionException e) {
				e.printStackTrace();
			}
		}
		return attrList;
	}

	@Override
	public AttributeList setAttributes(AttributeList attributes) {
		return null;
	}

	@Override
	public Object invoke(String actionName, Object[] params, String[] signature)
			throws MBeanException, ReflectionException {
		return null;
	}

	@Override
	public MBeanInfo getMBeanInfo() {
		return null;
	}

}
