package com.example.myapplication.ui.administrador;

import android.content.ContentValues;
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
import com.example.myapplication.databinding.FragmentAdministradorModProductoBinding;

public class AdministradorModProductoFragment extends Fragment {

    private FragmentAdministradorModProductoBinding binding;
    private EditText codigo, descripcion, marca, color, precio;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAdministradorModProductoBinding.inflate(inflater, container, false);
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
                String txt_descripcion = descripcion.getText().toString();
                String txt_marca = marca.getText().toString();
                String txt_color = color.getText().toString();
                String txt_precio = precio.getText().toString();
                if(!txt_codigo.isEmpty() && !txt_descripcion.isEmpty() && !txt_marca.isEmpty() && !txt_color.isEmpty() && !txt_precio.isEmpty()){
                    onCickRegistarSQL(txt_codigo, txt_descripcion, txt_marca, txt_color,txt_precio);
                }else{
                    Toast.makeText(getActivity(),"Complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    public void onCickRegistarSQL(String txt_codigo, String txt_descripcion, String txt_marca, String txt_color, String txt_precio){
        AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(getActivity(),"administracion",null,1);
        SQLiteDatabase database = admin.getWritableDatabase();
        String parametros[]={txt_codigo};
        ContentValues registro = new ContentValues();
        registro.put(ConstantesDB.CAMPO_DESCRIPCION,txt_descripcion);
        registro.put(ConstantesDB.CAMPO_MARCA,txt_marca);
        registro.put(ConstantesDB.CAMPO_COLOR,txt_color);
        registro.put(ConstantesDB.CAMPO_PRECIO,txt_precio);
        int cant = database.update(ConstantesDB.NOMBRE_TABLA_ARTICULO,registro,ConstantesDB.CAMPO_CODIGO+"=?",parametros);
        database.close();
        codigo.setText("");
        descripcion.setText("");
        marca.setText("");
        color.setText("");
        precio.setText("");
        if(cant>0){
            Toast.makeText(getActivity(),"Actualizacion de Producto Exitoso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"El registro a modificar no existe", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}