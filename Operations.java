package mitter.map;

import java.util.ArrayList;

public interface Operations {

	
	// There are only four types of operation that a given user can perform	
    // store() => For storing key/value pair in storeMap instance that is actually a modified map
	// get() => This function will return a list of value for corresponding keys 
	// query => Its internally call two method first method 
	// queryGt() => it will return list of float greater than given target
	// query() => It will return list of value matching to given list of key 
	
	boolean store(String key,String value);
	ArrayList<String> get(ArrayList<String> keys);
	ArrayList<String> query(String key);
	ArrayList<Float> queryGt(String key);
	

}
