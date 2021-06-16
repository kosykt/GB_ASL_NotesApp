package ru.geekbrains.notes.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

import ru.geekbrains.notes.GlobalVariables;
import ru.geekbrains.notes.R;
import ru.geekbrains.notes.note.Note;
import ru.geekbrains.notes.observer.ObserverNote;
import ru.geekbrains.notes.observer.Publisher;
import ru.geekbrains.notes.observer.PublisherHolder;

import static ru.geekbrains.notes.Constant.MILISECOND;


public class ListNotesFragment extends Fragment implements ObserverNote {

    private View viewFragment;
    private Publisher publisher;

    @Override
    public void updateNote(int noteID) {
        Log.v("Debug1", "ListNotesFragment updateNote noteID=" + noteID);
        fillList(viewFragment);
    }

    public interface OnNoteClicked {
        void onNoteClickedList(int noteID);
    }

    private OnNoteClicked NoteClicked;

    public interface onDateClicked {
        void onDateClickedList(int noteID);
    }

    private ListNotesFragment.onDateClicked onDateClicked;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.v("Debug1", "ListNotesFragment onAttach");

        if (context instanceof OnNoteClicked) {
            NoteClicked = (OnNoteClicked) context;
        }

        if (context instanceof ListNotesFragment.onDateClicked) {
            onDateClicked = (ListNotesFragment.onDateClicked) context;
        }

        if (context instanceof PublisherHolder) {
            publisher = ((PublisherHolder) context).getPublisher();
            publisher.subscribe(this);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v("Debug1", "ListNotesFragment onDetach");
        NoteClicked = null;
        onDateClicked = null;
        if (publisher != null) {
            publisher.unsubscribe(this);
        }
    }

    // При создании фрагмента укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("Debug1", "ListNotesFragment onCreateView");
        return inflater.inflate(R.layout.fragment_list_notes, container, false);
    }

    // вызывается после создания макета фрагмента, здесь мы проинициализируем список
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.v("Debug1", "ListNotesFragment onViewCreated");
        viewFragment = view;
    }

    protected void fillList(View view) {
        Log.v("Debug1", "ListNotesFragment fillList");
        LinearLayout linearLayoutNotesList = view.findViewById(R.id.ListNotesFragment);
        LinearLayout linearLayoutIntoScrollView = view.findViewById(R.id.linearLayoutIntoScrollViewIntoFragmentListNotes);

        linearLayoutIntoScrollView.removeAllViews();

        if (getActivity() != null && getActivity().getApplication() != null) {
            List<Note> notes = ((GlobalVariables) getActivity().getApplication()).getNotes();

            for (Note note : notes) {
                View viewTop = LayoutInflater.from(requireContext()).inflate(R.layout.view_item_note_top_textview, linearLayoutNotesList, false);
                View viewBottom = LayoutInflater.from(requireContext()).inflate(R.layout.view_item_note_bottom_textview, linearLayoutNotesList, false);

                viewBottom.setOnClickListener(v -> {
                    if (NoteClicked != null) {
                        NoteClicked.onNoteClickedList(note.getID());
                    }
                });

                viewTop.setOnClickListener(v -> {
                    if (onDateClicked != null) {
                        onDateClicked.onDateClickedList(note.getID());
                    }
                });

                TextView textViewTop = viewTop.findViewById(R.id.textViewTop);
                long date = note.getDate() * MILISECOND;

                DateFormat f = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.getDefault());
                String dateStr = f.format(date);

                textViewTop.setText(dateStr);
                textViewTop.setTag(note.getID());

                Log.v("Debug1", "ListNotesFragment fillList textViewTop.getTag()=" + textViewTop.getTag());

                TextView textViewBottom = viewBottom.findViewById(R.id.textViewBottom);
                textViewBottom.setText(note.getHeader());

                linearLayoutIntoScrollView.addView(viewTop);
                linearLayoutIntoScrollView.addView(viewBottom);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("Debug1", "ListNotesFragment onStart");
        fillList(viewFragment);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("Debug1", "ListNotesFragment onStop");
    }

    public void onResume() {
        super.onResume();
        Log.v("Debug1", "ListNotesFragment onResume");
    }

    public void onPause() {
        super.onPause();
        Log.v("Debug1", "ListNotesFragment onPause");
    }

}
