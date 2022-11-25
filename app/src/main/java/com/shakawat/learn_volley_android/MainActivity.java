package com.shakawat.learn_volley_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shakawat.learn_volley_android.JsonArrayRequest.JsonArrayRequest_Activity;
import com.shakawat.learn_volley_android.JsonObjectRequest.JsonObjectRequest_Activity;
import com.shakawat.learn_volley_android.StringRequest.JsonStringrequest_Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void JsonobjectRequest(View view) {
        startActivity(new Intent(MainActivity.this, JsonObjectRequest_Activity.class));
    }

    public void stringRequest(View view) {
        startActivity(new Intent(MainActivity.this, JsonStringrequest_Activity.class));
    }

    public void JsonArrayRequest(View view) {
        startActivity(new Intent(MainActivity.this, JsonArrayRequest_Activity.class));
    }
}