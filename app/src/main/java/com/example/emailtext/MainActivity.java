package com.example.emailtext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mytext;
    Button invia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mytext = (EditText) findViewById(R.id.editText);
        invia = (Button) findViewById(R.id.button);
        invia.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/html");
                emailIntent.putExtra(Intent.EXTRA_TITLE, "My Title");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My Subject");

                emailIntent.putExtra(Intent.EXTRA_TEXT, mytext.getText());

                startActivity(emailIntent);



            }
        });

    }
}