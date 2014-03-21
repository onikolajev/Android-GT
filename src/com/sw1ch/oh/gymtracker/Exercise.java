package com.sw1ch.oh.gymtracker;

import java.util.ArrayList;

public class Exercise {
	private String name;
	private ArrayList setArray;

	Exercise() {
		this.name = "Exercise name";
	}

	void addSet(int reps, float weights) {
		Set mSets = new Set();
		setArray.add(mSets);
	}

	int getSetsCount() {
		return setArray.size();
	}

	void removeLastSet() {
		setArray.remove(setArray.size() - 1);
	}

}
