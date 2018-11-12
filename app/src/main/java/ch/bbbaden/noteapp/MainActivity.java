package ch.bbbaden.noteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private Button newNote;

    public static Note selectedNote;

    private String selected;

    public static HashMap<String, Note> mapNoteObject = new HashMap<>();
    private ArrayList<Note> modelNotes;

    private SimpleAdapter adapter;
    public HashMap<String, String> mapNotes = new HashMap<>();
    private List<HashMap<String, String>> listItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);
        modelNotes = Notes.getNotes();
        newNote = findViewById(R.id.btnNewNote);

        for (Note n : modelNotes) {
            mapNotes.put(n.getTitle(), n.getText());
            mapNoteObject.put(n.getTitle(), n);
        }

        newNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NewNote.class));
            }
        });

        this.listView();
    }

    private void listView(){
        adapter = new SimpleAdapter(MainActivity.this, listItems,
                R.layout.activity_main_listview, new String[]{"First Line", "Second Line"},
                new int[]{R.id.text1, R.id.text2});

        Iterator it = mapNotes.entrySet().iterator();
        while(it.hasNext()){
            HashMap<String,String> resultMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultMap.put("First Line", pair.getKey().toString());
            resultMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultMap);
        }
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Allahuakbar", Integer.toString(position));
            }
        });
    }
}

