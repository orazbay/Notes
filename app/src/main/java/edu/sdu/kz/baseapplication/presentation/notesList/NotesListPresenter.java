package edu.sdu.kz.baseapplication.presentation.notesList;


import com.arellomobile.mvp.InjectViewState;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import edu.sdu.kz.baseapplication.data.network.LoginService;
import edu.sdu.kz.baseapplication.data.network.NotesService;
import edu.sdu.kz.baseapplication.data.network.RetrofitHelper;


import edu.sdu.kz.baseapplication.data.network.models.Note;
import edu.sdu.kz.baseapplication.data.prefs.PreferencesHelper;
import edu.sdu.kz.baseapplication.presentation.base.BasePresenter;
import edu.sdu.kz.baseapplication.presentation.login.LoginActivity;
import edu.sdu.kz.baseapplication.presentation.notesList.singleNote.NoteDeletePresenter;
import edu.sdu.kz.baseapplication.utils.RxUtils;
import edu.sdu.kz.baseapplication.utils.WhereQueryGenerator;


/**
 * Created by orazbay on 4/7/18.
 */

@InjectViewState
public class NotesListPresenter extends NoteDeletePresenter<NotesListView> {
    private ArrayList<Integer>  logoutErrors=new ArrayList<>(Arrays.asList(2002,3007,3023));
    public NotesListPresenter() {
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

    }

    public void getNotes() {
        RetrofitHelper.getService(NotesService.class)
                .getNotes(PreferencesHelper.INSTANCE.getToken(), WhereQueryGenerator.generate(PreferencesHelper.INSTANCE.getId()), "created%20desc%2Cupdated%20desc")
                .compose(RxUtils.applySchedulers())
                .subscribe(
                        response -> {
                            Comparator<Note> noteComparator = (note, t1) -> note.geDate().compareTo(t1.geDate());

                            Collections.sort(response, noteComparator);
                            Collections.reverse(response);
                            getViewState().setDataToAdapter(response);
                        },
                        this::handleBasicErrors
                );
    }

    public void deleteNote(String object) {
        deleteNote(
                object,
                deleteNoteResponse -> {
                    getNotes();

                });

    }

    public void logout() {
        getViewState().showProgress();
        RetrofitHelper.getService(LoginService.class)
                .signOut(PreferencesHelper.INSTANCE.getToken())
                .compose(RxUtils.applySchedulers())
                .subscribe(r -> {
                            getViewState().hideProgress();
                            PreferencesHelper.INSTANCE.removeToken();
                            getViewState().goToActivity(LoginActivity.class, true);
                        }
                        , e -> {
                            getViewState().hideProgress();
                            if ( logoutErrors.contains(getErrorCode(e))){
                                handleBasicErrors(e);
                            }else {
                                PreferencesHelper.INSTANCE.removeToken();
                                getViewState().goToActivity(LoginActivity.class, true);
                            }


                        });

    }

}
