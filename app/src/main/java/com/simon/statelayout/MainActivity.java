package com.simon.statelayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cover(View view) {
        Intent intent = new Intent(this, StateActivity.class);
        intent.putExtra("type", "Cover");
        startActivity(intent);
    }

    public void replace(View view) {
        Intent intent = new Intent(this, StateActivity.class);
        intent.putExtra("type", "Replace");
        startActivity(intent);
    }


}
