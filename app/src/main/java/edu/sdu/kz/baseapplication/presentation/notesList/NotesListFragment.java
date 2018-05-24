package edu.sdu.kz.baseapplication.presentation.notesList;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import edu.sdu.kz.baseapplication.R;
import edu.sdu.kz.baseapplication.data.prefs.PreferencesHelper;
import edu.sdu.kz.baseapplication.presentation.base.refresh.RefreshFragment;
import edu.sdu.kz.baseapplication.data.network.models.Note;

import edu.sdu.kz.baseapplication.presentation.login.LoginActivity;
import edu.sdu.kz.baseapplication.presentation.notesList.singleNote.NoteFragment;
import edu.sdu.kz.baseapplication.utils.FragmentUtils;
import edu.sdu.kz.baseapplication.utils.ToastUtils;

public class NotesListFragment extends RefreshFragment implements NotesListView {
    @InjectPresenter
    NotesListPresenter notesListPresenter;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    NotesListAdapter adapter;


    public NotesListFragment() {
        setViewId(R.layout.fragment_note_list);
        Log.e("NotesListFragment: ", "cons");
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
        setupToolbar();
        setSwipeRefreshLayout(swipeRefreshLayout);
        setAdapter();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteFragment noteFragment=new NoteFragment();
                Bundle bundle=new Bundle();
                bundle.putSerializable(Note.class.getSimpleName(),new Note());
                noteFragment.setArguments(bundle);
                FragmentUtils.replace((AppCompatActivity) getActivity(),R.id.fragmentContainer,noteFragment);

            }
        });
        return view;
    }

    @Override
    public void onRefresh() {
        notesListPresenter.getNotes();
    }
    private void setAdapter() {
        adapter = new NotesListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.init(getMvpDelegate(), getId());
    }
    private void setupToolbar(){
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_log_out:
                PreferencesHelper.INSTANCE.removeToken();
                goToActivity(LoginActivity.class,true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setDataToAdapter(ArrayList<Note> items) {
        adapter.setData(items);
        hideProgress();
    }
}
