package com.shakawat.learn_volley_android.JsonObject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.shakawat.learn_volley_android.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Learn_JsonObject extends AppCompatActivity {
    ArrayList<MyJsonObject> dataList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_json_object);
        parseJsonData();
    }

    private void parseJsonData() {
        String url ="https://touhidapps.com/api/demo/jsondemoapi.php?option=2";
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson= new Gson();
                DataModel dataModel= gson.fromJson(response.toString(),DataModel.class);
                dataList.addAll(dataModel.getMyJsonObject());



///// same process---------------
//                try {
//                    JSONArray jsonArray= response.getJSONArray("MyJsonObject");
//                    for (int i= 0;i<jsonArray.length();i++){
//                        JSONObject jsonObject= jsonArray.getJSONObject(i);
//                        MyJsonObject myJsonObject= new MyJsonObject(
//                                jsonObject.getString("id"),
//                                jsonObject.getString("name"),
//                                jsonObject.getString("details"),
//                                jsonObject.getString("fileName"),
//                                jsonObject.getString("baseUrl"));
//                        dataList.add(myJsonObject);
//                        Log.d("TAG", "onResponse: "+dataList);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", "onErrorResponse: "+error);

            }
        });
        MySingleTon.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}