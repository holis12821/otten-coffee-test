package com.example.ottencoffeetest.model

import com.google.gson.annotations.SerializedName

data class Filter(
    @field:SerializedName("brands")
    val brands: List<BrandsItem?>? = null,

    @field:SerializedName("price")
    val price: Price? = null,

    @field:SerializedName("categories")
    val categories: List<CategoriesItem?>? = null
)
