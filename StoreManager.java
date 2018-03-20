package mitter.map;

import java.util.HashMap;

public class StoreManager {
	
	// This class will store key/value pair into given map instance where 
	// type of value will be Store.Store have two list of type String and Float,
	// for efficently managing storeManager.
	
	private HashMap<String, Store> storeMap;

	public StoreManager() {
		storeMap = new HashMap<String,Store>();
	}

	public HashMap<String, Store> getStoreMap() {
		return storeMap;
	}

}
