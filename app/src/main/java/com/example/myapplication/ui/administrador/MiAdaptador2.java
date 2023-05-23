package com.example.myapplication.ui.administrador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DB.entidades.articulos;
import com.example.myapplication.DB.entidades.articulos2;
import com.example.myapplication.R;

import java.util.List;

public class MiAdaptador2 extends RecyclerView.Adapter<MiAdaptador2.TitularViewHolder> {
    private List<articulos2> articulos;

    public MiAdaptador2(List<com.example.myapplication.DB.entidades.articulos2> articulos) {
        this.articulos = articulos;
    }

    @NonNull
    @Override
    public TitularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater desplegar = LayoutInflater.from(context);

        View titularView = desplegar.inflate(R.layout.lista_articulos2, parent, false);

        TitularViewHolder titularViewHolder = new TitularViewHolder(titularView);
        return titularViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TitularViewHolder holder, int position) {
        final articulos2 articulos1 = articulos.get(position);
        ImageView codigo = holder.data1;
        TextView descripcion = holder.data2;
        TextView marca = holder.data3;
        TextView color = holder.data4;
        TextView precio = holder.data5;
        codigo.setImageResource(articulos1.getCodigo());
        descripcion.setText(articulos1.getDescripcion());
        marca.setText(articulos1.getMarca());
        color.setText(articulos1.getColor());
        precio.setText(articulos1.getPrecio()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView descripcion = (TextView) view.findViewById(R.id.data2);
                TextView marca = (TextView) view.findViewById(R.id.data3);
                TextView color = (TextView) view.findViewById(R.id.data4);
                TextView precio = (TextView) view.findViewById(R.id.data5);
                Toast.makeText(view.getContext(), "Seleccion de Lista:" + descripcion.getText().toString() + " " + marca.getText().toString() + " " +
                        color.getText().toString() + " " + precio.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return articulos.size();
    }

    public static class TitularViewHolder extends RecyclerView.ViewHolder{

        public ImageView data1;
        public TextView data2;
        public TextView data3;
        public TextView data4;
        public TextView data5;

        public TitularViewHolder(View itemView) {
            super(itemView);
            data1 = (ImageView)itemView.findViewById(R.id.imageView3);
            data2 = (TextView)itemView.findViewById(R.id.data2);
            data3 = (TextView)itemView.findViewById(R.id.data3);
            data4 = (TextView)itemView.findViewById(R.id.data4);
            data5 = (TextView)itemView.findViewById(R.id.data5);
        }
    }
}
