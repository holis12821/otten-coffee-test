package com.example.ottencoffeetest.model.remote

import com.example.ottencoffeetest.BuildConfig
import com.example.ottencoffeetest.model.remote.ResponseDataList
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("product/products?catalog=new-product")
   suspend fun getProduct(
        @Query("page") page: Int,
    ): ResponseDataList
}