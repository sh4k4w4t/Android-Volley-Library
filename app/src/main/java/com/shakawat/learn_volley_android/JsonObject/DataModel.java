package com.shakawat.learn_volley_android.JsonObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModel {
    @SerializedName("MyJsonObject")
    @Expose
    private List<MyJsonObject> myJsonObject = null;

    public List<MyJsonObject> getMyJsonObject() {
        return myJsonObject;
    }

    public void setMyJsonObject(List<MyJsonObject> myJsonObject) {
        this.myJsonObject = myJsonObject;
    }

}