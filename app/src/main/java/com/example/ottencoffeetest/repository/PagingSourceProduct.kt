package com.example.ottencoffeetest.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.ottencoffeetest.model.ProductsItem
import com.example.ottencoffeetest.model.remote.ProductService
import com.example.ottencoffeetest.utils.Constants
import retrofit2.HttpException
import java.io.IOException

/**
 * PagingDataSource to handle data*/

class PagingSourceProduct (
    private val productService: ProductService
    ): PagingSource<Int, ProductsItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductsItem> {
       return try {
          val position = params.key ?: Constants.STARTING_PAGE_INDEX
           val response = productService.getProduct(position)
           val productList = response.data.products
           LoadResult.Page(
               data = productList,
               prevKey = if (position == Constants.STARTING_PAGE_INDEX) null else position -1,
               nextKey = if (productList.isEmpty()) null else position + 1
           )
       } catch (e: IOException) {
           LoadResult.Error(e)
       } catch (e: HttpException) {
           LoadResult.Error(e)
       }
    }
    override fun getRefreshKey(state: PagingState<Int, ProductsItem>): Int? {
        return state.anchorPosition
    }
}