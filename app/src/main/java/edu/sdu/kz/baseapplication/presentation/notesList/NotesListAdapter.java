package edu.sdu.kz.baseapplication.presentation.notesList;


import android.support.transition.AutoTransition;
import android.support.transition.ChangeBounds;
import android.support.transition.ChangeImageTransform;
import android.support.transition.Fade;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import edu.sdu.kz.baseapplication.R;
import edu.sdu.kz.baseapplication.data.network.models.Note;
import edu.sdu.kz.baseapplication.presentation.base.BaseRvAdapter;
import edu.sdu.kz.baseapplication.presentation.base.list.ListView;
import edu.sdu.kz.baseapplication.presentation.notesList.singleNote.NoteFragment;
import edu.sdu.kz.baseapplication.utils.FragmentUtils;


/**
 * Created by orazbay on 4/7/18.
 */

public class NotesListAdapter extends BaseRvAdapter<NotesListItemViewHolder> implements ListView<Note>,OnNoteItemClickedInterface {
    NotesListFragment notesListFragment;

    ArrayList<Note> items=new ArrayList<>();



    public NotesListAdapter(NotesListFragment notesListFragment){
        this.notesListFragment=notesListFragment;
    }



    @Override
    public NotesListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotesListItemViewHolder(
                LayoutInflater.from(
                        parent.getContext()
                )
                .inflate(R.layout.item_note,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(NotesListItemViewHolder holder, int position) {
       holder.show(items.get(position),this);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void setData(ArrayList<Note> items) {
        this.items=items;
        notifyDataSetChanged();

    }

    @Override
    public void onClicked(NoteFragment noteFragment,View view,String noteId) {
        noteFragment.setSharedElementEnterTransition(new AutoTransition());
        noteFragment.setSharedElementReturnTransition(new AutoTransition());
        notesListFragment.getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addSharedElement(view, noteId)
                .replace(R.id.fragmentContainer, noteFragment)
                .addToBackStack(NoteFragment.class.getName())
                .commit();
    }
}
