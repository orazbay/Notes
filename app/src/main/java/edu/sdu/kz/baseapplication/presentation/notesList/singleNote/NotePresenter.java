package edu.sdu.kz.baseapplication.presentation.notesList.singleNote;

import com.arellomobile.mvp.InjectViewState;

import edu.sdu.kz.baseapplication.data.network.NotesService;
import edu.sdu.kz.baseapplication.data.network.RetrofitHelper;
import edu.sdu.kz.baseapplication.data.prefs.PreferencesHelper;
import edu.sdu.kz.baseapplication.presentation.base.BasePresenter;
import edu.sdu.kz.baseapplication.presentation.example.SampleView;
import edu.sdu.kz.baseapplication.data.network.models.Note;
import edu.sdu.kz.baseapplication.utils.RxUtils;
import edu.sdu.kz.baseapplication.utils.StringUtils;


@InjectViewState
public class NotePresenter extends NoteDeletePresenter<NoteView> {
    public Note note;

    public NotePresenter() {

    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void showContent() {
        if (note.content != null) {
            getViewState().setContentText(note.content);
        }
    }

    public void save(String content) {
        if (note.content == null) {
            if (StringUtils.isNotEmpty(content)) {
                RetrofitHelper.getService(NotesService.class)
                        .createNote(PreferencesHelper.INSTANCE.getToken(), new Note(content))
                        .compose(RxUtils.applySchedulers())
                        .subscribe(
                                response -> {
                                    getViewState().showToast("Successfully created!");
                                    this.note = response;
                                },
                                this::handleBasicErrors
                        );
            }else {
                getViewState().showToast("Note is empty!");
            }
        } else {
            if (note.content.equals(content)) {
                getViewState().showToast("Nothing to update!");
            } else {
                RetrofitHelper.getService(NotesService.class)
                        .updateNote(PreferencesHelper.INSTANCE.getToken(), new Note(content), note.objectId)
                        .compose(RxUtils.applySchedulers())
                        .subscribe(
                                response -> {
                                    getViewState().showToast("Successfully updated!");
                                    this.note = response;
                                },
                                this::handleBasicErrors
                        );
            }

        }
    }

    public void deleteNote() {
        if (note.objectId != null) {
            deleteNote(
                    note.objectId,
                    deleteNoteResponse -> {
                        getViewState().hideProgress();
                        getViewState().closeFragment();
                    }
            );
        } else {
            getViewState().closeFragment();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
