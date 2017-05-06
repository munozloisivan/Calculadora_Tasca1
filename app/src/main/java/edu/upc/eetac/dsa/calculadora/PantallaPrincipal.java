package edu.upc.eetac.dsa.calculadora;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaPrincipal extends AppCompatActivity {

    String tag = "Events"; // tag que indica el ciclo de vida de la app
    String operacio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
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

    //Funció per saber quina de les opcions del Radiogroup es la que s'ha triat
    public void onRadioButtonClicked(View view) {
        // verificar si el radiobutton esta checked
        boolean checked = ((RadioButton) view).isChecked();
        operacio = null;
        // Check de quin ha sigut el que s'ha clicat
        switch (view.getId()) {
            case R.id.division:
                if (checked)
                    // divisió
                    operacio = "/";
                break;
            case R.id.multiplicacion:
                if (checked)
                    // multiplicació
                    operacio = "*";
                break;
            case R.id.resta:
                if (checked)
                    // resta
                    operacio = "-";
                break;
            case R.id.suma:
                if (checked)
                    // suma
                    operacio = "+";
                break;
        }
        Log.d(tag, "operacio: " +operacio);
    }

    public void setValuesToCero(View view){

        EditText editText = (EditText) findViewById(R.id.num1);
        editText.setText("0");
        EditText editText2 = (EditText) findViewById(R.id.num2);
        editText2.setText("0");
        EditText editText3 = (EditText) findViewById(R.id.res);
        editText3.setText("0");

        Context context = getApplicationContext();
        CharSequence text = "valores borrados";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    public void getOperacion(View view){

        try {
            EditText editTextnum1 = (EditText) findViewById(R.id.num1);
            float num1 = Float.parseFloat(editTextnum1.getText().toString());
            Log.d(tag, "num1: "+num1); //verificacio de la correcta obtenció dels numeros
            EditText editTextnum2 = (EditText) findViewById(R.id.num2);
            float num2 = Float.parseFloat(editTextnum2.getText().toString());
            Log.d(tag, "num1: "+num2);

            //realitzem l'operació corresponent en funcio de l'opcio (operacio) del radiobutton seleccionada
            float sol = 0;
            if ("/".equals(operacio)) {
                sol = num1 / num2;
            }
            if ("*".equals(operacio)) {
                sol = num1 * num2;
            }
            if ("-".equals(operacio)) {
                sol = num1 - num2;
            }
            if ("+".equals(operacio)) {
                sol = num1 + num2;
            }
            Log.d(tag, "Sol: "+sol);
            EditText editTextRes = (EditText) findViewById(R.id.res);
            editTextRes.setText("" + sol);
        } catch (Exception e) {
            //Llancem un TOAST com a missatge per indicar que falta un numero per insertar.
            //No ho fem en cas de que sigui decimal ja que num1 i num dos estan declarats de tipus int
            //i al textview que explica l'aplicació ja diu que han de introduir nombres enters

            Context context = getApplicationContext();
            CharSequence text = "Cal indicar els dos valors numèrics";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }

    }


}
