package com.example.chapter6_topic4_mvp.presenter

import com.example.chapter6_topic4_mvp.model.ResponseDataCarItem
import com.example.chapter6_topic4_mvp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarPresenter(val carView : CarView) {
    fun getDataCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<ResponseDataCarItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataCarItem>>,
                    response: Response<List<ResponseDataCarItem>>
                ) {
                    if (response.isSuccessful) {
                        carView.onSuccess(response.message(), response.body()!!)
                    } else {
                        carView.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                    carView.onError(t.message!!)
                }

            })
    }
}