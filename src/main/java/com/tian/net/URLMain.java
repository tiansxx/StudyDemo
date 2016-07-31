package com.tian.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLMain {

	public static void main(String[] args) throws Exception {
//		openStream();
		openConnection();
//		others();
	}

	public static void openStream() {
		BufferedReader br  = null;

		try {
			URL url = new URL("http://www.baidu.com");

			InputStream stream = url.openStream();
			br = new BufferedReader(new InputStreamReader(stream));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch(IOException ex) {

		} finally {
			if (br != null) {
				try {
					br.close();
				} catch(IOException e) {

				}
			}
		}
		
		
		try (BufferedReader bfr = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream()))) {
			String l = null;
			while ((l = bfr.readLine()) != null) {
				System.out.println(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void openConnection() throws Exception {
		
		URL url = new URL("http://www.baidu.com");
		
		URLConnection conn = url.openConnection();
//		获取HTTP首部信息
		System.out.println(conn.getContentType());
		System.out.println(conn.getContentLength());
		System.out.println(conn.getContentLengthLong());
		System.out.println(conn.getContentEncoding());
		
		String header = null;
		int i = 1;
		do {
			header = conn.getHeaderField(i);
			System.out.println(conn.getHeaderFieldKey(i) + ":\t" + header);
			i++;
		} while (header != null);
		
	}
	
	public static void getContent() throws Exception {
		URL url = new URL("http://www.baidu.com");
		System.out.println(url.getContent().getClass().getName());
	}
	
	public static void others() throws Exception {
		URL url = new URL("http://www.baidu.com");
		
		System.out.println(url.toExternalForm());
	}
}
