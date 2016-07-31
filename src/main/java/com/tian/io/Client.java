package com.tian.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

	public static void main(String[] args) throws IOException {
		
		InetSocketAddress local = new InetSocketAddress("127.0.0.1", 0xffff);
		SocketChannel client = SocketChannel.open(local);
		
		ByteBuffer buf = ByteBuffer.allocate(74);
		
		int size = client.read(buf);
		
		
		
	}

}
