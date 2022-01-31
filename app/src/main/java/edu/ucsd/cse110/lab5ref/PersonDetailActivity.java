package edu.ucsd.cse110.lab5ref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PersonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        TextView personNotesView = findViewById(R.id.person_detail_notes);

        Intent intent = getIntent();

        String personName = intent.getStringExtra("person_name");
        String[] personNotes = intent.getStringArrayExtra("person_notes");

        setTitle(personName);
        personNotesView.setText(String.join("\n", personNotes));
    }

    public void onGoBackClicked(View view) {
        finish();
    }
}