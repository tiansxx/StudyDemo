package com.tian.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Simple API for XML
 * @author tian
 *
 */

public class SaxXmlParserMain {

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		Employee bean = new Employee();
		parser.parse(SaxXmlParserMain.class.getResourceAsStream("employee.xml"), new SaxXmlHandler(bean));
		System.out.println(bean);
	}
}
