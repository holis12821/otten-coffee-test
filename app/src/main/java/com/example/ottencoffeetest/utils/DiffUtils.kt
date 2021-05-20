package com.example.ottencoffeetest.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.ottencoffeetest.model.ProductsItem

class DiffUtils {
    companion object {
      val COMPARATOR = object : DiffUtil.ItemCallback<ProductsItem>() {
            override fun areItemsTheSame(
                oldItem: ProductsItem,
                newItem: ProductsItem
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ProductsItem,
                newItem: ProductsItem
            ): Boolean = oldItem == newItem
        }
    }
}