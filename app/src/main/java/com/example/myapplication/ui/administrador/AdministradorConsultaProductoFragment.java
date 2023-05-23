package com.example.myapplication.ui.administrador;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.DB.entidades.AdminSqliteOpenHelper;
import com.example.myapplication.DB.sqlite.ConstantesDB;
import com.example.myapplication.databinding.FragmentAdministradorConsultaProductoBinding;

public class AdministradorConsultaProductoFragment extends Fragment {

    private FragmentAdministradorConsultaProductoBinding binding;
    private EditText codigo, descripcion, marca, color, precio;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAdministradorConsultaProductoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button button = binding.button4;
        codigo = binding.textView21;
        descripcion = binding.textView22;
        marca = binding.textView24;
        color = binding.textView25;
        precio = binding.textView23;
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String txt_codigo = codigo.getText().toString();
                if(!txt_codigo.isEmpty()){
                    onCickRegistarSQL(txt_codigo);
                }else{
                    Toast.makeText(getActivity(),"Complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    public void onCickRegistarSQL(String txt_codigo){
        AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(getActivity(),"administracion",null,1);
        SQLiteDatabase database = admin.getWritableDatabase();
        Cursor fila = database.rawQuery(" select "+ConstantesDB.CAMPO_DESCRIPCION+", "+ConstantesDB.CAMPO_COLOR+", "+ConstantesDB.CAMPO_MARCA+", "+ConstantesDB.CAMPO_PRECIO+" "
                + " from "+ConstantesDB.NOMBRE_TABLA_ARTICULO+" where "+ConstantesDB.CAMPO_CODIGO+"="+txt_codigo,null);
        if(fila.moveToFirst()){
            descripcion.setText(fila.getString(0));
            precio.setText(fila.getString(1));
            marca.setText(fila.getString(2));
            color.setText(fila.getString(3));
            Toast.makeText(getActivity(),"Se encontro el Articulo", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"No existe el articulo", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}