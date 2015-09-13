package com.tian.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DnsHostTest {
	
	public static void main(String[] args) throws UnknownHostException {
		String host = "www.baidu.com";
		
		InetAddress byName = InetAddress.getByName(host);
		System.out.println(byName + "\t" + byName.getHostAddress());
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost + "\t" + localHost.getHostAddress());
	}

}
