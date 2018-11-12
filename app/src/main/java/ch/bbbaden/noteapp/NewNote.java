package ch.bbbaden.noteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewNote extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button btnAdd, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        editText1 = findViewById(R.id.editTextNote);
        editText2 = findViewById(R.id.editTextDescr);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notes.addNote(editText1.getText().toString(), editText2.getText().toString());
                startActivity(new Intent(NewNote.this, MainActivity.class));
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewNote.this, MainActivity.class));
            }
        });
    }
}
