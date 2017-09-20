package com.hame.adelcid.materialdesign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hame.adelcid.materialdesign.Clases.ClaseImagen;
import com.hame.adelcid.materialdesign.R;
import com.hame.adelcid.materialdesign.holders.ItemHolders;
import com.hame.adelcid.materialdesign.holders.ItemHoldersTarea;

import java.util.ArrayList;

/**
 * Created by adelcid on 19/09/2017.
 */

public class ItemRecyclerTareaAdapter extends RecyclerView.Adapter<ItemHoldersTarea> {
    private Context context;
    private ArrayList<ClaseImagen> claseImagen;

    public ItemRecyclerTareaAdapter(Context context, ArrayList<ClaseImagen> claseImagen) {
        this.context = context;
        this.claseImagen = claseImagen;
    }

    @Override
    public ItemHoldersTarea onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater lyInflater = LayoutInflater.from(context);
        View view = lyInflater.inflate(R.layout.item_recycle_tarea, parent, false);
        return new ItemHoldersTarea(view);
    }

    @Override
    public void onBindViewHolder(ItemHoldersTarea holder, int position) {
        holder.setData(claseImagen.get(position).getIdImage(),claseImagen.get(position).getNombreImagen());
    }

    @Override
    public int getItemCount() {
        return claseImagen.size();
    }
}
