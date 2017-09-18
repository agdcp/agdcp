package com.hame.adelcid.materialdesign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.hame.adelcid.materialdesign.R;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView ivListview;
    private ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initListview();
    }

    public void initListview() {
        imgview = (ImageView) findViewById(R.id.imageView);
        ivListview = (ListView) findViewById(R.id.List_view);
        String[] option = getResources().getStringArray(R.array.selected_options);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option);
        ivListview.setAdapter(adapter);
        ivListview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
            case 0:
                imgview.setImageResource(R.drawable.thumbnail_atm);
                break;
            case 1:
                imgview.setImageResource(R.drawable.thumbnail_bag);
                break;
            case 2:
                imgview.setImageResource(R.drawable.thumbnail_basket);
                break;
            case 3:
                imgview.setImageResource(R.drawable.thumbnail_box);
                break;
            case 4:
                imgview.setImageResource(R.drawable.thumbnail_briefcase);
                break;
            case 5:
                imgview.setImageResource(R.drawable.thumbnail_calculator);
                break;
        }

    }
}
