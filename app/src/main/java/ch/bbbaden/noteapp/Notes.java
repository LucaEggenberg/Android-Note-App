package ch.bbbaden.noteapp;

import java.util.ArrayList;

public class Notes {
    private static ArrayList<Note> notes = new ArrayList<>();

    public static ArrayList<Note> getNotes(){
        return notes;
    }

    public static void addNote(String title, String text){
        notes.add(new Note(title, text));
    }

    public static void deleteNote(Note note){
        notes.remove(note);
    }
}
