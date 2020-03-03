package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

     RadioGroup radioGroup, radioGroup2, radioGroup3;
     RadioButton radioButton, radioButton2, radioButton3;
     EditText message;
     Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

    }

    public void addListenerOnButton(){

        radioGroup = (RadioGroup) findViewById(R.id.shape);
        radioGroup2 = (RadioGroup) findViewById(R.id.flavor);
        radioGroup3 = (RadioGroup) findViewById(R.id.topping);
        final EditText greetings = (EditText) findViewById(R.id.greetings);

        btnSubmit = findViewById(R.id.submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            String message = "";

            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);

                int selectedId2 = radioGroup2.getCheckedRadioButtonId();
                radioButton2 = (RadioButton) findViewById(selectedId2);

                int selectedId3 = radioGroup3.getCheckedRadioButtonId();
                radioButton3 = (RadioButton) findViewById(selectedId3);

                String msg = greetings.getText().toString();

                message = "Your order is " +radioButton.getText().toString() +" "+ radioButton2.getText().toString() +" cake with "+
                        radioButton3.getText().toString() +" toppings " +
                        "\n\nMessage: "+ msg;


                AlertDialog.Builder alertDialogBuilder  = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage(message);
                alertDialogBuilder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();



            }
     });

    }

}
