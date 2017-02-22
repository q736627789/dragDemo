package com.lemoni.view.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by dellit on 2017/2/20.
 */

public class BaseFragment extends Fragment {
    //获取上下文context
    protected Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
