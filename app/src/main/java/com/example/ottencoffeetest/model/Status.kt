package com.example.ottencoffeetest.model

import com.google.gson.annotations.SerializedName

data class Status(
    @field:SerializedName("code")
    val code: String? = null,

    @field:SerializedName("hasErrors")
    val hasErrors: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null
)
