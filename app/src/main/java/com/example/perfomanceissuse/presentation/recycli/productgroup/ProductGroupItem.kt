package com.example.perfomanceissuse.presentation.recycli.productgroup

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

class ProductGroupItem {

    interface View {
        fun bindState(state: State)
    }

    @RecyclerItemState
    data class State(
        val id: String,
        val products: List<ProductItemState>
    ) : RecyclerItem {
        override fun provideId(): String = id
    }

    data class ProductItemState(
        val id: String,
        val name: CharSequence,
        val priceNew: String,
        val priceOld: String,
        val imageUrl: String?,
    )
}
