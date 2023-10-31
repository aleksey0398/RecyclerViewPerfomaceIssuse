package com.example.perfomanceissuse.presentation.recycli.product

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

class ProductItem {

    interface View {
        fun bindState(state: State)
    }

    @RecyclerItemState
    data class State(
        val id: String,
        val name: CharSequence,
        val priceNew: String,
        val priceOld: String,
        val imageUrl: String?,
    ) : RecyclerItem {
        override fun provideId(): String = id
    }
}
