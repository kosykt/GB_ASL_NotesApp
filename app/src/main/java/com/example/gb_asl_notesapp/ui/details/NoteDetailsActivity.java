package com.example.gb_asl_notesapp.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gb_asl_notesapp.R;
import com.example.gb_asl_notesapp.domain.Note;

public class NoteDetailsActivity extends AppCompatActivity {

    public static final String ARG_NOTE = "ARG_NOTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

//        при первом запуске
        if (savedInstanceState == null){

//            добавление фрагмента
            Note note = getIntent().getParcelableExtra(ARG_NOTE);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_name, NoteDetailsFragment.newInstance(note))
                    .commit();
        }
    }
}