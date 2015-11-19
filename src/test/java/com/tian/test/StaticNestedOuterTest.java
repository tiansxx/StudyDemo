package com.tian.test;

import com.tian.classes.nested.StaticNestedOuter;
import com.tian.classes.nested.StaticNestedOuter.StaticNested;

public class StaticNestedOuterTest {

	
	public static void main(String[] args) {
		
//		StaticNestedOuter outer = new StaticNestedOuter();
		
		StaticNested staticNested = new StaticNestedOuter.StaticNested();
		staticNested.printNested();
		
		StaticNested sn = new StaticNested();
		sn.printNested();
		
		
	}
	
}
