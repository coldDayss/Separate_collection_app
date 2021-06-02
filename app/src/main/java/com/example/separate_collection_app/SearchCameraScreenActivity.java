package com.example.separate_collection_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class SearchCameraScreenActivity extends AppCompatActivity {
    Button backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_camera_screen);

        backbtn = (Button) findViewById(R.id.back_bt);

        backbtn.setOnClickListener((view) -> {
            Intent intent = new Intent(getApplicationContext(), SearchScreenActivity.class);
            startActivity(intent);
        });
    }
}