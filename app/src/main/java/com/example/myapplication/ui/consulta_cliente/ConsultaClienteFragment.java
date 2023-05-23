package com.example.myapplication.ui.consulta_cliente;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DB.entidades.AdminSqliteOpenHelper;
import com.example.myapplication.DB.entidades.articulos2;
import com.example.myapplication.DB.entidades.articulos3;
import com.example.myapplication.DB.sqlite.ConstantesDB;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentConsultaClienteBinding;
import com.example.myapplication.databinding.FragmentConsultaProductoBinding;
import com.example.myapplication.ui.administrador.MiAdaptador2;
import com.example.myapplication.ui.administrador.MiAdaptador3;

import java.util.ArrayList;
import java.util.Random;

public class ConsultaClienteFragment extends Fragment {

    private FragmentConsultaClienteBinding binding;
    ArrayList<articulos3> listArticulo ;
    MiAdaptador3 adaptador;
    Random r = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentConsultaClienteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        RecyclerView recyclerView = binding.recycler;
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
        r = new Random();
        listArticulo = actualizacion();
        adaptador = new MiAdaptador3(listArticulo);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adaptador);
        return root;
    }

    public ArrayList<articulos3> actualizacion(){
        ArrayList<articulos3> listArticuloTxt = new ArrayList<>();
        AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(getActivity(),"administracion",null,1);
        SQLiteDatabase database = admin.getWritableDatabase();
        Cursor fila = database.rawQuery(" select "+ ConstantesDB.CAMPO_NOMBRE+", "+ ConstantesDB.CAMPO_APELLIDO+", "+ConstantesDB.CAMPO_EMAIL+" "
                + " from "+ConstantesDB.NOMBRE_TABLA_USUARIO+ " WHERE rol='Cliente' ",null);
        if(fila.moveToFirst()){
            try {
                do{

                    articulos3 data = new articulos3(fila.getString(0),fila.getString(1),fila.getString(2));
                    listArticuloTxt.add(data);
                }while (fila.moveToNext());
            } finally {
                fila.close();
            }
            Toast.makeText(getActivity(),"Se encontraron Clientes", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"No existe el cliente", Toast.LENGTH_SHORT).show();
        }
        return listArticuloTxt;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}