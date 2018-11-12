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

        title.setText(Notes.getSelected().getTitle());
        text.setText(Notes.getSelected().getText());

        this.listeners();
    }

    public void listeners(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Code missing

                startActivity(new Intent(EditNote.this, MainActivity.class));
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditNote.this, MainActivity.class));
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notes.deleteNote(Notes.getSelected());
                startActivity(new Intent(EditNote.this, MainActivity.class));
            }
        });
    }

}
