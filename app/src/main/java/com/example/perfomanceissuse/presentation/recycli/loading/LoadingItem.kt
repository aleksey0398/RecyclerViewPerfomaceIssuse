package com.example.perfomanceissuse.presentation.recycli.loading

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

class LoadingItem {

    interface View{
        fun bindState(state: State)
    }

    @RecyclerItemState
    data class State(val id: String) : RecyclerItem {
        override fun provideId(): String = id
    }
}
