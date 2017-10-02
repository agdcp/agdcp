package com.hame.adelcid.proyectofinal.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hame.adelcid.proyectofinal.R;
import com.hame.adelcid.proyectofinal.activities.ListadoIngresosActivity;

/**
 * Created by adelcid on 28/09/2017.
 */

public class ItemHolderCliente  extends RecyclerView.ViewHolder  {

    private ImageView ivImage;
    private TextView tvIdCliente;
    private TextView tvCliente;
    private TextView tvDireccion;
    private TextView tvTelefono;
    private RelativeLayout relativeLayout;
    private Context context;

    public ItemHolderCliente(View itemView) {
        super(itemView);
        ivImage = itemView.findViewById(R.id.iv_cliente);
        tvIdCliente = itemView.findViewById(R.id.tv_idCliente);
        tvCliente = itemView.findViewById(R.id.tv_cliente);
        tvDireccion = itemView.findViewById(R.id.tv_direccion);
        tvTelefono = itemView.findViewById(R.id.tv_telefono);
        relativeLayout = itemView.findViewById(R.id.rl_item_cliente);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ListadoIngresosActivity)context).trasladoPantalla(tvIdCliente.getText().toString());
            }
        });

    }

    public void setData (String idCliente,String imagen, String cliente, String direccion, String telefono, Context context){
        //ivImage.setImageResource(imageResource);
        this.context = context;
        tvIdCliente.setText(idCliente);
        tvCliente.setText(cliente);
        tvDireccion.setText(direccion);
        tvTelefono.setText(telefono);
    }

}
