package com.sopan.aac.retrofit_mvvm.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sopan.aac.retrofit_mvvm.model.RegList;

import java.util.List;

public class RegListResponse {

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private List<RegList> regLists = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<RegList> getRegLists() {
        return regLists;
    }

    public void setRegLists(List<RegList> regLists) {
        this.regLists = regLists;
    }
}
