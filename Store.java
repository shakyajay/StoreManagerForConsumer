package mitter.map;

import java.util.ArrayList;

public class Store {

	private ArrayList<String> stringStore;
	private ArrayList<Float> numberStore;

	public ArrayList<String> getStringStore() {
		return stringStore;
	}

	public ArrayList<Float> getNumberStore() {
		return numberStore;
	}

	 Store() {
		this.stringStore = new ArrayList<String>();
		this.numberStore = new ArrayList<Float>();
	}
}

