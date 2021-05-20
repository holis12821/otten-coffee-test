package com.example.ottencoffeetest.model

import com.google.gson.annotations.SerializedName

data class Data(
    @field:SerializedName("filter")
    val filter: Filter? = null,

    @field:SerializedName("sorts")
    val sorts: List<SortsItem?>? = null,

    @field:SerializedName("products")
    val products: List<ProductsItem>
)
