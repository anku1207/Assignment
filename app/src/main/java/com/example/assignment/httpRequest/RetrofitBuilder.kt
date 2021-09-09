package com.example.assignment.httpRequest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {
    var retrofit :Retrofit? =null
    var apiCall :APICall ?=null
    val baseURL :String = "https://stg.knobee.app/"
    fun getRetrofit():APICall{
        if (apiCall==null){
            retrofit=Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            apiCall= retrofit!!.create(APICall::class.java)
        }

        return apiCall!!
    }


}