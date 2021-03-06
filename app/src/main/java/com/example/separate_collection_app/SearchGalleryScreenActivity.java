package com.example.separate_collection_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SearchGalleryScreenActivity extends AppCompatActivity {
    Button backbtn;

    private final int GET_GALLERY_IMAGE = 200;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_gallery_screen);

        backbtn = (Button) findViewById(R.id.back_bt);
        imageView = (ImageView) findViewById(R.id.gallery_view);

        backbtn.setOnClickListener((view) -> {
            Intent intent = new Intent(getApplicationContext(), SearchScreenActivity.class);
            startActivity(intent);
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri selectedImageUri = data.getData(); //이미지 uri 저장
            imageView.setImageURI(selectedImageUri);
        }
    }
}