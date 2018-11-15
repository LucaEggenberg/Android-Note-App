package ch.bbbaden.noteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collections;

public class EditNote extends AppCompatActivity {

    private Notes notes = Notes.getInstance();
    private Button btnSave, btnCancel, btnDel;
    private EditText title, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        btnDel = findViewById(R.id.btnDel);

        title = findViewById(R.id.editTextNote);
        text = findViewById(R.id.editTextDescr);

        title.setText(notes.selectedNote().getTitle());
        text.setText(notes.selectedNote().getText());

        this.listeners();
    }

    public void listeners(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notes.deleteNote(notes.selectedNote());
                notes.addNote(new Note(title.getText().toString(), text.getText().toString()));
                finish();
                //startActivity(new Intent(EditNote.this, MainActivity.class));
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                //startActivity(new Intent(EditNote.this, MainActivity.class));
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notes.deleteNote(notes.selectedNote());
                finish();
                //startActivity(new Intent(EditNote.this, MainActivity.class));
            }
        });
    }

}
