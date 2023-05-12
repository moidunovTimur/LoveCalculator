package com.example.lovecalculator

import android.content.Context
import android.widget.Toast
import com.example.lovecalculator.ui.FirstFragment

class Utils {

    fun showToast(context:Context){
        Toast.makeText(context,"hello",Toast.LENGTH_SHORT).show()
    }
}