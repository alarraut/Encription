package com.example.vvab851.myapplication;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.content.ClipboardManager;

public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    int ban1=0;
    MyMethods anta;

    public void codificar(View view) {
        anta = new MyMethods();
        String texto,llave,mensajecod;

        Intent intent = new Intent(this, DisplayMessageActivity.class);

         //Recepcion del texto y llave
        EditText edittexto = (EditText) findViewById(R.id.editartexto);
        EditText editllave = (EditText) findViewById(R.id.editarllave);
        texto= edittexto.getText().toString();
        llave = editllave.getText().toString();

        // Envio de parametros para su codificacion
        mensajecod =anta.codifica(texto,llave);

        // Se copia mensaje codificado al portapapeles
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("simple text",mensajecod);
        clipboard.setPrimaryClip(clip);

       // Envio de mensaje codificado para su despliegue en la nueva actividad

        intent.putExtra(EXTRA_MESSAGE, mensajecod);
        startActivity(intent);
   }

    public void decodificar(View view) {

        anta = new MyMethods();
        String texto,llave, mensajedecod;

        Intent intent = new Intent(this, DisplayMessageActivity.class);

        //Recepcion del texto y llave
        EditText edittexto = (EditText) findViewById(R.id.editartexto);
        EditText editllave = (EditText) findViewById(R.id.editarllave);
        texto = edittexto.getText().toString();
        llave = editllave.getText().toString();

        // Envio de parametros para su decodificacion
        mensajedecod=anta.decodifica(texto,llave);

        // Se copia mensaje codificado al portapapeles
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("simple text",mensajedecod);
        clipboard.setPrimaryClip(clip);

        // Envio de mensaje decodificado para su despliegue en la nueva actividad
        intent.putExtra(EXTRA_MESSAGE,mensajedecod);
        startActivity(intent);
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
