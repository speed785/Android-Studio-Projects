package com.example.simplelauncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//in onCreate method, we invoke setContentView

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void showApps(View v){
        Intent i = new Intent(this, AppsListActivity.class);
        startActivity(i);
    }
}

