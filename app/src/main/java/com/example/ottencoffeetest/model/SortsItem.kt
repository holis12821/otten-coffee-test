package com.example.ottencoffeetest.model

import com.google.gson.annotations.SerializedName

data class SortsItem(
    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("value")
    val value: String? = null
)
