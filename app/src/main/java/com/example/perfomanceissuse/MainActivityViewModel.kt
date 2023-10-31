package com.example.perfomanceissuse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.detmir.recycli.adapters.RecyclerItem
import com.example.perfomanceissuse.domain.MyResult
import com.example.perfomanceissuse.domain.usecase.GetCategoriesUseCase
import com.example.perfomanceissuse.presentation.recycli.category.CategoryItem
import com.example.perfomanceissuse.presentation.recycli.loading.LoadingItem
import com.example.perfomanceissuse.presentation.recycli.product.ProductItem
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

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
                    is MyResult.Success -> _stateList.value = result.data.map {
                        CategoryItem.State(
                            id = it.id,
                            title = it.name,
                            products = it.products.map { product ->
                                ProductItem.State(
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
        }
    }
}
