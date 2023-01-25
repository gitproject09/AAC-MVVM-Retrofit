package com.sopan.aac.retrofit_mvvm.view_model;

import android.app.Application;
import android.util.Log;

import com.sopan.aac.retrofit_mvvm.repository.MemberListRepository;
import com.sopan.aac.retrofit_mvvm.response.MemberListResponse;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MemberListViewModel extends AndroidViewModel {

    private MemberListRepository memberListRepository;
    private LiveData<MemberListResponse> memberListResponseLiveData;

    public MemberListViewModel(@NonNull Application application) {
        super(application);
        Log.d("MemberListViewModel", "WhenCalled");
        memberListRepository = new MemberListRepository();
    }

    public void makeApiCall(String mobileNum){
        this.memberListResponseLiveData = memberListRepository.getMemberList(mobileNum);
    }

    public LiveData<MemberListResponse> getMemberListResponseLiveData() {
        Log.d("MemberListViewModel", "get Data");
        return memberListResponseLiveData;
    }
}
