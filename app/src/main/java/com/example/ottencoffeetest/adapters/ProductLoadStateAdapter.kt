package com.example.ottencoffeetest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ottencoffeetest.databinding.ProductLoadStateFooterBinding

class ProductLoadStateAdapter(
    private val retry: () -> Unit
): LoadStateAdapter<ProductLoadStateAdapter.LoadStateViewHolder>()  {

    inner class LoadStateViewHolder(
       private val binding: ProductLoadStateFooterBinding
        ): RecyclerView.ViewHolder(binding.root) {
            init {
                binding.btnTryAgain.setOnClickListener {
                    retry()
                }
            }

            //binding view
            fun bind(loadState: LoadState) {
                with(binding) {
                    loadingFooter.isVisible = loadState is LoadState.Loading
                    //check apakah loadState merupakan instance dari object Loading yg bertipe LoadState()
                    btnTryAgain.isVisible = loadState !is LoadState.Loading
                    //jika loadstatenya tdk loading, karena bkn merupakan instance dari loadState object Loading ini
                    //sebenarnya instance tetapi di negasi jdi false yg sblmnya true
                    tvError.isVisible = loadState !is LoadState.Loading
                    //jika loadstatenya tdk loading, karena bkn merupakan instance dari loadState object Loading ini
                    //sebenarnya instance tetapi di negasi jdi false yg sblmnya true
                }
            }
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): LoadStateViewHolder {
       val binding = ProductLoadStateFooterBinding
           .inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadStateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
      holder.bind(loadState)
    }

}