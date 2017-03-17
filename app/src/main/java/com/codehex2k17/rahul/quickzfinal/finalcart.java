package com.codehex2k17.rahul.quickzfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class finalcart extends AppCompatActivity {
    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalcart);
        buttonclick1();

    }
    private void buttonclick1()
    {
        checkout = (Button) findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2 = new Intent(finalcart.this,payment.class);
                startActivity(in2);
            }


        });
    }
}
