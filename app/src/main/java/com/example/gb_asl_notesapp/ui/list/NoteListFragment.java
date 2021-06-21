package com.example.gb_asl_notesapp.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gb_asl_notesapp.R;
import com.example.gb_asl_notesapp.domain.Note;
import com.example.gb_asl_notesapp.domain.NoteRepository;
import com.example.gb_asl_notesapp.domain.NoteRepositoryImpl;

import java.util.List;

//Отображает фрагменты на экране
public class NoteListFragment extends Fragment {

//    вспомогательный интерфейс для определения нажатия
    public interface OnNoteClicked{
        void onNoteClicked(Note note);
    }

    private OnNoteClicked onNoteClicked;

    private NoteRepository noteRepository;

//    работает совместно с местным интерфесом
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

//        проверка на наследование интерфейса
        if (context instanceof OnNoteClicked){
            onNoteClicked = (OnNoteClicked) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        если активити оцепилась
        onNoteClicked = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        noteRepository = new NoteRepositoryImpl();
    }

    //    предоставляет вью на экран
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

//    при срабатывании onCreateView в onViewCreated передасться View, которая была создана "return inflater'ом"
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//      определить вью фрагмента
        LinearLayout notesList = view.findViewById(R.id.note_list_container);

        List<Note> notes = noteRepository.getNotes();

//        заполнить список заметок
        for (Note note: notes){
//            найти определить заголовок заметки
            View itemView = LayoutInflater.from(requireContext()).inflate(R.layout.item_headline_note, notesList, false);

//            определить нажатие
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onNoteClicked != null){
                        onNoteClicked.onNoteClicked(note);
                    }
                }
            });

            TextView noteHeadLine = itemView.findViewById(R.id.note_name);
            noteHeadLine.setText(note.getName());

            notesList.addView(itemView);
        }
    }
}
