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

class Exercise {
	private String name;
	private ArrayList setArray;

	Exercise() {
		this.name = "Exercise name";
	}

	void addSet(int reps, float weights) {
		Set mSets = new Set(reps, weights);
		setArray.add(mSets);
	}

	int getSetsCount() {
		return setArray.size();
	}

	void removeLastSet() {
		setArray.remove(setArray.size() - 1);
	}

}

class Set {
	private int id;
	private int reps;
	private float weights;

	Set(int id, int reps, float weights) {
		this.id = id;
		this.reps = reps;
		this.weights = weights;
	}

	Set(int reps, float weights) {
		this.reps = reps;
		this.weights = weights;
	}

	Set() {
		this.reps = 0;
		this.weights = (float) 0.0;
	}

	int getReps() {
		return reps;
	}

	void setReps(int x) {
		this.reps = x;
	}

	float getWeights() {
		return this.weights;
	}

	void setWeight(float x) {
		this.weights = x;
	}
}