package com.cos.retrofit2movieapp.service;

import com.cos.retrofit2movieapp.model.Movie;
import com.cos.retrofit2movieapp.model.ResponseDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieService {

    @GET("api/movie")
    Call<ResponseDto<List<Movie>>> findAll();

    @DELETE("api/movie/{id}")
    Call<ResponseDto> deleteById(@Path("id")long id);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://172.29.16.1:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
