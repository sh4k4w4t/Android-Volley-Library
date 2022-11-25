package com.shakawat.learn_volley_android.JsonObjectRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainModel {

    @SerializedName("MyJsonObject")
    @Expose
    private List<MyJsonObject> myJsonObject = null;

    public MainModel() {
    }

    public MainModel(List<MyJsonObject> myJsonObject) {
        this.myJsonObject = myJsonObject;
    }

    public List<MyJsonObject> getMyJsonObject() {
        return myJsonObject;
    }

    public void setMyJsonObject(List<MyJsonObject> myJsonObject) {
        this.myJsonObject = myJsonObject;
    }
}
