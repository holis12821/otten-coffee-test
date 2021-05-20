package com.example.ottencoffeetest.model

import com.google.gson.annotations.SerializedName

data class AdditionalLogo(
    @field:SerializedName("miniThumbnailUrl")
    val miniThumbnailUrl: String? = null,

    @field:SerializedName("originalUrl")
    val originalUrl: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("thumbnailUrl")
    val thumbnailUrl: String? = null
)
