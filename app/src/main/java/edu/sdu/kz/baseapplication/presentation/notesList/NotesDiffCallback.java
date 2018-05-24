package edu.sdu.kz.baseapplication.presentation.notesList;

import edu.sdu.kz.baseapplication.data.network.models.Note;
import android.support.v7.util.DiffUtil;


import java.util.ArrayList;

public class NotesDiffCallback extends DiffUtil.Callback{
    ArrayList<Note> oldNotes;
    ArrayList<Note> newNotes;

    public NotesDiffCallback(ArrayList<Note> oldNotes,ArrayList<Note> newNotes ){
        this.oldNotes=oldNotes;
        this.newNotes=newNotes;

    }

    @Override
    public int getOldListSize() {
        return oldNotes.size();
    }

    @Override
    public int getNewListSize() {
        return newNotes.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldNotes.get(oldItemPosition).objectId.equals(newNotes.get(newItemPosition).objectId);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Note oldNote=oldNotes.get(oldItemPosition);
        Note newNote=newNotes.get(newItemPosition);

        return oldNote.content.equals(newNote.content)&&oldNote.geDate()==newNote.geDate();
    }
}
