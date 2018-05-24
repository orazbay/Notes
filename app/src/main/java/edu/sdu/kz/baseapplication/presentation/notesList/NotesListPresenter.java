package edu.sdu.kz.baseapplication.presentation.notesList;


import com.arellomobile.mvp.InjectViewState;


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import edu.sdu.kz.baseapplication.data.network.NotesService;
import edu.sdu.kz.baseapplication.data.network.RetrofitHelper;


import edu.sdu.kz.baseapplication.data.network.models.Note;
import edu.sdu.kz.baseapplication.data.prefs.PreferencesHelper;
import edu.sdu.kz.baseapplication.presentation.base.BasePresenter;
import edu.sdu.kz.baseapplication.presentation.notesList.singleNote.NoteDeletePresenter;
import edu.sdu.kz.baseapplication.utils.RxUtils;
import edu.sdu.kz.baseapplication.utils.WhereQueryGenerator;


/**
 * Created by orazbay on 4/7/18.
 */

@InjectViewState
public class NotesListPresenter extends NoteDeletePresenter<NotesListView> {
    public NotesListPresenter() {
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

    }

    public void getNotes() {
        RetrofitHelper.getService(NotesService.class)
                .getNotes(PreferencesHelper.INSTANCE.getToken(), WhereQueryGenerator.generate(PreferencesHelper.INSTANCE.getId()),"created%20desc%2Cupdated%20desc")
                .compose(RxUtils.applySchedulers())
                .subscribe(
                        response -> {
                            Comparator<Note> noteComparator= (note, t1) -> note.geDate().compareTo(t1.geDate());

                            Collections.sort(response,noteComparator);
                            Collections.reverse(response);
                            getViewState().setDataToAdapter(response);
                        },
                        this::handleBasicErrors
                );
    }
    public void deleteNote(String object){
        deleteNote(
                object,
                deleteNoteResponse -> {
                    getNotes();

                });

    }

}
