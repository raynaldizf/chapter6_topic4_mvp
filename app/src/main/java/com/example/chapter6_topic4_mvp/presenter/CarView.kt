package com.example.chapter6_topic4_mvp.presenter

import com.example.chapter6_topic4_mvp.model.ResponseDataCarItem

interface CarView {
    fun onSuccess(pesan: String, cars: List<ResponseDataCarItem>)
    fun onError(pesan: String)
}