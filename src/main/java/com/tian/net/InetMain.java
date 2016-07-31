package com.tian.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class InetMain {

	public static void main(String[] args) throws UnknownHostException, SocketException {
//		getLocalHost();
		networkInterface();
	}
	
	public static void getRemoteHost() throws UnknownHostException {
//		InetAddress net = InetAddress.getByName("www.baidu.com");
		InetAddress net = InetAddress.getByName("www.taobao.com");
		System.out.println(net);
		System.out.println(net.getHostAddress());		//获取IP地址
//		System.out.println(net.getCanonicalHostName());	//通过DNS获取IP地址
		System.out.println(net.getHostName());			//获取域名
		System.out.println();
		
		InetAddress[] nets = InetAddress.getAllByName("www.taobao.com");
		for (InetAddress addr : nets) {
			System.out.println(addr);
		}
	}
	
	public static void getLocalHost() throws UnknownHostException {
		System.out.println(InetAddress.getByAddress(new byte[]{127, 0, 0, 1}));
		System.out.println(InetAddress.getLocalHost());	//如果可以联网,则获取网络地址;否则返回tian/127.0.0.1
		System.out.println(InetAddress.getLocalHost().getHostName());
		System.out.println(InetAddress.getLocalHost().getHostAddress());
		System.out.println(InetAddress.getLoopbackAddress());
	}
	
	public static void networkInterface() throws SocketException {
//		Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
//		while (nis.hasMoreElements()) {
//			System.out.println(nis.nextElement());
//		}
		
		NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress.getLoopbackAddress());
		System.out.println(ni);
	}
	
}
