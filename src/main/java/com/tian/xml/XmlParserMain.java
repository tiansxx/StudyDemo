package com.tian.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Simple API for XML
 * @author tian
 *
 */

public class XmlParserMain {

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(XmlParserMain.class.getResourceAsStream("file.xml"), new XmlHandler());
	}
}
