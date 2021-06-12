package com.example.gb_asl_notesapp.domain;

import androidx.annotation.StringRes;

public class Note {
//    базовый класс хранения записей

    @StringRes
    private final int name;

    @StringRes
    private final int memory;

    public Note(int name, int memory) {
        this.name = name;
        this.memory = memory;
    }

    public int getName() {
        return name;
    }

    public int getMemory() {
        return memory;
    }
}
