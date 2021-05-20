package com.example.ottencoffeetest.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.ottencoffeetest.model.remote.ProductService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val productService: ProductService) {
    fun getProductList() = Pager(
        config = PagingConfig(
            pageSize = 5,
            maxSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { PagingSourceProduct(productService) }
    ).liveData
}