package com.zhiwei.android.widget.viewpage;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zhiwei.android.R;

/**
 * 在此写用途
 *
 * @author: zhiwei
 * @date: 2017-08-29 18:28
 * @version: 9.1.0
 */
public class Empty1Fragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Text1View textView = new Text1View(container.getContext());
            textView.setText("我是空页面111111111111");
        textView.setBackgroundColor(Color.BLUE);
        textView.setTag(R.id.tag_view_holder, 1);
        return textView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
