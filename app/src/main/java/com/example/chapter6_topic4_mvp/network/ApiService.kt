package com.example.chapter6_topic4_mvp.network

import com.example.chapter6_topic4_mvp.model.ResponseDataCarItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("admin/car")
    fun getAllCar(): Call<List<ResponseDataCarItem>>
}