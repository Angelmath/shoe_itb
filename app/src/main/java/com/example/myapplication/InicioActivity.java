package com.example.myapplication;

import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.DB.entidades.AdminSqliteOpenHelper;
import com.example.myapplication.DB.sqlite.ConstantesDB;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class InicioActivity extends AppCompatActivity {

    private EditText mail;
    private EditText contrasenia;
    private String rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_inicio);
        Button button=(Button)findViewById(R.id.button);
        mail =(EditText) findViewById(R.id.textView8);
        contrasenia = (EditText)findViewById(R.id.textView10);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(onclickSession()){
                    switchActivities();
                }
            }
        });

    }

    private void switchActivities() {

        if(rol.contains("Admin")) {
            Intent switchActivityIntent = new Intent(this, MainActivity.class);
            switchActivityIntent.putExtra("DATA_ROL_KEY", rol);
            startActivity(switchActivityIntent);
        }else{
            Intent switchActivityIntent = new Intent(this, MainActivity2.class);
            switchActivityIntent.putExtra("DATA_ROL_KEY", rol);
            startActivity(switchActivityIntent);
        }

    }

    public boolean onclickSession(){
        AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase  database = admin.getWritableDatabase();
        String text_mail = mail.getText().toString();
        String text_contrasenia = contrasenia.getText().toString();
        if(!text_mail.isEmpty() && !text_contrasenia.isEmpty()){
            Cursor fila = database.rawQuery("select "+ConstantesDB.CAMPO_NOMBRE+", "+ ConstantesDB.CAMPO_APELLIDO +", "+ ConstantesDB.CAMPO_ROL +" from "+ ConstantesDB.NOMBRE_TABLA_USUARIO + " WHERE "+ ConstantesDB.CAMPO_EMAIL +
                    "= '"+text_mail+"' and "+ ConstantesDB.CAMPO_CONSTRASENIA + " = '"+text_contrasenia+"' ", null);
            if(fila.moveToFirst()){
                Toast.makeText(this,"Bienvenido "+ fila.getString(0) +" "+ fila.getString(1), Toast.LENGTH_SHORT).show();
                rol = fila.getString(2);
                return true;
            }else{
                Toast.makeText(this,"No existe el Usuario", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Complete el campo Correo o Contraseña", Toast.LENGTH_SHORT).show();
        }
        return false;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



}