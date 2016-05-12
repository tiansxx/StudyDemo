package com.tian.rpc.test;

import com.tian.proxy.Hello;
import com.tian.socket.RPCFramework;

public class RPCConsumer {
	
	public static void main(String[] args) {
		Hello hello = RPCFramework.refer(Hello.class, "127.0.0.1", 65535);
//		hello.hello();
		System.out.println(hello.hello("tian"));
	}
}
