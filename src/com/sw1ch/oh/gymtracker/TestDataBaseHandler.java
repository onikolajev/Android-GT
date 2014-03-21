package com.sw1ch.oh.gymtracker;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TestDataBaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "setsManager";
	private static final String TABLE_SETS = "sets";

	private static final String SETS_ID = "id";
	private static final String SETS_REPS = "reps";
	private static final String SETS_WEIGHT = "weights";

	public TestDataBaseHandler(Context context) {
		// TODO Auto-generated constructor stub
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_SETS_TABLE = "CREATE TABLE " + TABLE_SETS + "(" + SETS_ID
				+ " INTEGER PRIMARY KEY," + SETS_REPS + " DECIMAL(3),"
				+ SETS_WEIGHT + " DECIMAL(4,2)" + ")";
		db.execSQL(CREATE_SETS_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SETS);

		// Create tables again
		onCreate(db);
	}

	// Adding new Set
	public void addSet(Set set) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(SETS_REPS, set.getReps()); // Set reps
		values.put(SETS_WEIGHT, set.getWeights()); // Set weight

		// Inserting Row
		db.insert(TABLE_SETS, null, values);
		db.close(); // Closing database connection

	}

	// Getting single Set
	public Set getSet(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_SETS, new String[] { SETS_ID, SETS_REPS,
				SETS_WEIGHT }, SETS_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Set set = new Set(Integer.parseInt(cursor.getString(0)), // get id
				Integer.parseInt(cursor.getString(1)), // get reps
				Float.parseFloat(cursor.getString(2))); // get weights
		// return contact
		return set;
	}

	// Getting All Contacts
	public List<Set> getAllSets() {
		List<Set> setList = new ArrayList<Set>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_SETS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Set set = new Set();
				set.setID(Integer.parseInt(cursor.getString(0)));
				set.setReps(Integer.parseInt(cursor.getString(1)));
				set.setWeights(Float.parseFloat(cursor.getString(2)));
				// Adding contact to list
				setList.add(set);
			} while (cursor.moveToNext());
		}

		// return contact list
		return setList;
	}

	// Getting contacts Count
	public int getSetsCount() {
	}

	// Updating single contact
	public int updateSet(Set set) {
	}

	// Deleting single contact
	public void deleteContact(Set set) {
	}

}
