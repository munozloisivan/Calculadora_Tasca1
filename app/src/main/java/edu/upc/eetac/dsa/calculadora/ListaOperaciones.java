package edu.upc.eetac.dsa.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ListaOperaciones extends AppCompatActivity {

    String tag = "Llista Operacions"; // tag que indica el ciclo de vida de la app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llista_operacions);
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

    public void goToPantallaPrincipal(View view){
        Intent inb1 = new Intent(ListaOperaciones.this, PantallaPrincipal.class);
        startActivity(inb1);
    }

    public void goToConfirmarBorrar(View view){
        Intent intent2 = new Intent(ListaOperaciones.this, ConfirmarBorrar.class);
        startActivity(intent2);
    }
}
