package com.example.myapplication.ui.administrador;

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
import com.example.myapplication.databinding.FragmentAdministradorProductoBinding;

public class AdministradorProductoFragment extends Fragment {

    private FragmentAdministradorProductoBinding binding;
    private EditText codigo, descripcion, marca, color, precio;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAdministradorProductoBinding.inflate(inflater, container, false);
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
        String query = "insert into "+ ConstantesDB.NOMBRE_TABLA_ARTICULO +" ( "+ConstantesDB.CAMPO_CODIGO+", "+ConstantesDB.CAMPO_DESCRIPCION+", "+ConstantesDB.CAMPO_MARCA+", "+ConstantesDB.CAMPO_COLOR+", "+ConstantesDB.CAMPO_PRECIO+" ) "
                + " values ( "+ txt_codigo +", '"+txt_descripcion+"', '"+txt_marca+"', '"+txt_color+"', "+txt_precio+" )" ;
        database.execSQL(query);
        database.close();
        codigo.setText("");
        descripcion.setText("");
        marca.setText("");
        color.setText("");
        precio.setText("");
        Toast.makeText(getActivity(),"Registro de Producto Exitoso", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}