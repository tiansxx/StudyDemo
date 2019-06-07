package com.tian.resource.loader;

import java.net.URL;

import sun.misc.URLClassPath;

public class SourcePathDemo {

	public static void main(String[] args) {
		
		URLClassPath bootstrapClassPath = sun.misc.Launcher.getBootstrapClassPath();
		URL[] urLs = bootstrapClassPath.getURLs();
		for (URL url : urLs) {
			System.out.println(url.getPath());
		}
		
		System.out.println(SourcePathDemo.class.getResource("").getPath());		//不带前缀，则默认加上当前类的包路径
		System.out.println(SourcePathDemo.class.getResource("/").getPath());	//带前缀，则以当前类的根路径开始
		System.out.println(SourcePathDemo.class.getClassLoader().getResource("").getPath());
	}
}
