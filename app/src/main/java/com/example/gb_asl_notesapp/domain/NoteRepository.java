package com.example.gb_asl_notesapp.domain;

import java.util.List;

public interface NoteRepository {
//  Возвращает список всех заметок
    List<Note> getNotes();
}
