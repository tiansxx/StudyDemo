package com.tian.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class JmxMain {

	public static void main(String[] args) throws Exception {
		JmxMain jmxMain = new JmxMain();
		
		ServerMonitor mbean = new ServerMonitor();
		
		jmxMain.init(mbean);
		
		while (true) {
			System.out.println(mbean.getState());
			Thread.sleep(2000);
		}
	}

	private void init(ServerMonitor mbean) throws Exception {
//		MBeanServer server = MBeanServerFactory.createMBeanServer();	//无法在JConsole使用
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		System.out.println(server.getDefaultDomain());
		ObjectName objectName = new ObjectName("com.tian.jmx:type=SeverMonitor");
		
		server.registerMBean(mbean, objectName);
	}

}
