package com.tian.designpattern;

import java.util.Observable;

public class WeatherData extends Observable {
	
	@SuppressWarnings("unused")
	private String temperature;
	
	public void changeTemperature(String temperature) {
		this.temperature = temperature;
		updateState(temperature);
	}
	
	private void updateState(String temperature) {
//		将被观察者状态设为已改变
		setChanged();
//		notifyObservers();
//		通知该被观察者上的观察者对象
		notifyObservers("Current temperature = " + temperature + "");
	}
	
}
