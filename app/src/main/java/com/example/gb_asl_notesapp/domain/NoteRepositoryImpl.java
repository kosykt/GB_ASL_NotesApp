package com.example.gb_asl_notesapp.domain;

import com.example.gb_asl_notesapp.R;

import java.util.ArrayList;
import java.util.List;

//    Реализует и возвращает список всех заметок
public class NoteRepositoryImpl implements NoteRepository {

    @Override
    public List<Note> getNotes() {
        ArrayList<Note> result = new ArrayList<>();
//        Источник данных
//        Добавляет в ArrayList список заметок
//        Пока все оглавления и текст заметок хранятся в ресурсах string
        result.add(new Note("Заголовок", "Текст"));
        result.add(new Note("Заголовок1", "Текст1 Текст1 Текст1 Текст1"));
        result.add(new Note("Заголовок2", "Текст2 Текст2 Текст2 Текст2 Текст2 Текст2 Текст2 Текст2"));
        result.add(new Note("Заголовок3", "Текст3 Текст3 Текст3 Текст3 Текст3 Текст3 Текст3 Текст3 Текст3 Текст3 Текст3 Текст3 "));

        return result;
    }

}
