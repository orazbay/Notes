package edu.sdu.kz.baseapplication.presentation.base.list;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;




/**
 * Created by orazbay on 4/7/18.
 */

public interface ListView <T> extends MvpView{
    public void setData(ArrayList<T> items);


}
