package com.tian.annotation;

public class AnnotationMain {

	public static void main(String[] args) {
		Example ex = new Example();
		
		Assignment annotation = ex.getClass().getAnnotation(Assignment.class);
		if (annotation != null) {
			System.out.println(annotation.assignee());
			System.out.println(annotation.effort());
			System.out.println(annotation.finished());
		}
	}
	
}
