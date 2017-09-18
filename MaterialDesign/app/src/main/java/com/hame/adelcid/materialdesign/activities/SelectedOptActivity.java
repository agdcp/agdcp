package com.hame.adelcid.materialdesign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.hame.adelcid.materialdesign.R;

public class SelectedOptActivity extends AppCompatActivity {

    private Spinner sOption;
    private ImageView ivSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_opt);
        initComponent();
    }

    private void initComponent() {
        ivSelected = (ImageView) findViewById(R.id.iv_select);
        sOption = (Spinner) findViewById(R.id.s_option);
        String[] option =
                getResources().getStringArray(R.array.selected_options);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, option);
        sOption.setAdapter(adapter);

        sOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ivSelected.setImageResource(R.drawable.thumbnail_atm);
                        break;
                    case 1:
                        ivSelected.setImageResource(R.drawable.thumbnail_bag);
                        break;
                    case 2:
                        ivSelected.setImageResource(R.drawable.thumbnail_basket);
                        break;
                    case 3:
                        ivSelected.setImageResource(R.drawable.thumbnail_box);
                        break;
                    case 4:
                        ivSelected.setImageResource(R.drawable.thumbnail_briefcase);
                        break;
                    case 5:
                        ivSelected.setImageResource(R.drawable.thumbnail_calculator);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
