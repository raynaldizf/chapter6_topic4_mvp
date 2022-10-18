package com.example.chapter6_topic4_mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter6_topic4_mvp.databinding.ActivityMainBinding
import com.example.chapter6_topic4_mvp.model.ResponseDataCarItem
import com.example.chapter6_topic4_mvp.presenter.CarPresenter
import com.example.chapter6_topic4_mvp.presenter.CarView
import com.example.chapter6_topic4_mvp.view.AdapterCar

class MainActivity : AppCompatActivity(), CarView {
    lateinit var binding : ActivityMainBinding
    lateinit var presenterCar : CarPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenterCar = CarPresenter(this)
        presenterCar.getDataCar()
    }

    override fun onSuccess(pesan: String, cars: List<ResponseDataCarItem>) {
        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.rvList.adapter = AdapterCar(cars)
    }

    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
    }
}