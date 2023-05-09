package com.example.lovecalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.lovecalculator.LoveModel
import com.example.lovecalculator.LoveViewModel
import com.example.lovecalculator.RetrofitService
import com.example.lovecalculator.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val viewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()

    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener() {
                viewModel.liveLove(firstNameED.text.toString(), secondNameED.text.toString())
                    .observe(this@MainActivity) { LoveModel ->

                        Log.e("ololo", "initClickers:${LoveModel}")

                    }
            }
        }
    }
}