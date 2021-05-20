package com.example.ottencoffeetest.model

import com.google.gson.annotations.SerializedName

data class Price(
    @field:SerializedName("min")
    val min: Int? = null,

    @field:SerializedName("max")
    val max: Int? = null,

    @field:SerializedName("formatted")
    val formatted: Formatted? = null
)
