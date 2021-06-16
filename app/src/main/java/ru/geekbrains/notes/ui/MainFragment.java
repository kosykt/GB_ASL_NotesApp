package ru.geekbrains.notes.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import ru.geekbrains.notes.R;
import ru.geekbrains.notes.ui.item.EditNoteFragment;

public class MainFragment extends Fragment implements View.OnClickListener {

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    // вызывается после создания макета фрагмента, здесь мы проинициализируем список
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.v("Debug1", "MainFragment onViewCreated");
        Button buttonAddNote = view.findViewById(R.id.buttonAddNote);
        buttonAddNote.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.v("Debug1", "MainFragment onClick");
        if (v.getId() == R.id.buttonAddNote) {
            EditNoteFragment editNoteFragment = EditNoteFragment.newInstance(-1);

            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.frame_container_main, editNoteFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        }
    }
}