package com.zhiwei.android.widget.viewpage;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * 在此写用途
 *
 * @author: zhiwei
 * @date: 2017-08-30 10:24
 * @version: 9.1.0
 */
public class MViewPager extends ViewPager{
    public MViewPager(Context context) {
        super(context);
    }

    public MViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onPageScrolled(int position, float offset, int offsetPixels) {
        super.onPageScrolled(position, offset, offsetPixels);
    }
}
