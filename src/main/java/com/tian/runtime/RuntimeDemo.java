package com.tian.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeDemo {

	public static void main(String[] args) throws Exception {
		invokeBat();
	}
	
	static void invokeBat() throws IOException {
		Process exec = Runtime.getRuntime().exec(RuntimeDemo.class.getResource("print.bat").getPath());
		BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));
		
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
	}
	
}
