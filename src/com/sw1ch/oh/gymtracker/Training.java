package com.sw1ch.oh.gymtracker;

import java.util.ArrayList;

// Set class -> Exercise class -> Training class

public class Training {
	private String trName;
	private ArrayList exArray;

	Training() {
		this.trName = "Training name";
		exArray = new ArrayList();
		this.addExerc();
	}

	void addExerc() {
		Exercise mExerc = new Exercise();
		exArray.add(mExerc);
	}

	int getSetsCount() {
		return exArray.size();
	}

	void removeLastSet() {
		exArray.remove(exArray.size() - 1);
	}
}


