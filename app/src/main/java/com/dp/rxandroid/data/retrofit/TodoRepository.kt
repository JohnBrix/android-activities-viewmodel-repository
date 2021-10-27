package com.dp.rxandroid.data.retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dp.rxandroid.data.constant.Webservice
import com.dp.rxandroid.domain.networkEntities.HttpAuth
import com.dp.rxandroid.domain.networkEntities.HttpAuthRequest
import com.dp.rxandroid.domain.networkEntities.HttpAuthResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoRepository {

    private var retrofit = RetrofitClient()

    /*TODO 3RD INITIALIZE*/
    fun authenticate(
        request: HttpAuthRequest
    ): LiveData<HttpAuth> {
        Log.i("REQUESTA", "$request")
        var liveData = MutableLiveData<HttpAuth>()

        val userService: Webservice = retrofit.authenticateClient()
            .create(Webservice::class.java) /*THIS IS INSTALL CHUCK*/
        var call: Call<HttpAuth> =
            userService.authenticate(request) /*ENDPOINT METHOD FROM SPRING BOOT*/


        call.enqueue(object : Callback<HttpAuth> {
            override fun onResponse(
                call: Call<HttpAuth>,
                response: Response<HttpAuth>
            ) {
                if (response.code() == 200) {
                    Log.i("Authenticate: ", "${response.body()}")
                    liveData.value = response.body()
                } else if (response.code() == 404) {
                    Log.i("Authenticate: ", "${response.body()}")
                    liveData.value = response.body()
                } else if (response.code() == 400) {
                    Log.i("Authenticate: ", "${response.body()}")
                    liveData.value = response.body()
                } else {
                    Log.i("Authenticate: ", "${response.body()}")
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<HttpAuth>, t: Throwable) {
                Log.i("Authenticate: ", "${t.stackTrace} $call")
                /*Toast.makeText(context, "Response: ${t.stackTrace} $call", Toast.LENGTH_SHORT)
                    .show()*/
            }

        })

        Log.i("Authenticate return: ", "${liveData.value}}")
        return liveData
    }

     fun testMock(): HttpAuth {
        Log.i("TITE ", "PUMASOK DITO")
        var response = HttpAuthResponse()
            response.message = "Hi Im JOHN"
        response.statusCode = "200"
        var authRes = HttpAuth()
        authRes.response = response

        println("ajhdsiahdjahdaikfghfai")

        return authRes
    }
}