package com.tian.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {

	public static void main(String[] args) throws IOException {
		
//		接受入站连接,无法读取、写入或连接ServerSocketChannel
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		ServerSocket ss = serverChannel.socket();
		ss.bind(new InetSocketAddress(0xffff));	//ServerSocket在65535端口监听
		
		serverChannel.configureBlocking(false);	//设置非阻塞监听
//		SocketChannel socketChannel = serverChannel.accept();	//非阻塞,如果没有入站连接立即返回null
		
		Selector sel = Selector.open();	//选择器,允许线程迭代处理所有准备好的连接
		serverChannel.register(sel, SelectionKey.OP_ACCEPT);	//为通道注册监视选择器
		
		while (true) {
			sel.select();
			
			Set<SelectionKey> readyKeys = sel.selectedKeys();
			Iterator<SelectionKey> itr = readyKeys.iterator();
			while (itr.hasNext()) {
				SelectionKey key = itr.next();
				itr.remove();
				
				if (key.isAcceptable()) {	//是否满足OP_ACCEPT
					ServerSocketChannel channel = (ServerSocketChannel)key.channel();
//					可以连接、读取、写入和关闭
					SocketChannel client = channel.accept();
					System.out.println("Accepted Connection from : " + client);
					client.configureBlocking(false);
					
					SelectionKey clientKey = client.register(sel, SelectionKey.OP_WRITE);
					ByteBuffer buf = ByteBuffer.allocate(74);
					buf.put("xxx".getBytes());
					//...
					buf.flip();
					clientKey.attach(buf);
				} else if (key.isWritable()) {	//是否满足OP_WRITE
					SocketChannel client = (SocketChannel)key.channel();
					ByteBuffer attachment = (ByteBuffer)key.attachment();
					//...
					client.write(attachment);
					
				}
			}
			
		}
		
		
		
		
	}
}
