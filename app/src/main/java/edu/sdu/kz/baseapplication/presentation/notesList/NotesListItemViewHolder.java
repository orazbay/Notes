package edu.sdu.kz.baseapplication.presentation.notesList;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.sdu.kz.baseapplication.R;
import edu.sdu.kz.baseapplication.data.network.models.Note;
import edu.sdu.kz.baseapplication.presentation.notesList.singleNote.NoteFragment;
import edu.sdu.kz.baseapplication.utils.FragmentUtils;


/**
 * Created by orazbay on 4/7/18.
 */

public class NotesListItemViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.noteContent)
    TextView noteContentTv;


    public NotesListItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void show(Note note,OnNoteItemClickedInterface onNoteItemClickedInterface){
        noteContentTv.setText(note.content);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteFragment noteFragment=new NoteFragment();

                Bundle bundle=new Bundle();
                bundle.putSerializable(Note.class.getSimpleName(),note);

                noteFragment.setArguments(bundle);

                ViewCompat.setTransitionName(itemView,note.objectId);
                onNoteItemClickedInterface.onClicked(noteFragment,itemView,note.objectId);


            }
        });
    }
}