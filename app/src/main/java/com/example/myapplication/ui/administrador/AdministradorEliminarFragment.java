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
import com.example.myapplication.databinding.FragmentAdministradorEliminarProductoBinding;

public class AdministradorEliminarFragment extends Fragment {

    private FragmentAdministradorEliminarProductoBinding binding;
    private EditText codigo;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAdministradorEliminarProductoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button button = binding.button4;
        codigo = binding.textView21;

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String txt_codigo = codigo.getText().toString();

                if(!txt_codigo.isEmpty() ){
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
        String parametros[]={txt_codigo};
        int cant = database.delete(ConstantesDB.NOMBRE_TABLA_ARTICULO,ConstantesDB.CAMPO_CODIGO+"=?",parametros);
        database.close();
        codigo.setText("");

        if(cant>0){
            Toast.makeText(getActivity(),"Eliminacion de Producto Exitoso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"El registro a eliminar no existe", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}