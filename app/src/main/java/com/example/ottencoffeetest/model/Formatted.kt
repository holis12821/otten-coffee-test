package com.example.ottencoffeetest.model

import com.google.gson.annotations.SerializedName

data class Formatted(
    @field:SerializedName("discountedPrice")
    val discountedPrice: String? = null,

    @field:SerializedName("basePrice")
    val basePrice: String? = null
)
