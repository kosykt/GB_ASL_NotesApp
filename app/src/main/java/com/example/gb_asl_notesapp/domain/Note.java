package com.example.gb_asl_notesapp.domain;

import androidx.annotation.StringRes;

//    базовый класс хранения записей
public class Note {

    @StringRes
    private final int name;

    @StringRes
    private final int memory;

    public Note(int name, int memory) {
        this.name = name;
        this.memory = memory;
    }

    public int getHeadline() {
        return name;
    }

    public int getMemory() {
        return memory;
    }
}
