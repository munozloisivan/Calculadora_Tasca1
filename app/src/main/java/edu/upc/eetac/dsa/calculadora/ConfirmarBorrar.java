package edu.upc.eetac.dsa.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ConfirmarBorrar extends AppCompatActivity {

    String tag = "ConfirmarBorrar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_borrar);
        Log.d(tag, "Event onCreate()");

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

    public void onClicksibutton(View view){
        Intent intres = getIntent();
        setResult(RESULT_OK, intres);
        finish();
    }


    public void onClicknobutton(View view){

        Intent intres = getIntent();
      setResult(RESULT_CANCELED, intres);
        finish();
      //  Intent inb1 = new Intent(ConfirmarBorrar.this,ListaOperaciones.class);
       // startActivity(inb1);

    }
}
