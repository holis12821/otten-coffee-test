package com.example.ottencoffeetest.model.remote

import com.example.ottencoffeetest.model.Data
import com.example.ottencoffeetest.model.Meta
import com.example.ottencoffeetest.model.Status
import com.google.gson.annotations.SerializedName

data class ResponseDataList(
    @field:SerializedName("data")
    val data: Data,

    @field:SerializedName("meta")
    val meta: Meta? = null,

    @field:SerializedName("errors")
    val errors: List<Any?>? = null,

    @field:SerializedName("status")
    val status: Status? = null
)
