package com.dp.rxandroid.domain.networkEntities


import com.google.gson.annotations.SerializedName

data class HttpAuthRequest(
    @SerializedName("password")
    private var password: String? = null,
    @SerializedName("username")
    private var username: String? = null
)