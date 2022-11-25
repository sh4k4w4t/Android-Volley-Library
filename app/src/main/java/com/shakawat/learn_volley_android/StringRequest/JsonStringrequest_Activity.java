package com.shakawat.learn_volley_android.StringRequest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shakawat.learn_volley_android.R;

public class JsonStringrequest_Activity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_stringrequest);
        textView= findViewById(R.id.textStringView);
        this.setTitle("Json String Request");

        String url="https://touhidapps.com/api/demo/jsondemoapi.php?option=1";

        RequestQueue queue= Volley.newRequestQueue(this);

        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(String response) {
                textView.setText("Response :  "+response);
            }
        }, new Response.ErrorListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("Error: "+error);
            }
        });
        queue.add(stringRequest);
    }
}