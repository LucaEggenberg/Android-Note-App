package ch.bbbaden.noteapp;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class Notes {
    private static ArrayList<Note> notes = new ArrayList<>();
    private static Note selected;

    public static ArrayList<Note> getNotes(){
        return notes;
    }

    public static void addNote(String title, String text){
        notes.add(new Note(title, text));
    }

    public static void deleteNote(Note note){
        notes.remove(note);
    }

    public static void setSelected(Note note){
        selected = note;
    }

    public static Note getSelected(){
        return selected;
    }
}
