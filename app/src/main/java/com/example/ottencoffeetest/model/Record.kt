package com.example.ottencoffeetest.model

import com.google.gson.annotations.SerializedName

data class Record(
    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null
)
