package edu.ucsd.cse110.lab5_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Transaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import edu.ucsd.cse110.lab5_room.model.IPerson;
import edu.ucsd.cse110.lab5_room.model.NotesViewAdapter;
import edu.ucsd.cse110.lab5_room.model.db.AppDatabase;
import edu.ucsd.cse110.lab5_room.model.db.Note;

public class PersonDetailActivity extends AppCompatActivity {
    private AppDatabase db;
    private IPerson person;

    private RecyclerView notesRecyclerView;
    private RecyclerView.LayoutManager notesLayoutManager;
    private NotesViewAdapter notesViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        Intent intent = getIntent();
        int personId = intent.getIntExtra("person_id", 0);

        db = AppDatabase.singleton(this);
        person = db.personWithNotesDao().get(personId);
        List<Note> notes = db.notesDAO().getForPerson(personId);

        setTitle(person.getName());

        notesRecyclerView = findViewById(R.id.notes_view);
        notesLayoutManager = new LinearLayoutManager(this);
        notesRecyclerView.setLayoutManager(notesLayoutManager);

        notesViewAdapter = new NotesViewAdapter(notes, (note) -> {
            db.notesDAO().delete(note);
        });
        notesRecyclerView.setAdapter(notesViewAdapter);

    }

    public void onAddNoteCLicked(View view)
    {
        int newNoteId = db.notesDAO().count() + 1;
        int personId = person.getID();
        TextView newNoteTextView = findViewById(R.id.new_note_textview);

        String newNoteText = newNoteTextView.getText().toString();

        Note newNote = new Note(newNoteId, personId, newNoteText);
        db.notesDAO().insert(newNote);

        notesViewAdapter.addNote(newNote);
    }

    public void onGoBackClicked(View view) {
        finish();
    }
}