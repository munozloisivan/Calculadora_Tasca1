package edu.upc.eetac.dsa.calculadora;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaOperaciones extends AppCompatActivity {

    String tag = "Llista Operacions"; // tag que indica el ciclo de vida de la app

    List<String> historial = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llista_operacions);
        Log.d(tag, "Event onCreate()");

        String[] totalop = getIntent().getExtras().getString("Op").split(",");
        for (int i=0; i<totalop.length; i++){
            if (!totalop[i].equals("")){
                historial.add(i + 1 + " : " +totalop[i]);
            }
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,historial);
        ListView listView = (ListView) findViewById(R.id.List);
        listView.setAdapter(adapter);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Intent intres = getIntent();
        if ((requestCode==101)&&(resultCode== Activity.RESULT_OK)){
            this.historial.clear();
            setResult(1337, intres);
            finish();
        }
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
        Intent intres = getIntent();
        setResult(RESULT_CANCELED, intres);
        finish();
       // Intent inb1 = new Intent(ListaOperaciones.this, PantallaPrincipal.class);
      //  startActivity(inb1);
    }

    public void goToConfirmarBorrar(View view){
        Intent intent2 = new Intent(getApplicationContext(), ConfirmarBorrar.class);
        startActivityForResult(intent2,101);
    }
}
