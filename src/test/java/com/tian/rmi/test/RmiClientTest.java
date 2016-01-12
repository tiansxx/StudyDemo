package com.tian.rmi.test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.junit.Test;

import com.tian.rmi.IHelloService;

public class RmiClientTest {
	
	@Test
	public void remote() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
		IHelloService remote = (IHelloService) registry.lookup("hello");
		System.out.println(remote.hello("Java"));
		remote.sayHello();
	}

}
