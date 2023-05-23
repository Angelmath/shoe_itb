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

import com.example.myapplication.DB.entidades.articulos2;
import com.example.myapplication.DB.entidades.articulos3;
import com.example.myapplication.R;

import java.util.List;

public class MiAdaptador3 extends RecyclerView.Adapter<MiAdaptador3.TitularViewHolder> {
    private List<articulos3> articulos;

    public MiAdaptador3(List<articulos3> articulos) {
        this.articulos = articulos;
    }

    @NonNull
    @Override
    public TitularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater desplegar = LayoutInflater.from(context);

        View titularView = desplegar.inflate(R.layout.lista_articulos3, parent, false);

        TitularViewHolder titularViewHolder = new TitularViewHolder(titularView);
        return titularViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TitularViewHolder holder, int position) {
        final articulos3 articulos1 = articulos.get(position);
        TextView nombre = holder.data1;
        TextView apellido = holder.data2;
        TextView correo = holder.data3;
        nombre.setText(articulos1.getNombre());
        apellido.setText(articulos1.getApellido());
        correo.setText(articulos1.getCorreo());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView nombre = (TextView) view.findViewById(R.id.data1);
                TextView apellido = (TextView) view.findViewById(R.id.data3);
                TextView correo = (TextView) view.findViewById(R.id.data4);
                Toast.makeText(view.getContext(), "Seleccion de Lista:" + nombre.getText().toString() + " " + apellido.getText().toString() + " " +
                        correo.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return articulos.size();
    }

    public static class TitularViewHolder extends RecyclerView.ViewHolder{

        public TextView data1;
        public TextView data2;
        public TextView data3;

        public TitularViewHolder(View itemView) {
            super(itemView);
            data1 = (TextView)itemView.findViewById(R.id.data1);
            data2 = (TextView)itemView.findViewById(R.id.data2);
            data3 = (TextView)itemView.findViewById(R.id.data3);

        }
    }
}
