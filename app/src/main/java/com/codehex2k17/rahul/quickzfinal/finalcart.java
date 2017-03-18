package com.codehex2k17.rahul.quickzfinal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class finalcart extends AppCompatActivity implements View.OnClickListener {
    private Button buttonget;
    private ListView listView;
    Button remove;
    double p;
    public static String data;
    String s;
    String q;
    Button checkout;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalcart);
        buttonclick1();
        buttonget = (Button) findViewById(R.id.buttonGet);
        buttonget.setOnClickListener(this);
        buttonget.performClick();
        listView = (ListView) findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(finalcart.this, "Item selected", Toast.LENGTH_SHORT).show();

                data = (String) arg0.getItemAtPosition(arg2);


            }
        });

    }


    private void sendRequest() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);

        StringRequest stringRequest = new StringRequest(Config.KEY_RURL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(finalcart.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json) {

        parsejson pj = new parsejson(json);
        pj.parsejson();
        TextView textView = (TextView) findViewById(R.id.textView);
        p = pj.Finalprice3;
        q = Double.toString(p);
        s = "Total Amount:\t Rs." + q;
        textView.setText(s);
        customlistview cl = new customlistview(this, parsejson.ids, parsejson.getNames(), parsejson.Finalprices);
        listView.setAdapter(cl);

    }


    @Override
    public void onClick(View v) {
        sendRequest();
        buttonclick1();
        buttonclick2();
    }


    private void buttonclick1() {
        checkout = (Button) findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2 = new Intent(finalcart.this, payment.class);
                in2.putExtra("amount", q);
                startActivity(in2);
            }
        });
    }

    private void buttonclick2() {
        remove = (Button) findViewById(R.id.remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in3 = new Intent(finalcart.this, deletion.class);

                startActivity(in3);
            }


        });
    }
}
