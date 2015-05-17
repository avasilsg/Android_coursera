package com.example.notetake;

public class Note {
	
	public Note() {}
	public Note(String title, String note, String dateTime) {
		this.title = title;
		this.note = note;
		this.dateTime = dateTime;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	private String title;
	private String note;
	private String dateTime;
	
}
