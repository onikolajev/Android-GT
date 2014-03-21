package com.sw1ch.oh.gymtracker;

public class Set {
	private int id;
	private int reps;
	private float weights;

	Set() {
		this.reps = 0;
		this.weights = (float) 0.0;
	}

	Set(int id, int reps, float weights){
		this.id = id;
		this.reps = reps;
		this.weights = weights;
	}
	
	int getID(){
		return this.id;
	}
	
	void setID(int x){
		this.id =x;
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

	void setWeights(float x) {
		this.weights = x;
	}
}