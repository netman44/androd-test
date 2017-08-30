package com.zhiwei.android.widget.viewpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.PageTransformer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.zhiwei.android.R;
import com.zhiwei.android.widget.EmptyFragment;

public class ViewPageAnimatorActivity extends AppCompatActivity {
    MViewPager mViewPager;
    MViewPager mWrapViewPager;
    View child1, child2;

    int mPositionOffsetPixels = -1;
    int mPosition;
    int mScrollOrientation = KeyEvent.KEYCODE_UNKNOWN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view_page_animator);
        mViewPager = (MViewPager)findViewById(R.id.viewPageAnimator);
        mWrapViewPager = (MViewPager)findViewById(R.id.viewpageWrap);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final ViewPageAdapter viewPageAdapter = new ViewPageAdapter(fragmentManager);
        mViewPager.setAdapter(viewPageAdapter);
        child1 = findViewById(R.id.child_1);
        child2 = findViewById(R.id.child_2);
        mPosition = 0;



        mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (mScrollOrientation == KeyEvent.KEYCODE_UNKNOWN && mPositionOffsetPixels != 0
                    && mPositionOffsetPixels < positionOffsetPixels) {
                    //右滑
                    mScrollOrientation = KeyEvent.KEYCODE_DPAD_UP_LEFT;

                } else if (mScrollOrientation == KeyEvent.KEYCODE_UNKNOWN && mPositionOffsetPixels != 0
                    && mPositionOffsetPixels > positionOffsetPixels) {
                    //左滑
                    mScrollOrientation = KeyEvent.KEYCODE_DPAD_UP_RIGHT;
                }
                if (position != mPosition) {
                    mScrollOrientation = KeyEvent.KEYCODE_UNKNOWN;
                }
                mPositionOffsetPixels = positionOffsetPixels;
                mPosition = position;

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //if (state == ViewPager.SCROLL_STATE_IDLE) {
                //    mScrollOrientation = KeyEvent.KEYCODE_UNKNOWN;
                //    mPositionOffsetPixels = 0;
                //}
            }
        });
        mViewPager.setPageTransformer(true, new PageTransformer() {
            private float MIN_SCALE = 0.75f;

            @Override
            public void transformPage(View view, float position) {
                Log.e("致伟", " transformPage: view=" + view.getClass().getSimpleName() +" position="+position +" mScrollOrientation="+mScrollOrientation);
                int type = 0;
                if (view.getTag(R.id.tag_view_holder) instanceof Integer) {
                    type = (int)view.getTag(R.id.tag_view_holder);
                }

                int pageWidth = view.getWidth();
                if (position <= -1) { // [-Infinity,-1)//This page is way off-screen to the left.
                    //处理快速滑动时，有残留在界面，设置为不可见即可
                    if (type == 1) {
                        child1.setVisibility(View.GONE);
                    } else if (type == 2) {
                        child2.setVisibility(View.GONE);
                    }
                } else if (position <= 0) { // [-1,0]Use //the default slide transition when moving to the left page
                    if (mScrollOrientation == KeyEvent.KEYCODE_DPAD_UP_LEFT) {
                        if (type == 1) {
                            child1.setVisibility(View.VISIBLE);
                            child1.setTranslationX(-mPositionOffsetPixels);
                        } else if(type == 2) {
                            child2.setVisibility(View.VISIBLE);
                            child2.setTranslationX(-mPositionOffsetPixels);
                        }else {
                            child1.setTranslationX(-pageWidth * 2);
                            child2.setTranslationX(-pageWidth * 2);
                        }
                    } else if (mScrollOrientation == KeyEvent.KEYCODE_DPAD_UP_RIGHT) {
                        if (type == 1) {
                            child1.setVisibility(View.VISIBLE);
                            child1.setTranslationX(- mPositionOffsetPixels);
                        } else if (type == 2) {
                            child2.setVisibility(View.VISIBLE);
                            child2.setTranslationX(- mPositionOffsetPixels);
                        }
                    }
                } else if (position <= 1) { // (0,1]// Fade the page out.
                    if (mScrollOrientation == KeyEvent.KEYCODE_DPAD_UP_LEFT) {
                        if (type == 2) {
                            child2.setVisibility(View.VISIBLE);
                            child2.setTranslationX(mViewPager.getWidth() - mPositionOffsetPixels);
                        } else if (type == 1) {
                            child1.setTranslationX(mViewPager.getWidth() - mPositionOffsetPixels);
                        }
                    } else if (mScrollOrientation == KeyEvent.KEYCODE_DPAD_UP_RIGHT) {
                        if (type == 1) {
                            child1.setTranslationX(mViewPager.getWidth() - mPositionOffsetPixels);
                        } else if (type == 2) {
                            child2.setTranslationX(mViewPager.getWidth() - mPositionOffsetPixels);
                        }
                    }
                } else { // (1,+Infinity]
                    //处理快速滑动时，有残留在界面，设置为不可见即可
                    if (type == 1) {
                        child1.setVisibility(View.GONE);
                    } else if (type == 2) {
                        child2.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    private class ViewPageAdapter extends MYFragmentPagerAdapter {

        public ViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 3) {
                return new Empty1Fragment();
            }
            if (position == 1) {
                return new Empty2Fragment();
            }
            if (position == 2) {
                return new Empty3Fragment();
            } else {
                return new EmptyFragment();
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

}
