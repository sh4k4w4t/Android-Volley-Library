package com.shakawat.learn_volley_android.JsonObjectRequest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.shakawat.learn_volley_android.MySingleTonPattern;
import com.shakawat.learn_volley_android.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonObjectRequest_Activity extends AppCompatActivity {
    ArrayAdapterForObject adapter;
    RecyclerView recyclerView;
    List<MyJsonObject> allProducts= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_objectrequest);
        this.setTitle("Json Object Request");
        recyclerView= findViewById(R.id.recycleviewObjectRequest);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        String url="https://touhidapps.com/api/demo/jsondemoapi.php?option=2";
        JsonObjectRequest newObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("TAG", "onResponse: "+response);
                try {
                    JSONArray jsonArray= response.getJSONArray("MyJsonObject");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject= jsonArray.getJSONObject(i);
                        MyJsonObject myJsonObject= new MyJsonObject(
                                jsonObject.getString("id"),
                                jsonObject.getString("name"),
                                jsonObject.getString("details"),
                                jsonObject.getString("fileName"),
                                jsonObject.getString("baseUrl"));
                        allProducts.add(myJsonObject);
                    }
                }catch (JSONException e){
                    Log.d("TAG", "onResponse: "+e);
                }
                adapter= new ArrayAdapterForObject(JsonObjectRequest_Activity.this,allProducts);
                recyclerView.setAdapter(adapter);
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