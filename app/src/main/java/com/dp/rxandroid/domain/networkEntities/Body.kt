package com.dp.rxandroid.domain.networkEntities


import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("token")
    var token: String? = null
)