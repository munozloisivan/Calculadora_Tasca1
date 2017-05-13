package edu.upc.eetac.dsa.calculadora;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        for (int i = 0; i < totalop.length; i++) {
            if (!totalop[i].equals("")) {
                historial.add(i + 1 + " : " + totalop[i]);
            }
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, historial);
        ListView listView = (ListView) findViewById(R.id.List);
        listView.setAdapter(adapter);


        //prueba para la ultima parte
        // si que funciona, me selecciona lo que hay en cada fila
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //para mostrar el valor de la fila seleccionada hago un toast a modo de comprobacion
                //Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

                //vamos a llamar a la UI TratamientoOperacion
                //para pasarle dicha fila y alli tratarla como se deba
                String sel = ((TextView) view).getText().toString();
                Intent intent = new Intent(getApplicationContext(), TratamientoOperacion.class);
                //System.out.println(sel);
                intent.putExtra("sel",sel);
                startActivityForResult(intent,105);

               // goToTratamientoOperacion(view, ((TextView) view).getText().toString());
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        Bundle res = data.getExtras();


      //  Intent intres = getIntent();
        if ((requestCode==101)&&(resultCode== Activity.RESULT_OK)){
            this.historial.clear();
            setResult(1337, data);
            finish();
        }

        //para el MODIFICAR
        else if((requestCode==105)&&(resultCode==Activity.RESULT_OK)){
            //aqui si que entra
            String stres1 = res.getString("tratado");
            System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSS"+res.getString("tratado"));       //lo que llega es NULL

            data.putExtra("val2",getIntent().getExtras().getString("tratado"));
            setResult(1400, data);
            finish();
        }

        //para el BORRAR
        else if ((requestCode == 105) && (resultCode == Activity.RESULT_CANCELED)){
                System.out.println("HA ENTRADO EN BORARA :");
                String res2 = data.getExtras().getString("borrar");
            for (int i=0; i<historial.size();i++){
                if (historial.get(i).equals(res)){
                    historial.remove(i);
                }
            }
            //recargar la lista
            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, historial);
            ListView listView = (ListView) findViewById(R.id.List);
            listView.setAdapter(adapter);
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

    public void goToTratamientoOperacion(View view, String seleccion){

       /* Intent intent3 = new Intent(getApplicationContext(), TratamientoOperacion.class);
        //añado info a pasar a la siguiente vista
        intent3.putExtra("selected", seleccion);
        startActivityForResult(intent3, 105);
        */


    }
}
