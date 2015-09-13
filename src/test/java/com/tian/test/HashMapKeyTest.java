package com.tian.test;

import java.util.HashMap;
import java.util.Map;

public class HashMapKeyTest {

	public static class Key {
		String k;
		String v;
		public Key(String k, String v) {
			this.k = k;
			this.v = v;
		}
		
		public void setK(String k) {
			this.k = k;
		}

		@Override
		public String toString() {
			return "Key [k=" + k + ", v=" + v + "]";
		}
		
	}

	public static void main(String[] args) {
		Map<Key, String> map = new HashMap<Key, String>();
		Key key = new Key("k", "v");
		map.put(key, "value");
		System.out.println(map);
		
		key.setK("kk");
		System.out.println(map);
	}
	
}
