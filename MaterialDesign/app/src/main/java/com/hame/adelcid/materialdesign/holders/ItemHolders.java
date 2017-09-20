package com.hame.adelcid.materialdesign.holders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hame.adelcid.materialdesign.R;

/**
 * Created by adelcid on 18/09/2017.
 */

public class ItemHolders extends RecyclerView.ViewHolder {
    private CardView cvBackground;
    private ImageView ivImage;
    private TextView tvLabel;

    public ItemHolders(View itemView) {
        super(itemView);
        cvBackground = itemView.findViewById(R.id.cv_item_recycler);
        ivImage = itemView.findViewById(R.id.iv_item_image);
        tvLabel = itemView.findViewById(R.id.tv_item_label);

    }
    public void setData (int imageResource, String label){
        ivImage.setImageResource(imageResource);
        tvLabel.setText(label);
    }
}
