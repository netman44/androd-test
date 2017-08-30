package com.zhiwei.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.zhiwei.android.widget.viewpage.ViewPageAnimatorActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewPageAnimator(View vIew) {
        Intent intent = new Intent(this, ViewPageAnimatorActivity.class);
        startActivity(intent);
    }
}
