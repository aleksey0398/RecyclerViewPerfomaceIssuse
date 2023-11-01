package com.example.perfomanceissuse.presentation.recycli.product

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState
import com.example.perfomanceissuse.presentation.recycli.ui.ButtonItem
import com.example.perfomanceissuse.presentation.recycli.ui.price.PriceItem

class ProductItem {

    interface View {
        fun bindState(state: State)
    }

    @RecyclerItemState
    data class State(
        val id: String,
        val name: CharSequence,
        val priceState: PriceItem.State,
        val imageUrl: String?,
        val buttonState: ButtonItem.State,
    ) : RecyclerItem {
        override fun provideId(): String = id
    }
}
