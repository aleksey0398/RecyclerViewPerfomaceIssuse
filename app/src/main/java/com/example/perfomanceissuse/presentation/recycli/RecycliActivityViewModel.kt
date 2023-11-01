package com.example.perfomanceissuse.presentation.recycli

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.detmir.recycli.adapters.RecyclerItem
import com.example.perfomanceissuse.domain.MyResult
import com.example.perfomanceissuse.domain.model.Category
import com.example.perfomanceissuse.domain.model.Product
import com.example.perfomanceissuse.domain.usecase.GetCategoriesUseCase
import com.example.perfomanceissuse.presentation.recycli.category.CategoryItem
import com.example.perfomanceissuse.presentation.recycli.loading.LoadingItem
import com.example.perfomanceissuse.presentation.recycli.productgroup.ProductGroupItem
import kotlinx.coroutines.launch

class RecycliActivityViewModel : ViewModel() {

    private val useCase = GetCategoriesUseCase()

    private val _stateList: MutableLiveData<List<RecyclerItem>> = MutableLiveData()
    val stateList: LiveData<List<RecyclerItem>> = _stateList

    private val _errorStateList: MutableLiveData<Exception> = MutableLiveData()
    val errorStateList: LiveData<Exception> = _errorStateList

    init {
        viewModelScope.launch {
            useCase().collect { result ->
                when (result) {
                    is MyResult.Error -> _errorStateList.value = result.exception
                    MyResult.Loading -> _stateList.value = listOf(LoadingItem.State("loadingItemState"))
                    is MyResult.Success -> _stateList.value = mapSuccess(result.data)
                }
            }
        }
    }

    private fun mapSuccess(categories: List<Category>): List<RecyclerItem> {
        return categories.map {
            CategoryItem.State(
                id = it.id,
                title = it.name,
                products = mapProducts(it.products)
            )
        }
    }

    private fun mapProducts(list: List<Product>): List<RecyclerItem> {
        return list.chunked(3) { threeProducts ->
            ProductGroupItem.State(
                id = threeProducts.joinToString { it.id },
                products = threeProducts.map { product ->
                    ProductGroupItem.ProductItemState(
                        id = product.id,
                        name = product.name,
                        priceNew = product.priceNew,
                        priceOld = product.priceOld,
                        imageUrl = product.imageUrl,
                    )
                }
            )
        }
    }
}
