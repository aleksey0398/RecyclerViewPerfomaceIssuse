package com.example.perfomanceissuse.presentation.recycli.category2

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

class CategoryItem2 {

    interface View {
        fun bindState(state: State)
    }

    @RecyclerItemState
    data class State(
        val id: String,
        val title: CharSequence,
        val products: List<RecyclerItem>,
    ) : RecyclerItem {
        override fun provideId(): String = id
    }
}
