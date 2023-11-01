package com.example.perfomanceissuse.presentation.recycli.ui.price

import com.detmir.recycli.annotations.RecyclerItemState

class PriceItem {

    interface View {
        fun bindState(state: State)
    }

    @RecyclerItemState
    data class State(
        val id: String,
        val old: String? = null,
        val new: String? = null,
    )
}
