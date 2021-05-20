package com.example.ottencoffeetest.model

import com.google.gson.annotations.SerializedName

data class ProductsItem(

    @field:SerializedName("image")
    val image: Image? = null,

    @field:SerializedName("discountPercent")
    val discountPercent: Int? = null,

    @field:SerializedName("isInWishlist")
    val isInWishlist: Boolean? = null,

    @field:SerializedName("formatted")
    val formatted: Formatted? = null,

    @field:SerializedName("farmerProfile")
    val farmerProfile: Any? = null,

    @field:SerializedName("hasPriceRange")
    val hasPriceRange: Boolean? = null,

    @field:SerializedName("isPriceRequestable")
    val isPriceRequestable: Boolean? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("isOutOfStock")
    val isOutOfStock: Boolean? = null,

    @field:SerializedName("defaultVariantId")
    val defaultVariantId: Int? = null,

    @field:SerializedName("isComingSoon")
    val isComingSoon: Boolean? = null,

    @field:SerializedName("discountLabel")
    val discountLabel: Any? = null,

    @field:SerializedName("discountedPrice")
    val discountedPrice: Int? = null,

    @field:SerializedName("mustChooseVariantOrOption")
    val mustChooseVariantOrOption: Boolean? = null,

    @field:SerializedName("isFlashSale")
    val isFlashSale: Boolean? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("isPreorder")
    val isPreorder: Boolean? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("additionalLogo")
    val additionalLogo: Any? = null,

    @field:SerializedName("slug")
    val slug: String? = null,

    @field:SerializedName("basePrice")
    val basePrice: Int? = null
)
