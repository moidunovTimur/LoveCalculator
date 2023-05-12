package com.example.lovecalculator.di

import android.content.Context
import com.example.lovecalculator.Pref
import com.example.lovecalculator.Utils
import com.example.lovecalculator.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModel {

      @Provides
      fun provide() : LoveApi{
          return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
              .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
      }

    @Provides
    fun provideUtils(): Utils = Utils()

    @Singleton
    @Provides
    fun providePref(@ApplicationContext context: Context): Pref {
        return Pref(context)
    }
}