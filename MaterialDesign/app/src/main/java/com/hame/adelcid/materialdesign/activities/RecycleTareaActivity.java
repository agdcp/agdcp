package com.hame.adelcid.materialdesign.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hame.adelcid.materialdesign.Clases.ClaseImagen;
import com.hame.adelcid.materialdesign.R;
import com.hame.adelcid.materialdesign.adapters.ItemRecyclerAdapter;
import com.hame.adelcid.materialdesign.adapters.ItemRecyclerTareaAdapter;

import java.util.ArrayList;

public class RecycleTareaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemRecyclerTareaAdapter itemAdapter;
    private Context context;
    private ArrayList<ClaseImagen> claseImagen ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_tarea);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


                claseImagen.add(new ClaseImagen(getResources().getString(R.string.cbx_calculator), R.drawable.thumbnail_calculator));
                itemAdapter = new ItemRecyclerTareaAdapter(context, claseImagen);
                recyclerView.setAdapter(itemAdapter);

            }
        });
        initComponents();
    }

    private void initComponents() {

        claseImagen = new ArrayList<>();
        context = this;
        recyclerView = findViewById(R.id.rv_recycle_tarea);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        claseImagen.add(new ClaseImagen(getResources().getString(R.string.cbx_atm), R.drawable.thumbnail_atm));
        claseImagen.add(new ClaseImagen(getResources().getString(R.string.cbx_bag), R.drawable.thumbnail_bag));
        claseImagen.add(new ClaseImagen(getResources().getString(R.string.cbx_basquet), R.drawable.thumbnail_basket));
        claseImagen.add(new ClaseImagen(getResources().getString(R.string.cbx_box), R.drawable.thumbnail_box));
        claseImagen.add(new ClaseImagen(getResources().getString(R.string.cbx_briefcase), R.drawable.thumbnail_briefcase));
        claseImagen.add(new ClaseImagen(getResources().getString(R.string.cbx_calculator), R.drawable.thumbnail_calculator));


        itemAdapter = new ItemRecyclerTareaAdapter(context, claseImagen);
        recyclerView.setAdapter(itemAdapter);

    }

}
