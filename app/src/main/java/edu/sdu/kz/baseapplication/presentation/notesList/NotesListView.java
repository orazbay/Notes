package edu.sdu.kz.baseapplication.presentation.notesList;

import java.util.ArrayList;
import edu.sdu.kz.baseapplication.data.network.models.Note;

import edu.sdu.kz.baseapplication.presentation.base.fragment.BaseFragmentView;

public interface NotesListView extends BaseFragmentView {
    public void setDataToAdapter(ArrayList<Note> notes);

}
