package com.example.notetake;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NotesActivity extends Activity {

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent editNodeIntent = new Intent(this, EditNoteActivity.class);
		startActivity(editNodeIntent);
		startActivityForResult(editNodeIntent, 1);
//		notesList.add(new Note("Title", "Meghan Trainor", "12/12/15"));
//		populateList();
		return true;
	}

	private List<Note> notesList = new ArrayList<Note>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		populateList();
	}

	private void populateList() {
		setContentView(R.layout.activity_list_notes_activity);
		
		ListView notes = (ListView)findViewById(R.id.notesListView);
		
		List<String> values = new ArrayList<String>();
		
		for(Note note: notesList) {
			values.add(note.getTitle());
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, android.R.id.text1, values);
		
		notes.setAdapter(adapter);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (null != data) {
			Serializable extract = (Serializable) data;
			if (null != extract) {
				Note note = (Note)extract;
				notesList.add(note);
				populateList();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_notes_activity, menu);
		return true;
	}

}
