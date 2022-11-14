package com.shakawat.learn_volley_android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shakawat.learn_volley_android.JsonObject.Learn_JsonObject;

public class Learn_StringRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_string_request);

        TextView textView= findViewById(R.id.textView);

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String url= "https://www.google.com";

        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(String response) {
                textView.setText("Success");
            }
        }, new Response.ErrorListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("Error");
            }
        });
        requestQueue.add(stringRequest);
    }

    public void JsonObject(View view) {
        startActivity(new Intent(getApplicationContext(), Learn_JsonObject.class));
    }
}