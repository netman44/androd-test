package com.zhiwei.android.widget.viewpage;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zhiwei.android.R;

/**
 * 在此写用途
 *
 * @author: zhiwei
 * @date: 2017-08-29 18:28
 * @version: 9.1.0
 */
public class Empty2Fragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        TextView textView = new Text2View(container.getContext());
            textView.setText("我是空页面22222222");
        textView.setBackgroundColor(Color.GRAY);
        textView.setTag(R.id.tag_view_holder, 2);
        return textView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
