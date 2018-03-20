package mitter.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class OperationsImpl implements Operations {
	
	
	//This class actually performing all operation regarding to StoreMap

	public StoreManager storeManager;

	public OperationsImpl() {
		storeManager = new StoreManager();
	}

	public StoreManager getStoreManager() {
		return storeManager;
	}

	
    // first operation for storing key/value pair to map
	
	@Override
	public boolean store(String key, String value) {
		if(key!=null ){
			if (!storeManager.getStoreMap().containsKey(key)) {
				Store store = new Store();
				if (isNumber(value)) {
					store.getNumberStore().add(Float.parseFloat(value));
					storeManager.getStoreMap().put(key, store);
					return true;
				} else {
					store.getStringStore().add(value);
					storeManager.getStoreMap().put(key, store);
					return true;
				}
			} else {
				Store store = storeManager.getStoreMap().get(key);
				if (isNumber(value)) {
					store.getNumberStore().add(Float.parseFloat(value));
					storeManager.getStoreMap().put(key, store);
					return true;
				} else {
					store.getStringStore().add(value);
					storeManager.getStoreMap().put(key, store);
					return true;
				}
			}
		}
		return false;
	}
	
	
	//Second operation for getting all value corresponding to list of all key
	
	@Override
	public ArrayList<String> get(ArrayList<String> keys) {
		
		ArrayList<String> ans = new ArrayList<>();
		for (int i = 0; i < keys.size(); i++) {
			if (storeManager.getStoreMap().containsKey(keys.get(i))) {
				for (int j = 0; j < storeManager.getStoreMap().get(keys.get(i)).getStringStore().size(); j++) {
					String value = storeManager.getStoreMap().get(keys.get(i)).getStringStore().get(j);
					ans.add(value);
				}
				for (int j = 0; j < storeManager.getStoreMap().get(keys.get(i)).getNumberStore().size(); j++) {
					String value = storeManager.getStoreMap().get(keys.get(i)).getNumberStore().get(j) + "";
					ans.add(value);
				}
			} else
				ans.add(null);
		}
		return ans;
	}

	//  querying to get all float value which are greater than in storeMap for given target value 
	
	@Override
	public ArrayList<Float> queryGt(String key) {
		return floatKeyValuePair(key);
	}

	private ArrayList<Float> floatKeyValuePair(String key) {
		Set<String> allNumbers = storeManager.getStoreMap().keySet();
		ArrayList<Float> ans = new ArrayList<>();
		Iterator<String> keys = allNumbers.iterator();
		while (keys.hasNext()) {
			String map_key = keys.next();
			ArrayList<Float> allFloat = storeManager.getStoreMap().get(map_key).getNumberStore();
			for (int i = 0; i < allFloat.size(); i++) {
				if (allFloat.get(i) > Float.parseFloat(key)) {
					if (!ans.contains(allFloat.get(i)))
						ans.add(allFloat.get(i));
				}
			}
		}
		return ans;
	}
	
	// Querying to get all string value for given target String k that preset in given Keys

	@Override
	public ArrayList<String> query(String key) {
		return stringKeyValuePair(key);
	}

	private ArrayList<String> stringKeyValuePair(String key) {
		Set<String> allNumbers = storeManager.getStoreMap().keySet();
		ArrayList<String> ans = new ArrayList<>();
		Iterator<String> keys = allNumbers.iterator();
		while (keys.hasNext()) {
			String map_key = keys.next();
			ArrayList<String> allString = storeManager.getStoreMap().get(map_key).getStringStore();
			for (int i = 0; i < allString.size(); i++) {
				boolean checkForPattern = allString.get(i).contains(key);
				if (checkForPattern)
					ans.add(allString.get(i));
			}
		}
		return ans;
	}

	

	public boolean isNumber(String str) {
		int dotCount = 0, countDigit = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isDigit(str.charAt(i)))
				countDigit++;
			else if (str.charAt(i) == '.')
				dotCount++;
			else {
				return false;
			}
		}
		return (dotCount <= 1 && (dotCount + countDigit == str.length()));
	}

	boolean isDigit(char c) {
		return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
				|| c == '9';
	}

}
