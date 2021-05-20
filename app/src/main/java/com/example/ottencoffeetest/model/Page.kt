package com.example.ottencoffeetest.model

import com.google.gson.annotations.SerializedName

data class Page(

    @field:SerializedName("current")
    val current: Int? = null,

    @field:SerializedName("total")
    val total: Int? = null
)
