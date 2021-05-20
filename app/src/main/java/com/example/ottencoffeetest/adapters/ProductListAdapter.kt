package com.example.ottencoffeetest.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ottencoffeetest.databinding.ItemListProductBinding
import com.example.ottencoffeetest.model.ProductsItem
import com.example.ottencoffeetest.utils.DiffUtils
import com.example.ottencoffeetest.utils.OnItemClickListener
import java.text.NumberFormat
import java.util.*

class ProductListAdapter(
    private val listener: OnItemClickListener
): PagingDataAdapter<ProductsItem,
        ProductListAdapter.ProductHolderList>(DiffUtils.COMPARATOR) {

   inner class ProductHolderList (
       private val binding: ItemListProductBinding
   ): RecyclerView.ViewHolder(binding.root) {

       init {
           /*
           karena menggunakan view binding jdi menggunakan binding
           yg sblmnya menggunakan itemView yg bertipe view yg diberikan ke ViewHolder di constructor nya
           untuk mendapatkan view layoutnya
           */
           binding.root.setOnClickListener {
               val position  = bindingAdapterPosition
               if (position != RecyclerView.NO_POSITION) {
                   val item = getItem(position)
                   if (item != null) {
                       listener.onItemClick(item)
                   }
               }
           }
       }

       @SuppressLint("SetTextI18n")
       fun bind(productItem: ProductsItem) {
           //binding view
           with(binding) {
               Glide.with(itemView)
                   .load(productItem.image?.thumbnailUrl)
                   .into(imageProduct)
               productName.text = productItem.name
               //set Currency IDR
               val localFormat = Locale("in", "ID")
               val formatIDR = NumberFormat.getCurrencyInstance(localFormat)
               productItem.basePrice?.let {
                   basePrice.text = formatIDR.format(it)
               }
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
       val productItem = getItem(position)
        if (productItem != null) {
            holder.bind(productItem)
        }
    }

}