package com.example.separate_collection_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.separate_collection_app.service.DetailActivity;

public class SearchScreenActivity extends AppCompatActivity {
    Button camera_screenBtn, gallery_screenBtn;
        //탭
    Button seperate_screenBtn;

    private CustomAdapter adapter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);

        //커스텀 리스트 출력
        adapter = new CustomAdapter();
        listView = (ListView) findViewById(R.id.listView);

        setData();

        listView.setAdapter(adapter);

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int imgRes = ((CustomDTO)adapter.getItem(position)).getResId();

                Intent intent = new Intent(SearchScreenActivity.this, DetailActivity.class);
                intent.putExtra("imRes", imgRes);
                startActivity(intent);
            }
        });

    }

    // 보통 ListView는 통신을 통해 가져온 데이터를 보여줍니다.
    // arrResId, titles, contents를 서버에서 가져온 데이터라고 생각하시면 됩니다.
    private void setData() {
        TypedArray arrResId = getResources().obtainTypedArray(R.array.resId);
        String[] titles = getResources().getStringArray(R.array.title);
        String[] contents = getResources().getStringArray(R.array.content);

        for (int i = 0; i < arrResId.length(); i++) {
            CustomDTO dto = new CustomDTO();
            dto.setResId(arrResId.getResourceId(i, 0));
            dto.setTitle(titles[i]);
            dto.setContent(contents[i]);

            adapter.addItem(dto);
        }
    }
}