package edu.sdu.kz.baseapplication.presentation.base;

import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpDelegate;


public abstract class BaseRvAdapter<View extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<View>{
    MvpDelegate mParentDelegate;
    MvpDelegate<BaseRvAdapter> mMvpDelegate;
    int parentDelateId;

    public void init(MvpDelegate mParentDelegate,int parentDelateId){
        this.mParentDelegate=mParentDelegate;
        this.parentDelateId=parentDelateId;

        getmMvpDelegate().onCreate();
        getmMvpDelegate().onAttach();
    }
    public void destroy(){
        getmMvpDelegate().onSaveInstanceState();
        getmMvpDelegate().onDetach();
    }
    MvpDelegate<BaseRvAdapter> getmMvpDelegate() {
        if (mMvpDelegate != null) {
            return mMvpDelegate;
        }

        mMvpDelegate = new MvpDelegate<>(this);
        mMvpDelegate.setParentDelegate(mParentDelegate, String.valueOf(parentDelateId));
        return mMvpDelegate;
    }
}
