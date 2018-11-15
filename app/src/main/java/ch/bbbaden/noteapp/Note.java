package ch.bbbaden.noteapp;

import java.io.Serializable;

public class Note implements Serializable {
    private String title, text;

    public Note(String title, String text){
        this.title = title;
        this.text = text;
    }

    public String getTitle(){
        return this.title;
    }

    public String getText(){
        return this.text;
    }

    public void updateTitle(String newTitle){
        title = newTitle;
    }

    public void updateText(String newText){
        text = newText;
    }
}
