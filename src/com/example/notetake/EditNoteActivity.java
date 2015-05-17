package com.example.notetake;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
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
        
        final Button saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText titleEditText = (EditText)findViewById(R.id.titleTextView);
				EditText noteEditText = (EditText)findViewById(R.id.noteTextView);
				
				if(isInEditMode)
				{
					isInEditMode = false;
					saveButton.setText("Edit");
					TextView dateTextView = (TextView)findViewById(R.id.dateTextView);
					DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					String date = dateFormat.format(Calendar.getInstance().getTime());
					dateTextView.setText(date);
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
