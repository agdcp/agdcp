package com.hame.adelcid.materialdesign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;


import com.hame.adelcid.materialdesign.R;


public class ImageOptActivity extends AppCompatActivity {

    private CheckBox cbxAtm;
    private CheckBox cbxbag;
    private CheckBox cbxbasket;
    private CheckBox cbxbox;
    private CheckBox cbxbriefcase;
    private CheckBox cbxcalculate;
    private ImageView imgatm;
    private ImageView imgbag;
    private ImageView imgbasket;
    private ImageView imgbox;
    private ImageView imgbriefcase;
    private ImageView imgcalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_opt);
        initComponente();
    }

    private void initComponente() {
        cbxAtm = (CheckBox) findViewById(R.id.cbx_atm);
        cbxAtm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imgatm.setVisibility(View.VISIBLE);
                } else {
                    imgatm.setVisibility(View.INVISIBLE);
                }
            }
        });

        cbxbag = (CheckBox) findViewById(R.id.cbx_bag);
        cbxbag.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imgbag.setVisibility(View.VISIBLE);
                } else {
                    imgbag.setVisibility(View.INVISIBLE);
                }
            }
        });

        cbxbasket = (CheckBox) findViewById(R.id.cbx_basquet);
        cbxbasket.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imgbasket.setVisibility(View.VISIBLE);
                } else {
                    imgbasket.setVisibility(View.INVISIBLE);
                }
            }
        });

        cbxbox = (CheckBox) findViewById(R.id.cbx_box);
        cbxbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imgbox.setVisibility(View.VISIBLE);
                } else {
                    imgbox.setVisibility(View.INVISIBLE);
                }
            }
        });

        cbxbriefcase = (CheckBox) findViewById(R.id.cbx_briefcase);
        cbxbriefcase.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imgbriefcase.setVisibility(View.VISIBLE);
                } else {
                    imgbriefcase.setVisibility(View.INVISIBLE);
                }
            }
        });

        cbxcalculate = (CheckBox) findViewById(R.id.cbx_calulate);
        cbxcalculate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imgcalculate.setVisibility(View.VISIBLE);
                } else {
                    imgcalculate.setVisibility(View.INVISIBLE);
                }
            }
        });

        imgatm = (ImageView) findViewById(R.id.iv_atm);
        imgbag = (ImageView) findViewById(R.id.iv_bag);
        imgbasket = (ImageView) findViewById(R.id.iv_basket);
        imgbox = (ImageView) findViewById(R.id.iv_box);
        imgbriefcase = (ImageView) findViewById(R.id.iv_briefcase);
        imgcalculate = (ImageView) findViewById(R.id.iv_calcualte);
    }
}
