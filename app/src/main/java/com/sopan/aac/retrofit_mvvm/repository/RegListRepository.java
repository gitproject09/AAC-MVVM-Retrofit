package com.sopan.aac.retrofit_mvvm.repository;

import android.util.Log;

import com.sopan.aac.retrofit_mvvm.response.RegListResponse;
import com.sopan.aac.retrofit_mvvm.retrofit.ApiService;
import com.sopan.aac.retrofit_mvvm.retrofit.RetrofitRequest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegListRepository {
    private static final String TAG = RegListRepository.class.getSimpleName();
    private ApiService apiRequest;

    public RegListRepository() {
        apiRequest = RetrofitRequest.getAnotherRetrofitInstance().create(ApiService.class);
    }

    public LiveData<RegListResponse> getRegListFromDB(String mobile) {

        final MutableLiveData<RegListResponse> data = new MutableLiveData<>();

        apiRequest.getRegList(mobile)
                .enqueue(new Callback<>() {

                    @Override
                    public void onResponse(Call<RegListResponse> call, Response<RegListResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.setValue(response.body());
                            Log.d(TAG, "Reg total Size:: " + response.body().getRegLists().size());
                            Log.d(TAG, "Reg Status:: " + response.body().getStatus());
                        }
                    }

                    @Override
                    public void onFailure(Call<RegListResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
