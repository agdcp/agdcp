package com.hame.adelcid.proyectofinal.adapters;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hame.adelcid.proyectofinal.R;
import com.hame.adelcid.proyectofinal.clases.Cliente;
import com.hame.adelcid.proyectofinal.holders.ItemHolderCliente;

import java.util.ArrayList;

/**
 * Created by adelcid on 28/09/2017.
 */

public class ItemAdapterCliente extends RecyclerView.Adapter<ItemHolderCliente> {

    private Context context;
    private ArrayList<Cliente> listaCliente;

    public ItemAdapterCliente(Context context, ArrayList<Cliente> listaCliente) {
        this.context = context;
        this.listaCliente = listaCliente;
    }

    @Override
    public ItemHolderCliente onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = LayoutInflater.from(context);
        View view = li.inflate(R.layout.item_cliente, parent, false);
        return new ItemHolderCliente(view);
    }

    @Override
    public void onBindViewHolder(ItemHolderCliente holder, int position) {
        Cliente cliente = listaCliente.get(position);
        holder.setData(Integer.toString(cliente.getId()),cliente.getImagen(),cliente.getCliente(),cliente.getDireccion(),cliente.getTelefono(), context);
    }

    @Override
    public int getItemCount() {
        return listaCliente.size();
    }
}
