package edu.sdu.kz.baseapplication.presentation.notesList;


import com.arellomobile.mvp.InjectViewState;


import edu.sdu.kz.baseapplication.data.network.NotesService;
import edu.sdu.kz.baseapplication.data.network.RetrofitHelper;


import edu.sdu.kz.baseapplication.data.prefs.PreferencesHelper;
import edu.sdu.kz.baseapplication.presentation.base.BasePresenter;
import edu.sdu.kz.baseapplication.utils.RxUtils;
import edu.sdu.kz.baseapplication.utils.WhereQueryGenerator;


/**
 * Created by orazbay on 4/7/18.
 */

@InjectViewState
public class NotesListPresenter extends BasePresenter<NotesListView> {
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
                            getViewState().setDataToAdapter(response);
                        },
                        this::handleBasicErrors
                );
//        getViewState().setDataToAdapter(new ArrayList<Note>(Arrays.asList(
//                new Note("today is a good day eveything is fine but fdsfds today is a good day eveything is fine but fdsfds today is a good day eveything is fine but fdsfds today is a good day eveything is fine but fdsfds today is a good day eveything is fine but fdsfds today is a good day eveything is fine but fdsfds today is a good day eveything is fine but fdsfds today is a good day eveything is fine but fdsfds"),
//                new Note("today is a good day eveything is fine but fdsfds"),
//                new Note("today is a good day eveything is fine but fdsfds"),
//                new Note("today is a good day eveything is fine but fdsfds")
//                ))
//        );
    }
}
