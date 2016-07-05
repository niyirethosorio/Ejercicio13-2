package com.example.claudia.ejercicio13_2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
    }

    public void grabar(View view){
        String nombre=et1.getText().toString();
        String datos=et2.getText().toString();
        SharedPreferences preferences=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(nombre,datos);
        editor.commit();
        Toast.makeText(this, "Datos grabados", Toast.LENGTH_SHORT).show();
    }

    public  void recuperar(View view){
        String nombre=et1.getText().toString();
        SharedPreferences preferences=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String d=preferences.getString(nombre,"");
        if (d.length()==0){
            Toast.makeText(this, "NO EXISTE DICHO NOMBRE EN LA AGENDA", Toast.LENGTH_SHORT).show();

        }
        else {
            et2.setText(d);
        }
    }
}

