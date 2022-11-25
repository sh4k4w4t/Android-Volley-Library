package com.shakawat.learn_volley_android.JsonObjectRequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.shakawat.learn_volley_android.MySingleTonPattern;
import com.shakawat.learn_volley_android.R;

import org.json.JSONObject;

public class JsonObjectRequest_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_objectrequest);
        this.setTitle("Json Object Request");

        String url="https://touhidapps.com/api/demo/jsondemoapi.php?option=2";
        JsonObjectRequest newObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("TAG", "onResponse: "+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", "onErrorResponse: "+error);
            }
        });
        MySingleTonPattern.getInstance(JsonObjectRequest_Activity.this).addToRequestQueue(newObjectRequest);
    }
}