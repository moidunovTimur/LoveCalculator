package com.example.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.repository.Repository

class LoveViewModel : ViewModel() {

   private val repository = Repository()

    fun liveLove(firstName:String,secondName:String): LiveData<LoveModel>{
        return repository.getLove(firstName,secondName)
    }
}