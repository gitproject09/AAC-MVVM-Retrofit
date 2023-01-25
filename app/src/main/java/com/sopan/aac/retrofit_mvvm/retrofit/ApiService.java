package com.sopan.aac.retrofit_mvvm.retrofit;

import com.sopan.aac.retrofit_mvvm.response.ArticleResponse;
import com.sopan.aac.retrofit_mvvm.response.MemberListResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @GET("v2/everything/")
    Call<ArticleResponse> getMovieArticles(@Query("q") String query, @Query("apikey") String apiKey);

    @FormUrlEncoded
    @POST("member/member_list.php")
    Call<MemberListResponse> getMemberList(@Field("mobile") String mobile);

}
