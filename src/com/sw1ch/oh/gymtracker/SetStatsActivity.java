package com.sw1ch.oh.gymtracker;

import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockActivity;
import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;

public class SetStatsActivity extends SherlockActivity {

	TestDataBaseHandler db;
	List<Set> sets;
	GraphViewData[] WeightData;
	GraphViewData[] RepsData;
	String[] horizontalLabels;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_stats);
		Display display = getWindowManager().getDefaultDisplay();

		db = new TestDataBaseHandler(this);
		sets = db.getAllSets();
		WeightData = new GraphViewData[sets.size()];
		RepsData = new GraphViewData[sets.size()];
		horizontalLabels =new String[sets.size()];
		
		// Weight data
		int i = 0;
		for (Set s : sets) {
			WeightData[i] = new GraphViewData(i, s.getWeights());
			horizontalLabels[i] =""+ i;
			i++;
		}

		// Reps data
		i = 0;
		for (Set s : sets) {
			RepsData[i] = new GraphViewData(i, s.getReps());
			i++;
		}

		// Data arrangement
		GraphViewSeries wGraphSeries = new GraphViewSeries(WeightData);
		GraphView weightGraph = new BarGraphView(this, "Weight");
		weightGraph.addSeries(wGraphSeries);

		GraphViewSeries rGraphSeries = new GraphViewSeries(RepsData);
		GraphView repGraph = new BarGraphView(this, "Reps");
		repGraph.addSeries(rGraphSeries);

		// Style for weightGraph
		weightGraph.getGraphViewStyle().setTextSize(12);
		weightGraph.setHorizontalLabels(horizontalLabels);
		weightGraph.setBackgroundColor(Color.BLACK);
		weightGraph.getGraphViewStyle().setGridColor(Color.BLACK);
		weightGraph.getGraphViewStyle().setHorizontalLabelsColor(Color.WHITE);
		weightGraph.getGraphViewStyle().setVerticalLabelsColor(Color.WHITE);

		// Style for repGraph
		repGraph.getGraphViewStyle().setTextSize(12);
		repGraph.setHorizontalLabels(horizontalLabels);
		repGraph.setBackgroundColor(Color.BLACK);
		repGraph.getGraphViewStyle().setGridColor(Color.BLACK);
		repGraph.getGraphViewStyle().setHorizontalLabelsColor(Color.WHITE);
		repGraph.getGraphViewStyle().setVerticalLabelsColor(Color.WHITE);

		LinearLayout l1 = (LinearLayout) findViewById(R.id.wGraph);
		l1.getLayoutParams().height = (display.getHeight() / 2);
		l1.addView(weightGraph);
		
		LinearLayout l2 = (LinearLayout) findViewById(R.id.rGraph);
		l2.getLayoutParams().height = (display.getHeight() / 2);
		l2.addView(repGraph);
	}

}
