package com.example.ottencoffeetest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.ottencoffeetest.adapters.ProductListAdapter
import com.example.ottencoffeetest.databinding.ActivityMainBinding
import com.example.ottencoffeetest.viewmodel.MainProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //bind viewModel in this activity
    //use ktx extension to binding activity or fragment and viewModels
    private val viewModel by viewModels<MainProductViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ProductListAdapter()
        //setup adapter to display recyclerView
        adapterProductList(adapter)

        viewModel.productList.observe(this, {
            adapter.submitData(this.lifecycle, it)
        })
    }

    private fun adapterProductList(adapter: ProductListAdapter){
        binding.apply {
            listProduct.setHasFixedSize(true)
            listProduct.adapter = adapter
        }
    }
}