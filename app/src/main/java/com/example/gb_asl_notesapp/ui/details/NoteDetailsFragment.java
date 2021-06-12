package com.example.gb_asl_notesapp.ui.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gb_asl_notesapp.R;
import com.example.gb_asl_notesapp.domain.Note;

//отобразить текст заметки
public class NoteDetailsFragment extends Fragment {

//    ключ
    private static final String ARG_NOTE = "ARG_NOTE";

    public NoteDetailsFragment() {
    }


    //    вспомогательный метод, в который передаются фрагменты для хранения
    public static NoteDetailsFragment newInstance(Note note){
        NoteDetailsFragment fragment = new NoteDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView noteHeadline = view.findViewById(R.id.note_name);
        TextView noteText = view.findViewById(R.id.note_text);

//        получить аргументы назад
        Note note = getArguments().getParcelable(ARG_NOTE);

//        выставить значение для загаловка и тескта
        noteHeadline.setText(note.getHeadline());
        noteText.setText(note.getText());
    }
}