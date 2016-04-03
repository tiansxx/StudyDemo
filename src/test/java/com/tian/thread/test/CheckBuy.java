package com.tian.thread.test;

import java.util.concurrent.ConcurrentHashMap;

public class CheckBuy {
	
//	当前已购买用户数据
	private ConcurrentHashMap<String, Integer> data = new ConcurrentHashMap<>();
	
//	当前可购买总金额
	private volatile int amount = 2000000;
//	当前可购买余额
	private int getCurrentBalance() {
		return amount;
	}
//	扣减金额
	private int setCurrentBalance(int i) {
		return amount - i;
	}
	/**
	 * 购买方法 
	 * @param count 用户想购买的总金额
	 * @return true 表示购买成功,false表示失败
	 */
	public boolean buy(int count) {
		
		if (count < 1000 || count > 20000 || count % 1000 != 0) {
			return false;
		}
		
//		获取当前余额
		int currentBalance = getCurrentBalance();
		if (currentBalance > count) {
			synchronized (data) {
				setCurrentBalance(count);
				data.put(Thread.currentThread().getName(), count);
				return true;
			}
		}
		return false;
	}

}
