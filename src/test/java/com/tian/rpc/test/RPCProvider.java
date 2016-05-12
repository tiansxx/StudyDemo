package com.tian.rpc.test;

import com.tian.proxy.Hello;
import com.tian.proxy.HelloImpl;
import com.tian.socket.RPCFramework;

public class RPCProvider {

	public static void main(String[] args) throws Exception {
		Hello hello = new HelloImpl();
		RPCFramework.export(hello, 65535);
	}
}
