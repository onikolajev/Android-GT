package com.sw1ch.oh.gymtracker;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.SherlockActivity;

public class MainActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
	}


	public void goToDetailed(View v){
		Intent i = new Intent(this, DetailedActivity.class);
		startActivity(i);
	}
}
