package edu.sdu.kz.baseapplication.presentation.notesList;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.sdu.kz.baseapplication.R;
import edu.sdu.kz.baseapplication.data.network.models.Note;
import edu.sdu.kz.baseapplication.presentation.notesList.singleNote.NoteFragment;
import edu.sdu.kz.baseapplication.utils.DateUtils;


/**
 * Created by orazbay on 4/7/18.
 */

public class NotesListItemViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.noteContent)
    TextView noteContentTv;
    @BindView(R.id.noteDate)
    TextView noteDateTv;
    @BindView(R.id.deleteBtn)
    View deleteButton;


    public NotesListItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void show(Note note,OnNoteItemClickedInterface onNoteItemClickedInterface){
        noteContentTv.setText(note.content);
        noteDateTv.setText(DateUtils.getReadableDate(note.geDate()));
        itemView.setOnClickListener(view -> {
            NoteFragment noteFragment=new NoteFragment();

            Bundle bundle=new Bundle();
            bundle.putSerializable(Note.class.getSimpleName(),note);

            noteFragment.setArguments(bundle);

            ViewCompat.setTransitionName(itemView,note.objectId);
            onNoteItemClickedInterface.onOpenClicked(noteFragment,itemView,note.objectId);


        });
        deleteButton.setOnClickListener(view -> {
            onNoteItemClickedInterface.onDeleteClicked(note.objectId);
        });
    }
}