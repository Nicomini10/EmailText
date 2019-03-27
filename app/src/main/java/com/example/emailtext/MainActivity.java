package com.example.emailtext;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText oggettoEmail;
    EditText textEmail;
    Button buttonInvia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        oggettoEmail = (EditText) findViewById(R.id.editText2);
        textEmail = (EditText) findViewById(R.id.editText);
        buttonInvia = (Button) findViewById(R.id.button);
        buttonInvia.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, oggettoEmail.getText().toString());


                emailIntent.putExtra(emailIntent.EXTRA_EMAIL, new String[]{"nicominichillo@hotmail.com"});

                emailIntent.putExtra(Intent.EXTRA_TEXT, textEmail.getText());

                emailIntent.putExtra(emailIntent.EXTRA_STREAM, Uri.fromFile(new File("/path/to/file")));
                emailIntent.setType("text/plain");

                startActivity(emailIntent);



            }
        });

    }
}
