package com.example.notetake;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditNoteActivity extends Activity {

	private boolean isInEditMode = true;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        
		final EditText titleEditText = (EditText)findViewById(R.id.titleTextView);
		final EditText noteEditText = (EditText)findViewById(R.id.noteTextView);
        final Button saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				if(isInEditMode)
				{
					Intent resultIntent = new Intent();
					Note note = new Note(titleEditText.getText().toString(), 
										 noteEditText.getText().toString(), 
										 Calendar.getInstance().getTime().toString());
					resultIntent.putExtra("Note", note);
					setResult(RESULT_OK, resultIntent);
					finish(); 
				}
				else
				{
					isInEditMode = true;
					saveButton.setText("Save");
				}
				titleEditText.setEnabled(isInEditMode);
				noteEditText.setEnabled(isInEditMode);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
