package com.example.gb_asl_notesapp.domain;

import com.example.gb_asl_notesapp.R;

import java.util.ArrayList;
import java.util.List;

public class NoteRepositoryImpl implements NoteRepository {

    //    Реализует и возвращает список всех заметок
    @Override
    public List<Note> getNotes() {
        ArrayList<Note> result = new ArrayList<>();
//        Источник данных
//        Добавляет в ArrayList список заметок
//        Пока все оглавления и текст заметок хранятся в ресурсах string
        result.add(new Note(R.string.msc, R.string.msc1));
        result.add(new Note(R.string.spb, R.string.spb1));
        result.add(new Note(R.string.ebrg1, R.string.ebrg1));
        result.add(new Note(R.string.nsk, R.string.nsk1));
        result.add(new Note(R.string.sam, R.string.sam1));

        return result;
    }
}