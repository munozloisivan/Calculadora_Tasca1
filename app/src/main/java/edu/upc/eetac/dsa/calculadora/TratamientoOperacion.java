package edu.upc.eetac.dsa.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TratamientoOperacion extends AppCompatActivity {

    String tag = "TratamientoOperacion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamiento_operacion);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "Event onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "Event onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "Event onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "Event onStop()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "Event onRestart()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "Event onDestroy()");

    }

    public void funcionBorrar(View view){

        //borrar operacion del historial


        //volver a la UI Lista de Operaciones
        Intent inb1 = new Intent(TratamientoOperacion.this, ListaOperaciones.class);
        startActivity(inb1);
    }

    public void funcionModificar(View view){

        //volver a la UI Pantalla principal
        Intent intent = new Intent(TratamientoOperacion.this, PantallaPrincipal.class);
        startActivity(intent);

        //retornar datos de la operacion para refrescarlos en la pantalla principal



    }
}
