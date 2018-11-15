package ch.bbbaden.noteapp;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Notes {

    private DBHandler db = new DBHandler(MainActivity.get());
    private static Notes instance;
    private Note selected;

    private Notes(){
    }

    public static Notes getInstance(){
        if (instance == null) instance = new Notes();
        return instance;
    }

    public List<Note> getNotes(){
        return db.getAllNotes();
    }

    public void deleteNote(Note note){
        db.deleteNote(note);
    }

    public void select(Note note){
        selected = note;
    }

    public Note selectedNote(){
        return selected;
    }

    public void addNote(Note note){
        db.addNote(note);
    }
}
