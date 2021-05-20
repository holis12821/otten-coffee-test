package com.example.ottencoffeetest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ottencoffeetest.adapters.ProductListAdapter
import com.example.ottencoffeetest.adapters.ProductLoadStateAdapter
import com.example.ottencoffeetest.databinding.ActivityMainBinding
import com.example.ottencoffeetest.model.ProductsItem
import com.example.ottencoffeetest.utils.Constants
import com.example.ottencoffeetest.utils.OnItemClickListener
import com.example.ottencoffeetest.viewmodel.MainProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    //bind viewModel in this activity
    //use ktx extension to binding activity or fragment and viewModels
    private val viewModel by viewModels<MainProductViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //instance adapter
        val adapter = ProductListAdapter(this)
        //setup adapter to display recyclerView
        adapterProductList(adapter)

        viewModel.productList.observe(this, {
            adapter.submitData(this.lifecycle, it)
        })
    }

    private fun adapterProductList(adapter: ProductListAdapter){
        binding.apply {
            listProduct.setHasFixedSize(true)
            listProduct.itemAnimator = DefaultItemAnimator()
            listProduct.addItemDecoration(DividerItemDecoration(
                applicationContext, DividerItemDecoration.VERTICAL)
            )
            listProduct.layoutManager = LinearLayoutManager(this@MainActivity)
            listProduct.adapter = adapter.withLoadStateHeaderAndFooter(
                header = ProductLoadStateAdapter {
                    adapter.retry()
                },
                footer = ProductLoadStateAdapter {
                    adapter.retry()
                }
            )
        }
    }

    override fun onItemClick(productsItem: ProductsItem) {
        //initialize intent
        val intent = Intent(applicationContext, DetailActivity::class.java).apply {
            putExtra(Constants.Extra_Name_Product, productsItem.name)
            putExtra(Constants.EXTRA_IMAGE_PRODUCT, productsItem.image?.originalUrl)
            putExtra(Constants.EXTRA_BASE_PRICE_PRODUCT, productsItem.basePrice)
        }
        startActivity(intent)
    }
}