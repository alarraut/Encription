package com.example.vvab851.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(20);

        //Se muestra el mensaje
        textView.setText("Tu mensaje se ha copiado al portapapeles y es el siguiente: \n\n " + message);


        // Set the text view as the activity layout
        setContentView(textView);
    }


}