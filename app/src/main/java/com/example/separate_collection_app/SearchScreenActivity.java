package com.example.separate_collection_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class SearchScreenActivity extends AppCompatActivity {
    Button camera_screenBtn, gallery_screenBtn;

    //탭
    Button seperate_screenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);

        //카메라 검색
        camera_screenBtn = (Button) findViewById(R.id.camera_search);

        camera_screenBtn.setOnClickListener((v) -> {
            Intent intent_camera = new Intent(getApplicationContext(), SearchCameraScreenActivity.class);
            startActivity(intent_camera);
        });

        //이미지 검색
        gallery_screenBtn = (Button) findViewById(R.id.gallery_search);

        gallery_screenBtn.setOnClickListener((v) -> {
            Intent intent_gallery = new Intent(getApplicationContext(), SearchGalleryScreenActivity.class);
            startActivity(intent_gallery);
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        //분리수거 기준
        seperate_screenBtn = (Button) findViewById(R.id.seperate_screen_btn);

        seperate_screenBtn.setOnClickListener((v) -> {
            Intent intent_seperate = new Intent(getApplicationContext(), SeperateScreenActivity.class);
            startActivity(intent_seperate);
        });
    }
}