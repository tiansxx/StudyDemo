package com.tian.jmx;

public class ServerMonitor implements ServerMonitorMBean {

	private String state;
	
	@Override
	public String getState() {
		return state;
	}

	@Override
	public void setState(String state) {
		this.state = state;
	}

}
