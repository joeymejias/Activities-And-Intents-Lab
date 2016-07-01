package com.example.joeymejias.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText mEditText1;
    EditText mEditText2;
    EditText mEditText3;
    EditText mEditText4;
    EditText mEditText5;
    EditText mEditText6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText) findViewById(R.id.adjective1);
        mEditText2 = (EditText) findViewById(R.id.adjective2);
        mEditText3 = (EditText) findViewById(R.id.noun1);
        mEditText4 = (EditText) findViewById(R.id.noun2);
        mEditText5 = (EditText) findViewById(R.id.animal);
        mEditText6 = (EditText) findViewById(R.id.game);

        final List<EditText> madLibs = new ArrayList<>();
        madLibs.add(mEditText1);
        madLibs.add(mEditText2);
        madLibs.add(mEditText3);
        madLibs.add(mEditText4);
        madLibs.add(mEditText5);
        madLibs.add(mEditText6);

        final Button button = (Button) findViewById(R.id.madLibButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                //Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();

                //Create boolean and set to true
                Boolean allFilled = true;

                //Iterate through each madlib
                for(EditText madlib : madLibs){
                    //If a madlib is empty allFilled set to false and startActivity() does not run
                    if(madlib.getText().toString().length() <= 0){
                        madlib.setError("Please enter text");
                        //Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
                        allFilled = false;
                    }
                }
                if (allFilled) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("editText1", mEditText1.getText().toString());
                    intent.putExtra("editText2", mEditText2.getText().toString());
                    intent.putExtra("editText3", mEditText3.getText().toString());
                    intent.putExtra("editText4", mEditText4.getText().toString());
                    intent.putExtra("editText5", mEditText5.getText().toString());
                    intent.putExtra("editText6", mEditText6.getText().toString());
                    //intent.putStringArrayListExtra(madLibs);
                    startActivity(intent);
                    //Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
