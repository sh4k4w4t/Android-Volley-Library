package com.shakawat.learn_volley_android.JsonArrayRequest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.shakawat.learn_volley_android.MySingleTonPattern;
import com.shakawat.learn_volley_android.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonArrayRequest_Activity extends AppCompatActivity {
    List<DataModel> allProducts= new ArrayList<>();
    ArrayAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_array_request);
        this.setTitle("Json Array Request");

        recyclerView= findViewById(R.id.recycleviewArray);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        String url= "https://touhidapps.com/api/demo/jsondemoapi.php?option=3";

        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i=0;i<response.length();i++){
                        Log.d("TAG", "onResponse: "+response.getJSONObject(i));
                        DataModel dataModel= new DataModel(response.getJSONObject(i).getString("id"),
                                response.getJSONObject(i).getString("name"),
                                response.getJSONObject(i).getString("details"),
                                response.getJSONObject(i).getString("fileName"),
                                response.getJSONObject(i).getString("baseUrl"));
                        allProducts.add(dataModel);
                    }
                }catch (JSONException jsonException){
                    Log.d("error", "onResponse: "+jsonException);
                }

                adapter= new ArrayAdapter(JsonArrayRequest_Activity.this,allProducts);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAGArray", "onErrorResponse: "+error);
            }
        });
        MySingleTonPattern.getInstance(this).addToRequestQueue(jsonArrayRequest);
    }
}