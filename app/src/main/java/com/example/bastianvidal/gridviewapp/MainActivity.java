package com.example.bastianvidal.gridviewapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaracion de variables
    private EditText edtnombre,edtdesc,edtprecio,edtimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instancias XML a JAVA
        edtnombre = findViewById(R.id.nombre);
        edtdesc = findViewById(R.id.desc);
        edtprecio = findViewById(R.id.precio);
        edtimg = findViewById(R.id.img);
    }

    public void verInventario(View view){
        Intent intent = new Intent(this,Inventario.class);
        startActivity(intent);
    }

    public void agregar (View view){
        HelperBD helperBD = new HelperBD(this);
        SQLiteDatabase db = helperBD.getWritableDatabase();
        try {


            ContentValues values = new ContentValues();
            values.put("nombre", edtnombre.getText().toString());
            values.put("descripcion", edtdesc.getText().toString());
            values.put("precio", Integer.parseInt(edtprecio.getText().toString().trim()));
            values.put("nombre_img", edtimg.getText().toString().trim());

            long newid  = db.insert("productos", null, values);

            Toast.makeText(this,"Se ha insertado el producto con ID "+newid,Toast.LENGTH_LONG).show();

            db.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Método encargado de eliminar los registros de la tabla producto
    public void limpiarDatos(View view){
        try {
            HelperBD helperBD = new HelperBD(this);
            SQLiteDatabase db = helperBD.getReadableDatabase();
            db.delete("productos",null,null);
            Toast.makeText(this,"Se han eliminado los registros de la tabla productos",Toast.LENGTH_LONG).show();
            db.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
