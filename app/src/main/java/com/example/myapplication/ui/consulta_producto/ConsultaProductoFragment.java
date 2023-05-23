package com.example.myapplication.ui.consulta_producto;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DB.entidades.AdminSqliteOpenHelper;
import com.example.myapplication.DB.entidades.articulos;
import com.example.myapplication.DB.entidades.articulos2;
import com.example.myapplication.DB.sqlite.ConstantesDB;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAdministradorConsultaListaProductoBinding;
import com.example.myapplication.databinding.FragmentConsultaProductoBinding;
import com.example.myapplication.ui.administrador.MiAdaptador;
import com.example.myapplication.ui.administrador.MiAdaptador2;

import java.util.ArrayList;
import java.util.Random;

public class ConsultaProductoFragment extends Fragment {

    private FragmentConsultaProductoBinding binding;
    ArrayList<articulos2> listArticulo ;
    MiAdaptador2 adaptador;
    Random r = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentConsultaProductoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        RecyclerView recyclerView = binding.recycler;
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
        r = new Random();
        listArticulo = actualizacion();
        adaptador = new MiAdaptador2(listArticulo);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adaptador);
        return root;
    }

    public ArrayList<articulos2> actualizacion(){
        ArrayList<articulos2> listArticuloTxt = new ArrayList<>();
        AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(getActivity(),"administracion",null,1);
        SQLiteDatabase database = admin.getWritableDatabase();
        Cursor fila = database.rawQuery(" select "+ ConstantesDB.CAMPO_CODIGO+", "+ ConstantesDB.CAMPO_DESCRIPCION+", "+ConstantesDB.CAMPO_MARCA+", "+ConstantesDB.CAMPO_COLOR+", "+ConstantesDB.CAMPO_PRECIO+" "
                + " from "+ConstantesDB.NOMBRE_TABLA_ARTICULO,null);
        ArrayList<Integer> imagenes = new ArrayList<>();
        imagenes.add(R.drawable.consulta1);
        imagenes.add(R.drawable.consulta2);
        imagenes.add(R.drawable.consulta3);
        imagenes.add(R.drawable.consulta4);
        imagenes.add(R.drawable.consulta5);
        if(fila.moveToFirst()){
            try {
                do{

                    articulos2 data = new articulos2(imagenes.get(r.nextInt(5)),fila.getString(1),fila.getString(2),fila.getString(3),Float.parseFloat(fila.getString(4)));
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