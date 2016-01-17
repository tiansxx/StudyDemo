package com.tian.xml;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxXmlHandler extends DefaultHandler {

	private Object bean;
	
	private String currentTagName;
	
	public SaxXmlHandler(Object bean) {
		this.bean = bean;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		currentTagName = qName;
		
//		handle tag attribute
		for (int i = 0; i < attributes.getLength(); i++) {
			String attrName = attributes.getQName(i);
			String attrValue = attributes.getValue(i);
			invokeSetMethod(bean, qName, attrName, attrValue);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (currentTagName != null) {
			invokeSetMethod(bean, currentTagName, null, new String(ch, start, length));
		}
		currentTagName = null;
	}
	
	private void invokeSetMethod(Object bean, String qName, String attrName, String attrValue) {
		
		String methodName = null;
		if (qName != null || attrName != null) {
			methodName = "set";
			if (qName != null) {
				methodName += Character.toUpperCase(qName.charAt(0)) + qName.substring(1);
			}
//			'value'属性对应的值即标签值,不需要再查找对应的属性setter方法
			if (!"value".equals(attrName)) {
				if (attrName != null) {
					methodName += Character.toUpperCase(attrName.charAt(0)) + attrName.substring(1);
				}
			} else {
				currentTagName = null;	//<id value="xx"/>	<name value="xx"></name>
			}
		}
		
//		根据反射找到对应的setter方法并赋值
		Class<? extends Object> clazz = bean.getClass();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				try {
//					XML中的值默认为String类型,需要转化为setter方法的参数类型
					Object realValue = convert(method, attrValue);
					method.invoke(bean, new Object[] {realValue});
					return;
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return;
	}
	
	/**
	 * convert XML attribute value from {@code String} to target parameter type
	 * @param method
	 * @param attrValue
	 * @return
	 */
	private Object convert(Method method, String attrValue) {
		
		Class<?> toClass = method.getParameterTypes()[0];
		if (Long.class == toClass || Long.TYPE == toClass) {
			return Long.decode(attrValue);
		}
		if (Integer.class == toClass || Integer.TYPE == toClass) {
			return Integer.decode(attrValue);
		}
		if (Boolean.class == toClass || Boolean.TYPE == toClass) {
			if ("true".equalsIgnoreCase(attrValue) || "false".equalsIgnoreCase(attrValue)) {
				return Boolean.valueOf(attrValue);
			}
		}
		
		return attrValue;
	}
}
