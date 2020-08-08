package entity;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> {

	private List<K> keys;
	private List<V> values;
	

	public MyMap() {
		keys = new ArrayList<K>();
		values = new ArrayList<V>();
	}

	public void put(K key, V value) {
		keys.add(key);
		values.add(value);
	}
	
	public V getValue(K key) {
		int index = keys.indexOf(key);
		
		return values.get(index);
	}
	
	public List<K> getKey(V value) {
		
		List<K> keyDup = new ArrayList<K>();
		
		for (int i=0; i<values.size(); i++) {
			if( values.get(i) == value) {
				keyDup.add(keys.get(i));
			}
		}
		return keyDup;
	}
	
}
