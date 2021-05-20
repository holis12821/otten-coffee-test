package com.example.ottencoffeetest.model

import com.google.gson.annotations.SerializedName

data class CategoriesItem(
    @field:SerializedName("children")
    val children: List<ChildrenItem?>? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("numberOfProducts")
    val numberOfProducts: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null
)
