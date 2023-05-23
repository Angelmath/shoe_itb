package com.example.myapplication.ui.administrador;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DB.entidades.AdminSqliteOpenHelper;
import com.example.myapplication.DB.entidades.articulos;
import com.example.myapplication.DB.sqlite.ConstantesDB;
import com.example.myapplication.databinding.FragmentAdministradorConsultaListaProductoBinding;

import java.util.ArrayList;

public class AdministradorConsultaListaProductoFragment extends Fragment {

    private FragmentAdministradorConsultaListaProductoBinding binding;
    ArrayList<articulos> listArticulo ;
    MiAdaptador adaptador;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAdministradorConsultaListaProductoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button actualizar = binding.button3;
        RecyclerView recyclerView = binding.recycler;
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
        listArticulo = actualizacion();
        adaptador = new MiAdaptador(listArticulo);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adaptador);

        actualizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                listArticulo = actualizacion();
               adaptador.notifyDataSetChanged();
            }
        });
        return root;
    }

    public ArrayList<articulos> actualizacion(){
        ArrayList<articulos> listArticuloTxt = new ArrayList<>();
        AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(getActivity(),"administracion",null,1);
        SQLiteDatabase database = admin.getWritableDatabase();
        Cursor fila = database.rawQuery(" select "+ ConstantesDB.CAMPO_CODIGO+", "+ ConstantesDB.CAMPO_DESCRIPCION+", "+ConstantesDB.CAMPO_MARCA+", "+ConstantesDB.CAMPO_COLOR+", "+ConstantesDB.CAMPO_PRECIO+" "
                + " from "+ConstantesDB.NOMBRE_TABLA_ARTICULO,null);
        if(fila.moveToFirst()){
            try {
                do{
                    articulos data = new articulos(Integer.parseInt(fila.getString(0)),fila.getString(1),fila.getString(2),fila.getString(3),Float.parseFloat(fila.getString(4)));
                    listArticuloTxt.add(data);
                }while (fila.moveToNext());
            } finally {
                fila.close();
            }
            Toast.makeText(getActivity(),"Se encontraron Articulos", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"No existe el articulo", Toast.LENGTH_SHORT).show();
        }
        return listArticuloTxt;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}