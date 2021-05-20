package com.example.ottencoffeetest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.ottencoffeetest.R
import com.example.ottencoffeetest.databinding.ItemListProductBinding
import com.example.ottencoffeetest.model.ProductsItem
import com.example.ottencoffeetest.utils.DiffUtils

class ProductListAdapter: PagingDataAdapter<ProductsItem,
        ProductListAdapter.ProductHolderList>(DiffUtils.COMPARATOR) {

   inner class ProductHolderList (
       private val binding: ItemListProductBinding
   ): RecyclerView.ViewHolder(binding.root) {
       fun bind(productItem: ProductsItem) {
           //binding view
           with(binding) {
               Glide.with(itemView)
                   .load(productItem.image?.thumbnailUrl)
                   .into(imageProduct)
               productName.text = productItem.name
               basePrice.text = productItem.basePrice.toString()
           }
       }
   }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductHolderList {
        val binding = ItemListProductBinding
            .inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ProductHolderList(binding)
    }

    override fun onBindViewHolder(holder: ProductHolderList, position: Int) {
       val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

}