package com.example.assignment.modelview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.assignment.httpRequest.Resource
import com.example.assignment.httpRequest.RetrofitBuilder
import com.example.assignment.model.ResponseVO
import com.example.assignment.repository.MainActivityRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainActivityViewModel:ViewModel() {
    fun getDashboardData():LiveData<Resource<ResponseVO>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
          emit(Resource.success(MainActivityRepository().getDashBoardData()))
        }catch (e : Exception){
            emit(Resource.error(e.message.toString(),MainActivityRepository().getDashBoardData()))
        }
    }
}