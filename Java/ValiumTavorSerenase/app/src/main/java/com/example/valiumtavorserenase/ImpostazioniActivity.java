package com.example.valiumtavorserenase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class ImpostazioniActivity extends AppCompatActivity {

    private RecyclerView dataList;
    private List<String> titles;
    private List<Integer> images;
    private AdapterGames adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impostazioni);
    }
}