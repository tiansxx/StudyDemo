package com.tian.inter;

public class RunImpl implements IRun {

	@Override
	public void run() {
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		new RunImpl().run();
	}

	
	
}
