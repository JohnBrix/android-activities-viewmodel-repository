package com.dp.rxandroid.domain.networkEntities


import com.google.gson.annotations.SerializedName

data class HttpAuth(
    @SerializedName("response")
    var response: HttpAuthResponse? = null
)