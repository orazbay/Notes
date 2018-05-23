package edu.sdu.kz.baseapplication.presentation.notesList.singleNote;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import edu.sdu.kz.baseapplication.R;
import edu.sdu.kz.baseapplication.presentation.base.fragment.BaseFragment;
import edu.sdu.kz.baseapplication.data.network.models.Note;
import edu.sdu.kz.baseapplication.utils.KeyboardUtils;

public class NoteFragment extends BaseFragment implements NoteView {



    @InjectPresenter
    NotePresenter presenter;

    @BindView(R.id.editText)
    EditText editText;

    //views


    public NoteFragment() {
        setViewId(R.layout.fragment_note);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        super.onCreateView(inflater, container, savedInstanceState);
        setupEditText();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.note=(Note)getArguments().getSerializable(Note.class.getSimpleName());

        if (presenter.note.objectId!=null){
            view.setTransitionName(presenter.note.objectId);
        }else {
            editText.requestFocus();
            KeyboardUtils.show(editText);
        }

        presenter.showContent();
    }

    private void setupEditText(){
        editText.setScroller(new Scroller(getContext()));
        editText.setVerticalScrollBarEnabled(true);
        editText.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void setContentText(String text) {
        editText.setText(text);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_note,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_save:
                presenter.save(editText.getText().toString());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
