package com.hame.adelcid.materialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hame.adelcid.materialdesign.activities.ImageOptActivity;
import com.hame.adelcid.materialdesign.activities.ListViewActivity;
import com.hame.adelcid.materialdesign.activities.TextActivity;
import com.hame.adelcid.materialdesign.activities.SelectedOptActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void returnarResultado(View view) {

        Intent intent = new Intent(this, TextActivity.class);
        startActivity(intent);

    }

    public void starActivity(View view) {
        startActivity(new Intent(this, ImageOptActivity.class));
    }

    public void starSelecteOpt(View view) {
        startActivity(new Intent(this, SelectedOptActivity.class));
    }

    public void StarListView(View view) {
        startActivity(new Intent(this, ListViewActivity.class));
    }


}
