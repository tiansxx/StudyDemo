package com.tian.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHelloService extends Remote {
	String hello(String s) throws RemoteException;
	void sayHello() throws RemoteException;
}
