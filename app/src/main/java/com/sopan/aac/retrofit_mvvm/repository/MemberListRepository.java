package com.sopan.aac.retrofit_mvvm.repository;

import android.util.Log;

import com.sopan.aac.retrofit_mvvm.response.MemberListResponse;
import com.sopan.aac.retrofit_mvvm.retrofit.ApiService;
import com.sopan.aac.retrofit_mvvm.retrofit.RetrofitRequest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemberListRepository {
    private static final String TAG = MemberListRepository.class.getSimpleName();
    private ApiService apiRequest;

    public MemberListRepository() {
        apiRequest = RetrofitRequest.getAnotherRetrofitInstance().create(ApiService.class);
    }

    public LiveData<MemberListResponse> getMemberList(String mobile) {

        final MutableLiveData<MemberListResponse> data = new MutableLiveData<>();

        apiRequest.getMemberList(mobile)
                .enqueue(new Callback<>() {

                    @Override
                    public void onResponse(Call<MemberListResponse> call, Response<MemberListResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.setValue(response.body());
                            Log.d(TAG, "Member total Size:: " + response.body().getMemberLists().size());
                            Log.d(TAG, "Member Status:: " + response.body().getStatus());
                        }
                    }

                    @Override
                    public void onFailure(Call<MemberListResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
