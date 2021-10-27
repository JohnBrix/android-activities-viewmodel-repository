package com.dp.rxandroid.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dp.rxandroid.data.retrofit.TodoRepository
import com.dp.rxandroid.domain.networkEntities.HttpAuth
import com.dp.rxandroid.domain.networkEntities.HttpAuthRequest

class MainActivityViewModel : ViewModel() {

    val repository: TodoRepository = TodoRepository()


    fun getAuthenticate(dto: HttpAuthRequest): LiveData<HttpAuth> {
        /*2ND INITIALIZE*/
        return repository.authenticate(dto)
    }

}