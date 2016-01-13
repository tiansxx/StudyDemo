package com.tian.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlHandler extends DefaultHandler {

	private boolean isId = false;
	private boolean isName = false;
	private boolean isSalary = false;
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("Start Element :\t" + qName);
		
		if ("id".equals(qName)) {
			isId = true;
		}
		
		if ("name".equals(qName)) {
			isName = true;
		}
		
		if ("salary".equals(qName)) {
			isSalary = true;
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("End Element :\t" + qName);
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (isId) {
			System.out.println("Id :\t" + new String(ch, start, length));
			isId = false;
		}
		
		if (isName) {
			System.out.println("Name :\t" + new String(ch, start, length));
			isName = false;
		}
		
		if (isSalary) {
			System.out.println("Salary :\t" + new String(ch, start, length));
			isSalary = false;
		}
		
	}
	
	
	
}
