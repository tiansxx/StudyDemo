package com.tian.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		Set<Entry<String, String>> entrySet = map.entrySet();
//		java.util.HashMap.EntrySet -> java.util.HashMap.EntryIterator
		Iterator<Entry<String, String>> itr = entrySet.iterator();	
		
		Set<String> keySet = map.keySet();
//		java.util.HashMap.KeySet -> java.util.HashMap.KeyIterator
		Iterator<String> keyItr = keySet.iterator();	
		
		Collection<String> values = map.values();
//		java.util.HashMap.Values -> java.util.HashMap.ValueIterator
		Iterator<String> valItr = values.iterator();	
		
		Map<String, String> m = MapMain.newInstance();
	}
	
	static <K, V> HashMap<K, V> newInstance() {
		return new HashMap<K, V>();
	}
}
