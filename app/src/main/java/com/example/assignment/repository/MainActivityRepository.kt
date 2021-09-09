package com.example.assignment.repository

import com.example.assignment.httpRequest.RetrofitBuilder
import com.example.assignment.model.ResponseVO

class MainActivityRepository {
    suspend fun getDashBoardData():ResponseVO{
       return RetrofitBuilder.getRetrofit().getDashboardData()
    }
}