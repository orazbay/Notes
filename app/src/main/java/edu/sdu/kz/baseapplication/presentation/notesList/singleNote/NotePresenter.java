package edu.sdu.kz.baseapplication.presentation.notesList.singleNote;

import com.arellomobile.mvp.InjectViewState;

import edu.sdu.kz.baseapplication.data.network.NotesService;
import edu.sdu.kz.baseapplication.data.network.RetrofitHelper;
import edu.sdu.kz.baseapplication.data.prefs.PreferencesHelper;
import edu.sdu.kz.baseapplication.presentation.base.BasePresenter;
import edu.sdu.kz.baseapplication.presentation.example.SampleView;
import edu.sdu.kz.baseapplication.data.network.models.Note;
import edu.sdu.kz.baseapplication.utils.RxUtils;


@InjectViewState
public class NotePresenter extends BasePresenter<NoteView> {
    public Note note;
    public NotePresenter(){

    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }
    public void showContent(){
        if (note.content!=null){
            getViewState().setContentText(note.content);
        }
    }
    public void save(String content){
        if (note.content==null){
            RetrofitHelper.getService(NotesService.class)
                    .createNote(PreferencesHelper.INSTANCE.getToken(),new Note(content))
                    .compose(RxUtils.applySchedulers())
                    .subscribe(
                            response->{
                                getViewState().showToast("Successfully created!");
                                this.note=response;
                            },
                            this::handleBasicErrors
                    );
        }else {
            RetrofitHelper.getService(NotesService.class)
                    .updateNote(PreferencesHelper.INSTANCE.getToken(),new Note(content),note.objectId)
                    .compose(RxUtils.applySchedulers())
                    .subscribe(
                            response->{
                                getViewState().showToast("Successfully updated!");
                                this.note=response;
                            },
                            this::handleBasicErrors
                    );
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
