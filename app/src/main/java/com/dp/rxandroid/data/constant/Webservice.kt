package com.dp.rxandroid.data.constant

import com.dp.rxandroid.domain.networkEntities.HttpAuth
import com.dp.rxandroid.domain.networkEntities.HttpAuthRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Webservice {

    @POST("/api/auth")
    fun authenticate(@Body userData: HttpAuthRequest): Call<HttpAuth>
}