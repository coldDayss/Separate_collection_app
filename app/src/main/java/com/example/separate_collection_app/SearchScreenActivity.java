package com.example.separate_collection_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchScreenActivity extends AppCompatActivity {
    Button camera_screenBtn, gallery_screenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);

        camera_screenBtn = (Button) findViewById(R.id.camera_search);

        camera_screenBtn.setOnClickListener((v) -> {
            Intent intent_camera = new Intent(getApplicationContext(), SearchCameraScreenActivity.class);
            startActivity(intent_camera);
        });

        gallery_screenBtn = (Button) findViewById(R.id.gallery_search);

        gallery_screenBtn.setOnClickListener((v) -> {
            Intent intent_gallery = new Intent(getApplicationContext(), SearchGalleryScreenActivity.class);
            startActivity(intent_gallery);
        });
    }
}