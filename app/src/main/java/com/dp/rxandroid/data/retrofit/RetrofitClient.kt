package com.dp.rxandroid.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {

    private val AUTHENTICATE_URI: String = "https://authenticate-v2.herokuapp.com"

    fun authenticateClient(): Retrofit {
        var client: OkHttpClient? = OkHttpClient.Builder()
            .connectTimeout(50, TimeUnit.SECONDS)
            .readTimeout(50, TimeUnit.SECONDS).build()

      /*  val chuckActivity = OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(context))
            .build()*/

        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(AUTHENTICATE_URI)
            .client(client)
     /*       .client(chuckActivity)*/
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}