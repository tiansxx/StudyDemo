package com.tian.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * Simple RPC Framework implementation
 * 
 * @author tian
 *
 */

public class RPCFramework {

	/**
	 * 
	 * export service
	 * 
	 * @param service
	 * @param port
	 */
	public static void export(final Object service, int port) throws Exception {
		if (service == null) 
			throw new IllegalArgumentException("export service is null");
		if (port <= 0 || port >= 65536)
			throw new IllegalArgumentException("Invalid port : " + port);

		System.out.println("Export service " + service.getClass().getName() + " on port " + port);

		ServerSocket server = new ServerSocket(port);
		while (true) {
			final Socket socket = server.accept();
			new Thread(new Runnable() {

				private String methodName;
				private Class<?>[] parameterTypes;
				private Object[] arguments;

				private void parseRequest(ObjectInputStream ois) {
					try {
						methodName = ois.readUTF();
						parameterTypes = (Class<?>[])ois.readObject();
						arguments = (Object[]) ois.readObject();
					} catch (ClassNotFoundException | IOException e) {
						e.printStackTrace();
					}
				}

				private void sendResponse(ObjectOutputStream oos, Object service) {
					try {
						Method method = service.getClass().getMethod(methodName, parameterTypes);
						Object result = method.invoke(service, arguments);
						oos.writeObject(result);
						oos.flush();
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException | 
							IllegalArgumentException | InvocationTargetException | IOException e) {
						e.printStackTrace();
					}
				}

				@Override
				public void run() {
					ObjectInputStream ois = null;
					ObjectOutputStream oos = null;
					try {
						ois = new ObjectInputStream(socket.getInputStream());

						parseRequest(ois);

						oos = new ObjectOutputStream(socket.getOutputStream());

						sendResponse(oos, service);

					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (oos != null) {
							try {
								oos.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (ois != null) {
							try {
								ois.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (socket != null) {
							try {
								socket.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}

			}).start();
		}
	}


	/**
	 * 
	 * Reference Service
	 *  
	 * @param interfaceClass
	 * @param host
	 * @param port
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) {

		if (interfaceClass == null) 
			throw new IllegalArgumentException("Interface class is null");
		if (!interfaceClass.isInterface())
			throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface");
		if (host == null || host.length() == 0)
			throw new IllegalArgumentException("Invalid host");
		if (port <= 0 || port >= 65536)
			throw new IllegalArgumentException("Invalid port " + port);
		System.out.println("Get remote service [" + interfaceClass.getName() + "] from server " + host + ":" + port);
		
		return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
			
			private Object result;
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Socket socket = new Socket(host, port);
				ObjectOutputStream oos = null;
				ObjectInputStream ois = null;
				try {
				oos = new ObjectOutputStream(socket.getOutputStream());
				
				oos.writeUTF(method.getName());
				oos.writeObject(method.getParameterTypes());
				oos.writeObject(args);
				
				
				ois = new ObjectInputStream(socket.getInputStream());
				result = ois.readObject();
				} catch(Exception e) {
					
				} finally {
					if (ois != null) {
						
					}
					if (oos != null) {
						
					}
					if (socket != null) {
						
					}
				}
				return result;
			}
		});
	}
}
