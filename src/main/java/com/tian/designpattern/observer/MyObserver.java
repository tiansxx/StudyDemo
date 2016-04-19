package com.tian.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Subject = " + o.getClass());
		System.out.println("###########" + arg);
	}

}
