package com.tian.designpattern.observer;

public class ObserverMain {

	public static void main(String[] args) {
		MyObserver myObserver = new MyObserver();
		
		WeatherData weatherData = new WeatherData();
		weatherData.addObserver(myObserver);
		weatherData.changeTemperature("100");
	}
}
