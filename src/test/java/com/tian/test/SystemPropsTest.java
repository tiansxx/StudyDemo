package com.tian.test;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;

public class SystemPropsTest {

	@Test
	public void listProps() {
		Properties props = System.getProperties();
		Iterator<Entry<Object, Object>> itr = props.entrySet().iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
}
