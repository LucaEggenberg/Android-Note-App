package ch.bbbaden.noteapp;

public class Note {
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
}
