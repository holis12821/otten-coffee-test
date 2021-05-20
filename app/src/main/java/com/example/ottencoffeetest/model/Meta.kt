package com.example.ottencoffeetest.model

import com.google.gson.annotations.SerializedName

data class Meta(
    @field:SerializedName("record")
    val record: Record? = null,

    @field:SerializedName("page")
    val page: Page? = null
)
