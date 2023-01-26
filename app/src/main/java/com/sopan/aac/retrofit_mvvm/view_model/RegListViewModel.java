package com.sopan.aac.retrofit_mvvm.view_model;

import android.app.Application;
import android.util.Log;

import com.sopan.aac.retrofit_mvvm.repository.RegListRepository;
import com.sopan.aac.retrofit_mvvm.response.RegListResponse;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class RegListViewModel extends AndroidViewModel {

    private RegListRepository regListRepository;
    private LiveData<RegListResponse> regListResponseLiveData;

    public RegListViewModel(@NonNull Application application) {
        super(application);
        Log.d("RegListViewModel", "WhenCalled");
        regListRepository = new RegListRepository();
    }

    public void makeApiCall(String mobileNum){
        this.regListResponseLiveData = regListRepository.getRegListFromDB(mobileNum);
    }

    public LiveData<RegListResponse> getRegListResponseLiveData() {
        Log.d("RegListViewModel", "get Data");
        return regListResponseLiveData;
    }
}
