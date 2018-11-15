package ch.bbbaden.noteapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private Notes notes;
    public MainActivity(){
        super();

    }
    private static Context context;
    public static Context get() {
        return context;
    }

    private SimpleAdapter adapter;
    private List<HashMap<String, String>> listItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        notes = Notes.getInstance();
        lv = (ListView) findViewById(R.id.listView);
        newNote = findViewById(R.id.btnNewNote);

        newNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTo(new Intent(MainActivity.this, NewNote.class));
            }
        });

        this.listView();
    }

    @Override
    protected void onResume(){
        super.onResume();
        listView();
    }

    private void listView(){
        adapter = new SimpleAdapter(MainActivity.this, listItems,
                R.layout.activity_main_listview, new String[]{"First Line", "Second Line"},
                new int[]{R.id.text1, R.id.text2});

        listItems.clear();

        List<Note> tempNotes = new ArrayList<Note>();
        tempNotes = notes.getNotes();

        for(Note n : tempNotes){
            HashMap<String, String> resultMap = new HashMap<>();
            resultMap.put("First Line", n.getTitle());
            resultMap.put("Second Line", n.getText());
            listItems.add(resultMap);
        }
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(Note n : notes.getNotes()){
                    if(n.getTitle().equals(listItems.get(position).get("First Line"))) {
                        notes.select(n);
                    }
                }
                switchTo(new Intent(MainActivity.this, EditNote.class));
            }
        });
    }

    private void switchTo(Intent intent){
        startActivity(intent);
    }

    public Context getContext(){
        return getApplicationContext();
    }
}

