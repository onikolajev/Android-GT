package com.sw1ch.oh.gymtracker;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;

public class DetailedActivity extends SherlockActivity {
	private TestDataBaseHandler db;
	private EditText repsEdit;
	private EditText weightsEdit;
	private TextView statusView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detailed);
		db = new TestDataBaseHandler(this);
		repsEdit = (EditText) findViewById(R.id.repsEdit);
		weightsEdit = (EditText) findViewById(R.id.weightsEdit);
		statusView = (TextView) findViewById(R.id.statusView);
	}

	public void saveData(View v) {

		int reps = Integer.parseInt(repsEdit.getText().toString());
		float weights = Float.parseFloat(weightsEdit.getText().toString());
		db.addSet(new Set(reps, weights));
		statusView.setVisibility(TextView.VISIBLE);
	}

	public void runSQL(View v) {
		/**
		 * CRUD Operations
		 * */

		Log.d("Reading: ", "Reading all contacts..");
		List<Set> sets = db.getAllSets();

		for (Set cn : sets) {
			String log = "Id: " + cn.getID() + " ,Name: " + cn.getReps()
					+ " ,Phone: " + cn.getWeights();
			// Writing Contacts to log
			Log.d("Sw1cH", log);
		}
	}
	
	public void goToStatistics(View v){
		Intent i = new Intent (this, SetStatsActivity.class);
		startActivity(i);
	}
}
