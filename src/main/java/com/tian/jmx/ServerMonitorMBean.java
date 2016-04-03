package com.tian.jmx;

/**
 * 标准MBean
 * 
 * MXBean规定标准 MBean要实现一个接口，所有向外界公开的方法都要在这个接口中声明
 * @author tian
 *
 */

public interface ServerMonitorMBean {
	String getState();
	void setState(String state);
}
