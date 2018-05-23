package edu.sdu.kz.baseapplication.presentation.base;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import butterknife.BindView;
import edu.sdu.kz.baseapplication.R;
import edu.sdu.kz.baseapplication.presentation.base.refresh.RefreshFragment;

public class ActivityWithFragmentContainer extends BaseActivity {
    public ActivityWithFragmentContainer() {
        super(R.layout.activity_with_container_layout);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
