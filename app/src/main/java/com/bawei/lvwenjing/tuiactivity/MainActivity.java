package com.bawei.lvwenjing.tuiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.bawei.lvwenjing.tuiactivity.newsdrag.ChannelActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(MainActivity.this, ChannelActivity.class));
    }
}
