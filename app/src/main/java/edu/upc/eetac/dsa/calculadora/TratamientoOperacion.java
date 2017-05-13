package edu.upc.eetac.dsa.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static edu.upc.eetac.dsa.calculadora.R.id.num1;
import static edu.upc.eetac.dsa.calculadora.R.id.operseleccionada;
import static edu.upc.eetac.dsa.calculadora.R.id.text;

public class TratamientoOperacion extends AppCompatActivity {

    String tag = "TratamientoOperacion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamiento_operacion);
        Log.d(tag, "Event onCreate()");

       //recibo los datos del intent
       // String seleccion = getIntent().getExtras().getString("selected");

        String seleccion = getIntent().getExtras().getString("sel");
        //compruebo que llega bien el texto pasado
       //Toast.makeText(getApplicationContext(),seleccion, Toast.LENGTH_SHORT).show();

        //se lo pongo en el TextView
        TextView textView = (TextView) findViewById(operseleccionada);
        textView.setText(seleccion);
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
        Intent intres = getIntent();
        setResult(RESULT_CANCELED, intres);
        finish();
    }

    public void funcionModificar(View view){
        //retornar datos de la operacion para refrescarlos en la pantalla principal
        Intent intres = getIntent();
        TextView textView = (TextView) findViewById(operseleccionada);
        String operacion = textView.getText().toString();
        intres.putExtra("val", operacion);
        setResult(RESULT_OK, intres);
        finish();
    }
}

