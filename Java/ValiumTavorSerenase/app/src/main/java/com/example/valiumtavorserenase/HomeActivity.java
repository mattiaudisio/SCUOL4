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

        images.add(R.drawable.games);
        images.add(R.drawable.apppredefinite);
        images.add(R.drawable.impostazioni);

        adapter = new AdapterHome(this,titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);
    }

    public void createIntent(){
        Toast.makeText(this.getApplicationContext(),"Ciao",Toast.LENGTH_SHORT).show();
        /*switch (adapterPosition){
            case 0:
                Intent gamesIntent = new Intent(HomeActivity.this, GamesActivity.class);
                startActivity(gamesIntent);
                break;

        }*/
    }

}