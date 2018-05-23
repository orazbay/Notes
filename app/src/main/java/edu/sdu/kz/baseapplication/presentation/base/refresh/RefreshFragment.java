package edu.sdu.kz.baseapplication.presentation.base.refresh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.sdu.kz.baseapplication.presentation.base.fragment.BaseFragment;

public abstract class RefreshFragment extends BaseFragment implements RefreshFragmentView,SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout swipeRefreshLayout;

    public void setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
    }



    @Override
    public void onStart() {
        super.onStart();
        showProgress();
        onRefresh();

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void showProgress() {
        swipeRefreshLayout.setRefreshing(true);

    }

    @Override
    public void hideProgress() {
        swipeRefreshLayout.setRefreshing(false);

    }
}
