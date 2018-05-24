package edu.sdu.kz.baseapplication.presentation.notesList;

import android.view.View;

import edu.sdu.kz.baseapplication.presentation.notesList.singleNote.NoteFragment;

public interface OnNoteItemClickedInterface{
    public void onOpenClicked(NoteFragment noteFragment, View view, String noteId);
    public void onDeleteClicked(String noteId);
}
