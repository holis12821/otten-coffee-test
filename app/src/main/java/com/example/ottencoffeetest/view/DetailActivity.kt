package com.example.ottencoffeetest.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ottencoffeetest.databinding.ActivityDetailBinding
import com.example.ottencoffeetest.utils.Constants
import java.text.NumberFormat
import java.util.*

class DetailActivity : AppCompatActivity() {
    private lateinit var binding:  ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        //use viewBinding to binding root layout
        setContentView(binding.root)
        //call function to retrieve data
        getData()
    }

    @SuppressLint("SetTextI18n")
   private fun getData() {
        val extra = intent.extras
        if (extra != null) {
            val imageProduct = extra.getString(Constants.EXTRA_IMAGE_PRODUCT)
            val nameProduct = extra.getString(Constants.Extra_Name_Product)
            val basePrice = extra.getInt(Constants.EXTRA_BASE_PRICE_PRODUCT)

            Glide.with(this)
                .load(imageProduct)
                .into(binding.imageViewDetail)

            //set Currency IDR
            val localFormat = Locale("in", "ID")
            val formatIDR = NumberFormat.getCurrencyInstance(localFormat)

            binding.tvNameProductDetail.text =  nameProduct
            binding.tvNameCicilan.text = "Cicilan dimulai dari : . ${formatIDR.format(basePrice)}"
            binding.basePriceDetail.text = formatIDR.format(basePrice)
        }
    }
}