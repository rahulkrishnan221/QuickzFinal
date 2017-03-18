package com.codehex2k17.rahul.quickzfinal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class deletion extends AppCompatActivity implements View.OnClickListener {
    public ProgressDialog loading;
    Button btn;
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletion);
        btn=(Button)findViewById(R.id.btn);
        btn2=(Button)findViewById(R.id.btn2);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn.performClick();

    }
    private void deldata(){
        loading=ProgressDialog.show(this,"Deleting","please wait...",false,false);

    String url = Config.DEL_URL + finalcart.data.toString().trim();
    StringRequest stringRequest = new StringRequest( url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            loading.dismiss();
            Toast.makeText(deletion.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
            btn2.performClick();
        }
    },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(deletion.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            });

    RequestQueue requestQueue = Volley.newRequestQueue(this);
    requestQueue.add(stringRequest);
}

    @Override
    public void onClick(View v) {
        deldata();
        buttonclick();


    }
    private void buttonclick() {
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1 = new Intent(deletion.this, finalcart.class);
                startActivity(in1);
            }

});
    }
}






