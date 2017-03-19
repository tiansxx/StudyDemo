package com.tian.instrumentation;

import java.lang.instrument.Instrumentation;

public class SimplePremain {

	/**
	 * 类转换发生在premain执行之后, main方法执行之前
	 * 每装载一个类, transform都会执行一次
	 * @param agentArgs
	 * @param inst
	 */
	public static void premain(String agentArgs, Instrumentation inst) {
		System.out.println("premain");
		inst.addTransformer(new EnhanceHandlerAgent());
	}
	
	public static void premain(String agentArgs) {
		
	}
	
}
