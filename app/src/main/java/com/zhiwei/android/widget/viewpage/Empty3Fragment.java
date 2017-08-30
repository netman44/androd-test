package com.zhiwei.android.widget.viewpage;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 在此写用途
 *
 * @author: zhiwei
 * @date: 2017-08-29 18:28
 * @version: 9.1.0
 */
public class Empty3Fragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        TextView textView = new Text3View(container.getContext());
            textView.setText("我是空页面333333");
        textView.setBackgroundColor(Color.RED);
        return textView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
