package com.tian.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	public void listener() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(0xffff);
			System.out.println("http server is listening on port : " + (0xffff));
			while (true) {
				socket = serverSocket.accept();
//				readByBytes(socket);
				readByStr(socket);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void readByBytes(Socket socket) throws IOException {
		InputStream ins = socket.getInputStream();
		byte[] buffer = new byte[ins.available()];
		ins.read(buffer);
		System.out.println("===================");
		System.out.println(new String(buffer));
		System.out.println("===================");
//		System.out.println("the last 16 bytes : " + new String(buffer, ins.available() - 17, 16));
		
		sendResp(socket);
		
		socket.close();
	}
	
	public void readByStr(Socket socket) throws IOException {
		InputStream ins = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(ins));
		int len = ins.available();
		System.out.println("total bytes number : " + len);
		String line = null;
		StringBuilder sbd = new StringBuilder();
		
		int remain = len;
		int l = 0;
		while ((line = br.readLine()) != null && !line.equals("")) {
			l = line.getBytes().length;
			remain = remain - l;
			System.out.println("current line : " + line	+ " ||[ " + l + " , " + remain + " ] " + "\r\n\r\n".equals(line));
			sbd.append(line);
		}
		System.out.println(sbd);
		
		sendResp(socket);
		
		socket.close();
	}
	
	public static void main(String[] args) {
		new HttpServer().listener();
	}
	
	public void sendResp(Socket socket) throws IOException {
		String respStatusLine = "HTTP/1.1 200 OK\r\n";
		String respHeaders = "Content-Type: text/html; charset=utf-8\r\n\r\n";
		String content = "Hello World";
		OutputStream outs = socket.getOutputStream();
		outs.write(respStatusLine.getBytes());
		outs.write(respHeaders.getBytes());
		outs.write(content.getBytes());
		outs.flush();
		outs.close();
	}
}
