package com.example.gb_asl_notesapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gb_asl_notesapp.R;
import com.example.gb_asl_notesapp.domain.Note;
import com.example.gb_asl_notesapp.ui.details.NoteDetailsActivity;
import com.example.gb_asl_notesapp.ui.list.NoteListFragment;

public class MainActivity extends AppCompatActivity implements NoteListFragment.OnNoteClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onNoteClicked(Note note) {
        Intent intent = new Intent(this, NoteDetailsActivity.class);
        intent.putExtra(NoteDetailsActivity.ARG_NOTE, note);
        startActivity(intent);
    }
}