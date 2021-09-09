package com.example.assignment.httpRequest

import com.example.assignment.model.ResponseVO
import retrofit2.http.GET

interface APICall {
   @GET("dummyApi.json")
   suspend fun getDashboardData():ResponseVO
}