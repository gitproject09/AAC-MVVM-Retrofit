package com.sopan.aac.retrofit_mvvm.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sopan.aac.retrofit_mvvm.model.Article;
import com.sopan.aac.retrofit_mvvm.model.MemberList;

import java.util.List;

public class MemberListResponse {

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private List<MemberList> memberLists = null;

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

    public List<MemberList> getMemberLists() {
        return memberLists;
    }

    public void setMemberLists(List<MemberList> memberLists) {
        this.memberLists = memberLists;
    }
}
