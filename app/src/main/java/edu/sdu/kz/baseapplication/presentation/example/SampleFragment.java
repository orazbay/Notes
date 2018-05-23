package edu.sdu.kz.baseapplication.presentation.example;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import edu.sdu.kz.baseapplication.R;
import edu.sdu.kz.baseapplication.presentation.base.refresh.RefreshFragment;
import edu.sdu.kz.baseapplication.utils.ToastUtils;

public class SampleFragment extends RefreshFragment implements SampleView {



    @InjectPresenter
    SamplePresenter samplePresenter;

    //views
    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.text2)
    TextView text2;
    @BindView(R.id.text3)
    TextView text3;
    @BindView(R.id.text4)
    TextView text4;
    @BindView(R.id.text5)
    TextView text5;

    public SampleFragment() {
        setViewId(R.layout.fragment_sample);
        Log.e("NotesListFragment: ", "cons");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }


    @Override
    public void setText1(String text) {
        text1.setText(text);
    }

    @Override
    public void setText2(String text) {
        text2.setText(text);
    }

    @Override
    public void setText3(String text) {
        text3.setText(text);
    }

    @Override
    public void setText4(String text) {
        text4.setText(text);
    }

    @Override
    public void setText5(String text) {
        text5.setText(text);
    }

    @Override
    public void onRefresh() {
        ToastUtils.showToast(getContext(),"onRefresh");
        samplePresenter.show();
        hideProgress();
    }
}
