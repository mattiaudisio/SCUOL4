package com.example.valiumtavorserenase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AppActivity extends AppCompatActivity {

    private RecyclerView dataList;
    private List<String> titles;
    private List<Integer> images;
    private AdapterApp adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        dataList = findViewById(R.id.dataListGames);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("Progetto Intent");

        images.add(R.drawable.progettointent);

        adapter = new AdapterApp(this,titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);
    }
}