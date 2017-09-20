package com.hame.adelcid.materialdesign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hame.adelcid.materialdesign.R;
import com.hame.adelcid.materialdesign.holders.ItemHolders;

/**
 * Created by adelcid on 18/09/2017.
 */

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemHolders> {
    private int[] imagesResource;
    private String[] labels;
    private Context context;

    public ItemRecyclerAdapter(int[] imagesResource, String[] labels, Context context) {
        this.imagesResource = imagesResource;
        this.labels = labels;
        this.context = context;

    }

    @Override
    public ItemHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View view = li.inflate(R.layout.item_recycler, parent, false);
        return new ItemHolders(view);
    }

    @Override
    public void onBindViewHolder(ItemHolders holder, int position) {
        holder.setData(imagesResource[position],labels[position]);
    }

    @Override
    public int getItemCount() {
        return imagesResource.length;
    }
}
