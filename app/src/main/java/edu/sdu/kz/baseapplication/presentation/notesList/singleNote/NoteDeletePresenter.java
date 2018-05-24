package edu.sdu.kz.baseapplication.presentation.notesList.singleNote;



import edu.sdu.kz.baseapplication.data.network.NotesService;
import edu.sdu.kz.baseapplication.data.network.RetrofitHelper;
import edu.sdu.kz.baseapplication.data.network.models.DeleteNoteResponse;
import edu.sdu.kz.baseapplication.data.network.models.Note;
import edu.sdu.kz.baseapplication.data.prefs.PreferencesHelper;
import edu.sdu.kz.baseapplication.presentation.base.BasePresenter;
import edu.sdu.kz.baseapplication.presentation.base.fragment.BaseFragmentView;
import edu.sdu.kz.baseapplication.utils.RxUtils;
import io.reactivex.functions.Consumer;


public class NoteDeletePresenter<View extends BaseFragmentView> extends BasePresenter<View> {

    public void deleteNote(String objectId, Consumer<DeleteNoteResponse> consumerOnSuccesDeleted){
        getViewState().showProgress();
        RetrofitHelper.getService(NotesService.class)
                .deleteNote(PreferencesHelper.INSTANCE.getToken(),objectId)
                .compose(RxUtils.applySchedulers())
                .subscribe(
                        consumerOnSuccesDeleted,
                        error->{
                            getViewState().hideProgress();
                            handleBasicErrors(error);
                        }
                );

    }
}
