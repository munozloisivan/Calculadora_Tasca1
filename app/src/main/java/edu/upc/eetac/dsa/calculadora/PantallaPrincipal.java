package edu.upc.eetac.dsa.calculadora;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static edu.upc.eetac.dsa.calculadora.R.id.num1;


public class PantallaPrincipal extends AppCompatActivity {

    String tag = "PantallaPrincipal"; // tag que indica el ciclo de vida de la app
    String operacio;
    StringBuilder historia = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        Log.d(tag, "Event onCreate()");
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle result = data.getExtras();

        if (resultCode == 1400){

            System.out.println("HELOOOO BEBIIIISSS XDDDD");
            String resultado = data.getExtras().getString("tratado");
            System.out.println("RESULTADOOOOOOOOOOOOOOOO"+resultado);
            
        }


        else if ((requestCode == 100) && (resultCode == Activity.RESULT_OK)) {

        }
        //prueba es posible que se tenga que borrar

        else if (resultCode == 1337) {
            this.historia.delete(0, historia.length());
        } else if (resultCode == 1500) {
            //this.historia.deleteCharAt();
        } else if ((requestCode == 105) && (resultCode == 1400)) {

            String stres2 = result.getString("tratado");
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA: "+stres2);

            {//  Toast.makeText(getApplicationContext(),"ha llegado", Toast.LENGTH_SHORT).show();

                // Toast.makeText(getApplicationContext(),"va",Toast.LENGTH_SHORT).show();
             //   String valo = data.getExtras().getString("val2");
               // Toast.makeText(getApplicationContext(), valo, Toast.LENGTH_SHORT).show();

                // EditText numero1 = (EditText) findViewById(num1);
                // EditText numero2 = (EditText) findViewById(num2);
                //  EditText resultado = (EditText) findViewById(res);
                //  RadioGroup rg = (RadioGroup) findViewById(radioGroup);

            }
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

        EditText editText = (EditText) findViewById(num1);
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
            EditText editTextnum1 = (EditText) findViewById(num1);
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

            historia.append(getOperation(num1, num2, operacio.toString(), sol));

        } catch (Exception e) {
            //Llancem un TOAST com a missatge per indicar que falta un numero per insertar.
            Context context = getApplicationContext();
            CharSequence text = "Cal indicar els dos valors numèrics";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public String getOperation(float value1, float value2, String operation, float result){
        StringBuilder sb = new StringBuilder();
        sb.append(value1);
        sb.append(operation);
        sb.append(value2);
        sb.append("=");
        sb.append(result);
        sb.append(",");
        return sb.toString();
    }


    public void goToListaOperaciones(View view){
        //pasar a la vista Lista de Operaciones
        Intent inb1 = new Intent(getApplicationContext(),ListaOperaciones.class);
        //añadir la info a pasar a la otra vista
        inb1.putExtra("Op", historia.toString());
        //iniciar la otra actividad (vista)
        startActivityForResult(inb1,100);
    }

}
