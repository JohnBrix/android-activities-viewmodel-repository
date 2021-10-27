package com.dp.rxandroid.domain.networkEntities


import com.google.gson.annotations.SerializedName

data class HttpAuthResponse(
    @SerializedName("body")
    var body: Body? = null,
    @SerializedName("message")
    var message: String? = null,
    @SerializedName("statusCode")
    var statusCode: String? = null
)