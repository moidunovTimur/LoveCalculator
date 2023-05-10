package com.example.lovecalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lovecalculator.databinding.ActivityMainBinding

// LoveCalculator
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}