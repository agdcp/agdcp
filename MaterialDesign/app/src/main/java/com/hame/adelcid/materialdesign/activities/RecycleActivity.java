package com.hame.adelcid.materialdesign.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hame.adelcid.materialdesign.R;
import com.hame.adelcid.materialdesign.adapters.ItemRecyclerAdapter;

public class RecycleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemRecyclerAdapter itemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //agregar tarea
            }
        });
        initComponents();

    }

    private void initComponents() {
        recyclerView = findViewById(R.id.rv_recycle);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        int[] drawables = new int[]{
                R.drawable.thumbnail_atm, R.drawable.thumbnail_bag,
                R.drawable.thumbnail_basket, R.drawable.thumbnail_box,
                R.drawable.thumbnail_briefcase, R.drawable.thumbnail_calculator
        };

        String[] labels = getResources().getStringArray(R.array.selected_options);
        itemAdapter = new ItemRecyclerAdapter(drawables, labels, this);
        recyclerView.setAdapter(itemAdapter);

    }

}


