package com.tian.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiMain {
	public static void main(String[] args) {
		ServiceLoader<SimpleService> cs = ServiceLoader.load(SimpleService.class);
		Iterator<SimpleService> itr = cs.iterator();
		while (itr.hasNext()) {
			SimpleService service = itr.next();
			service.say("haha");
		}
	}
}
