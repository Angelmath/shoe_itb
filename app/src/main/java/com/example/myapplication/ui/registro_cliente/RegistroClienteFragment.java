package com.example.myapplication.ui.registro_cliente;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.DB.entidades.AdminSqliteOpenHelper;
import com.example.myapplication.DB.sqlite.ConstantesDB;
import com.example.myapplication.databinding.FragmentRegistroClienteBinding;
import com.example.myapplication.ui.administrador.AdministradorViewModel;

public class RegistroClienteFragment extends Fragment {

    private FragmentRegistroClienteBinding binding;

    private EditText nombre, apellido, correo, contrasenia;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AdministradorViewModel galleryViewModel =
                new ViewModelProvider(this).get(AdministradorViewModel.class);

        binding = FragmentRegistroClienteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button button = binding.button4;
        nombre = binding.textView21;
        apellido = binding.textView22;
        correo = binding.textView23;
        contrasenia = binding.textView24;
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String txt_nombre = nombre.getText().toString();
                String txt_apellido = apellido.getText().toString();
                String txt_correo = correo.getText().toString();
                String txt_contrasenia = contrasenia.getText().toString();
                if(!txt_nombre.isEmpty() && !txt_contrasenia.isEmpty() && !txt_apellido.isEmpty() && !txt_correo.isEmpty()){
                    onCickRegistarSQL(txt_nombre, txt_apellido, txt_correo, txt_contrasenia);
                }else{
                    Toast.makeText(getActivity(),"Complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    public void onCickRegistarSQL(String txt_nombre, String txt_apellido, String txt_correo, String txt_contrasenia){
        AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(getActivity(),"administracion",null,1);
        SQLiteDatabase database = admin.getWritableDatabase();
        String query = "insert into "+ ConstantesDB.NOMBRE_TABLA_USUARIO +" ( "+ConstantesDB.CAMPO_NOMBRE+", "+ConstantesDB.CAMPO_APELLIDO+", "+ConstantesDB.CAMPO_EMAIL+", "+ConstantesDB.CAMPO_CONSTRASENIA+", "+ConstantesDB.CAMPO_ROL+" ) "
                + " values ( '"+ txt_nombre +"', '"+txt_apellido+"', '"+txt_correo+"', '"+txt_contrasenia+"','Cliente' )" ;
        database.execSQL(query);
        database.close();
        nombre.setText("");
        apellido.setText("");
        correo.setText("");
        contrasenia.setText("");
        Toast.makeText(getActivity(),"Registro de Usuario Exitoso", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}