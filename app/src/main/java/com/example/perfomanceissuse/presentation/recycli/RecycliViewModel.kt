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
import com.example.perfomanceissuse.presentation.recycli.category.CategoryItem3
import com.example.perfomanceissuse.presentation.recycli.category1.CategoryItem1
import com.example.perfomanceissuse.presentation.recycli.category2.CategoryItem2
import com.example.perfomanceissuse.presentation.recycli.loading.LoadingItem
import com.example.perfomanceissuse.presentation.recycli.product.ProductItem
import com.example.perfomanceissuse.presentation.recycli.ui.ButtonItem
import com.example.perfomanceissuse.presentation.recycli.ui.price.PriceItem
import kotlinx.coroutines.launch

class RecycliViewModel : ViewModel() {

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
                    is MyResult.Success -> _stateList.value = mapCategoryDataToUi(result.data)
                }
            }
        }
    }

    private fun mapCategoryDataToUi(list: List<Category>): List<RecyclerItem> {
        return list.map { category ->
            when (category) {
                is Category.Category1 -> CategoryItem1.State(
                    id = category.id,
                    title = category.name,
                    products = mapProductDataToUi(category.products)
                )

                is Category.Category2 -> CategoryItem2.State(
                    id = category.id,
                    title = category.name,
                    products = mapProductDataToUi(category.products)
                )

                is Category.Category3 -> CategoryItem3.State(
                    id = category.id,
                    title = category.name,
                    products = mapProductDataToUi(category.products)
                )
            }
        }
    }

    private fun mapProductDataToUi(list: List<Product>): List<RecyclerItem> {
        return list.map { product ->
            ProductItem.State(
                id = product.id,
                name = product.name,
                priceState = PriceItem.State(
                    id = product.id + "_price",
                    old = product.priceOld,
                    new = product.priceNew
                ),
                imageUrl = product.imageUrl,
                buttonState = ButtonItem.State(
                    id = product.id + "_button",
                    text = product.name.take(8)
                )
            )
        }
    }
}
