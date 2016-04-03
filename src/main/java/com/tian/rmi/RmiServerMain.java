package com.tian.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServerMain {

	public static void main(String[] args) {
		IHelloService service = new RemoteHelloServiceImpl();
		try {
//			创建和导出远程对象,定义匿名的tcp端口来接收远程方法调用,返回stub对象
			IHelloService stub = (IHelloService) UnicastRemoteObject.exportObject(service, 8989);
			LocateRegistry.createRegistry(1099);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("hello", stub);
			System.out.println("Server ready");
		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
