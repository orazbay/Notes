package edu.sdu.kz.baseapplication.presentation.base.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import edu.sdu.kz.baseapplication.R;
import edu.sdu.kz.baseapplication.presentation.base.BaseActivity;

public class ActivityWithRefreshLayout extends BaseActivity {
    @BindView(R.id.refreshLayout)
    public SwipeRefreshLayout refreshLayout;


    public void setChildFragment(RefreshFragment refreshFragment){
        this.refreshLayout.setOnRefreshListener(refreshFragment);
    }

    public SwipeRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public ActivityWithRefreshLayout() {
        super(R.layout.activity_with_refresh_layout);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
