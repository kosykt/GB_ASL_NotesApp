package ru.geekbrains.notes.observer;

// Наблюдатель, вызывается updateNote, когда надо отправить событие по изменению заметки
public interface ObserverNote {
    void updateNote(int noteID);
}
