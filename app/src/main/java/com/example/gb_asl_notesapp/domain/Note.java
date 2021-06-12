package com.example.gb_asl_notesapp.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

//    базовый класс хранения записей
public class Note  implements Parcelable {

    @StringRes
    private final int name;

    @StringRes
    private final int memory;

    public Note(int name, int memory) {
        this.name = name;
        this.memory = memory;
    }

    protected Note(Parcel in) {
        name = in.readInt();
        memory = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getHeadline() {
        return name;
    }

    public int getText() {
        return memory;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(name);
        dest.writeInt(memory);
    }
}
