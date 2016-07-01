package com.example.joeymejias.madlibs;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // get the intent that started this activity
        Intent intent = getIntent();

        // get the data from the intent
        String editText1 = intent.getStringExtra("editText1");
        String editText2 = intent.getStringExtra("editText2");
        String editText3 = intent.getStringExtra("editText3");
        String editText4 = intent.getStringExtra("editText4");
        String editText5 = intent.getStringExtra("editText5");
        String editText6 = intent.getStringExtra("editText6");

        mTextView = (TextView) findViewById(R.id.madLibResult);

        mTextView.setText("A vacation is when you take a trip to some " +
                editText1+ " with your " + editText2
                + " family. Usually, you go to some place that is near a " + editText3 +
                " or up on a " + editText4 + ". A good vacation place is one where you can ride " +
                editText5 + " or play " + editText6 +".");

        final Button button = (Button) findViewById(R.id.goBack);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                setContentView(R.layout.activity_main);
            }
        });
    }
}
