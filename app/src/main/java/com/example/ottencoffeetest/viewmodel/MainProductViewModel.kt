
package com.example.ottencoffeetest.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ottencoffeetest.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainProductViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {
    val productList = repository.getProductList()
}