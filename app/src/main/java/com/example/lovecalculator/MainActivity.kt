package com.example.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.lovecalculator.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()

    }

    private fun initClickers() {
     with(binding){
         calculateBtn.setOnClickListener(){

             RetrofitService().api.percentageNames(
                 firstNameED.text.toString(),
                 secondNameED.text.toString()
             ).enqueue(object : retrofit2.Callback<LoveModel>{
                 override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                     Log.e("ololo","onResponse: ${response.body()}")
                 }

                 override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                     Log.e("ololo","onFailure: ${t.message}")
                 }

             })
         }
     }
    }
}