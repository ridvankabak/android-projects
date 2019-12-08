package com.example.credicard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;

public class MainActivity extends AppCompatActivity {
    CardForm cardForm;
    Button btnBuy;
    AlertDialog.Builder alertBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardForm = findViewById(R.id.card_form);
        btnBuy = findViewById(R.id.btnBuy);
        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("Sms is required on this number")
                .setup(MainActivity.this);

        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardForm.isValid()){
                    alertBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertBuilder.setTitle("Confirm before purchase");
                    alertBuilder.setMessage("Card Number: "+ cardForm.getCardNumber() + "\n"+
                            "Card expiry date: "+ cardForm.getExpirationDateEditText().getText().toString()+"\n"+
                            "Card CVV: "+cardForm.getCvv() + "\n"+
                            "Postal Code: "+ cardForm.getPostalCode() + "\n"+
                            "Phonne number: "+ cardForm.getMobileNumber());
                    alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Toast.makeText(MainActivity.this, "Thank you for purchase", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();

                }
                else{
                    Toast.makeText(MainActivity.this, "Please complete the form", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
