package com.example.valiumtavorserenase;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView dataList;
    private List<String> titles;
    private List<Integer> images;
    private AdapterHome adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dataList = findViewById(R.id.dataList);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("Games");
        titles.add("App");
        titles.add("Impostazioni");
        titles.add("Rubrica");


        images.add(R.drawable.games);
        images.add(R.drawable.apppredefinite);
        images.add(R.drawable.impostazioni);
        images.add(R.drawable.progettointent);


        adapter = new AdapterHome(this,titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);
    }

}
