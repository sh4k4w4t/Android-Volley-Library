package com.shakawat.learn_volley_android.JsonArrayRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("fileName")
    @Expose
    private String fileName;
    @SerializedName("baseUrl")
    @Expose
    private String baseUrl;

    public DataModel() {
    }

    public DataModel(String id, String name, String details, String fileName, String baseUrl) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.fileName = fileName;
        this.baseUrl = baseUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}