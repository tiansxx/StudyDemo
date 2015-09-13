package com.tian.designpattern;

public class DesignMain {

	public static void main(String[] args) {
		MyObserver myObserver = new MyObserver();
		
		WeatherData weatherData = new WeatherData();
		weatherData.addObserver(myObserver);
		weatherData.changeTemperature("100");
	}
}
